package com.masterXcoder;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Launch extends Application{
	
	private double xOffSet;
	private double yOffSet;

	@Override
	public void start(Stage stage) throws Exception {
		
		stage.initStyle(StageStyle.UTILITY);
		stage.setOpacity(0);
		stage.show();
		
		Stage secStage = new Stage();
		secStage.initStyle(StageStyle.UNDECORATED);
		secStage.initOwner(stage);
		
		Parent root =FXMLLoader.load(getClass().getResource("/com/masterXcoder/gui/widget/Widget.fxml"));
		Scene scene = new Scene(root);
		secStage.setScene(scene);
		secStage.show();
		
		//make it right-top aligned
		Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
		secStage.setX(visualBounds.getMaxX() - 25 - scene.getWidth());
		secStage.setY(visualBounds.getMinY() + 25);
		
		//add support for drag and move
		scene.setOnMousePressed(event -> {
			xOffSet = secStage.getX() - event.getScreenX();
			yOffSet = secStage.getY() - event.getScreenY();
		});
		scene.setOnMouseDragged(event -> {
			secStage.setX(event.getScreenX() + xOffSet);
			secStage.setY(event.getScreenY() + yOffSet);
		});
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
