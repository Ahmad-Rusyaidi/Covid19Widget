package com.masterXcoder.dataFetch;

import com.masterXcoder.dataFetch.model.CountryData;
import com.masterXcoder.dataFetch.model.GlobalData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface CovidAPI {

	@GET("https://coronavirus-19-api.herokuapp.com/all")
	Call<GlobalData> getGlobalData();
	
	@GET("https://coronavirus-19-api.herokuapp.com/countries/{countryName}")
	Call<CountryData> getCountryData(@Path(value = "countryName") String countryName);
}
