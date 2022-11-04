package com.masterXcoder.config;

public class ConfigModel {

	private int refreshIntervalInSeconds;
	private String countryName;
	private String countryCode;
	
	
	
	public ConfigModel() {

		this.refreshIntervalInSeconds = 300;
		this.countryName = "Malaysia";
		this.countryCode = "MY";
	}
	public int getRefreshIntervalInSeconds() {
		return refreshIntervalInSeconds;
	}
	public void setRefreshIntervalInSeconds(int refreshIntervalInSeconds) {
		this.refreshIntervalInSeconds = refreshIntervalInSeconds;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
}
