package com.masterXcoder.gui.widget;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.masterXcoder.config.ConfigModel;
import com.masterXcoder.config.ConfigurationService;
import com.masterXcoder.dataFetch.DataServiceProvider;
import com.masterXcoder.dataFetch.model.CountryData;
import com.masterXcoder.dataFetch.model.CovidDataModel;
import com.masterXcoder.dataFetch.model.GlobalData;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

public class Controller4Widget implements Initializable{

	private ScheduledExecutorService executorService;
	private ConfigModel configModel;
	
	@FXML
	private AnchorPane rootPane;
	@FXML
	private Text globalReport;
	@FXML
	private Text countryReport;
	@FXML
	private Text countryCode;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			configModel = new ConfigurationService().getConfiguration();
		} catch(IOException e) {
			e.printStackTrace();
		}
		initializeScheduler();
		initializedContextMenu();
		countryCode.setText(configModel.getCountryCode());
	}

	private void initializedContextMenu() {
		MenuItem exitItem = new MenuItem("Exit");
		exitItem.setOnAction(event -> {
			System.exit(0);
		});
		
		MenuItem refreshItem = new MenuItem("Refresh");
		refreshItem.setOnAction(event -> {
			executorService.schedule(new Runnable() {

				@Override
				public void run() {
					loadData();
				}
			}, 0, TimeUnit.SECONDS);
		});
		
		final ContextMenu contextMenu = new ContextMenu(exitItem, refreshItem);
		rootPane.addEventHandler(MouseEvent.MOUSE_PRESSED, event -> {
			if(event.isSecondaryButtonDown()) {
				contextMenu.show(rootPane, event.getScreenX(), event.getScreenY());
			} else {
				if(contextMenu.isShowing()) {
					contextMenu.hide();
				}
			}
		});
	}

	private void initializeScheduler() {
		executorService = Executors.newSingleThreadScheduledExecutor();
		System.out.println(configModel.getCountryCode());
		executorService.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				loadData();
			}
		}, 0, configModel.getRefreshIntervalInSeconds(), TimeUnit.SECONDS);
	}
	
	private void loadData() {
		DataServiceProvider dataProvider = new DataServiceProvider();
		CovidDataModel covidDataModel = dataProvider.getData(configModel.getCountryName());
		Platform.runLater(() -> {
			inflateData(covidDataModel);
		});
	}
	
	private void inflateData(CovidDataModel covidDataModel) {
		GlobalData globalData = covidDataModel.getGlobalData();
		globalReport.setText(getFormattedData(globalData.getCases(), globalData.getRecovered(), globalData.getDeaths()));
		
		CountryData countryData = covidDataModel.getCountryData();
		countryReport.setText(getFormattedDataCountry(countryData.getTodayCases(), countryData.getActive(), countryData.getTodayDeaths()));
	}
	
	private String getFormattedData(long totalCases, long recoveredCases, long totalDeaths) {
		return String.format("Cases: %-8d | Recovered: %-6d | Deaths: %-6d", totalCases, recoveredCases, totalDeaths);
	}
	
	private String getFormattedDataCountry(long totalCases, long activeCases, long totalDeaths) {
		return String.format("Cases: %-8d | Active: %-6d | Deaths: %-6d", totalCases, activeCases, totalDeaths);
	}
}
