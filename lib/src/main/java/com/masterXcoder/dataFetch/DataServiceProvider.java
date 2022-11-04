package com.masterXcoder.dataFetch;

import java.util.concurrent.CompletableFuture;
import com.masterXcoder.dataFetch.model.CountryData;
import com.masterXcoder.dataFetch.model.CovidDataModel;
import com.masterXcoder.dataFetch.model.GlobalData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataServiceProvider {

	public CovidDataModel getData(String countryName) {
		Retrofit retrofit = new Retrofit.Builder().baseUrl("https://coronavirus-19-api.herokuapp.com/")
				.addConverterFactory(GsonConverterFactory.create()).build();
		
		CovidAPI covidApi = retrofit.create(CovidAPI.class);
		
		CompletableFuture<GlobalData> callback1 = new CompletableFuture<>();
		covidApi.getGlobalData().enqueue(new Callback<GlobalData>() {

			@Override
			public void onFailure(Call<GlobalData> arg0, Throwable arg1) {
				callback1.completeExceptionally(arg1);
			}

			@Override
			public void onResponse(Call<GlobalData> arg0, Response<GlobalData> arg1) {
				callback1.complete(arg1.body());
				System.out.println(arg1.body());
			}
		});
		
		CompletableFuture<CountryData> callback2 = new CompletableFuture<>();
		covidApi.getCountryData(countryName).enqueue(new Callback<CountryData>() {

			@Override
			public void onFailure(Call<CountryData> arg0, Throwable arg1) {
				callback2.completeExceptionally(arg1);
			}

			@Override
			public void onResponse(Call<CountryData> arg0, Response<CountryData> arg1) {
				callback2.complete(arg1.body());
				System.out.println(arg1.body());
			}
		});
		
		GlobalData globalData = callback1.join();
		CountryData countryData = callback2.join();
		
		return new CovidDataModel(globalData, countryData);
	}
}
