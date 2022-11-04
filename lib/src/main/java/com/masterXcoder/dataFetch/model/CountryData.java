package com.masterXcoder.dataFetch.model;

public class CountryData {

	public String country;
    public long cases;
	public long todayCases;
    public long deaths;
    public long todayDeaths;
    public long recovered;
    public long active;
    public long critical;
    public long casesPerOneMillion;
    public long deathsPerOneMillion;
    public long totalTests;
    public long testsPerOneMillion;
    
    public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public long getCases() {
		return cases;
	}
	public void setCases(long cases) {
		this.cases = cases;
	}
	public long getTodayCases() {
		return todayCases;
	}
	public void setTodayCases(long todayCases) {
		this.todayCases = todayCases;
	}
	public long getDeaths() {
		return deaths;
	}
	public void setDeaths(long deaths) {
		this.deaths = deaths;
	}
	public long getTodayDeaths() {
		return todayDeaths;
	}
	public void setTodayDeaths(long todayDeaths) {
		this.todayDeaths = todayDeaths;
	}
	public long getRecovered() {
		return recovered;
	}
	public void setRecovered(long recovered) {
		this.recovered = recovered;
	}
	public long getActive() {
		return active;
	}
	public void setActive(long active) {
		this.active = active;
	}
	public long getCritical() {
		return critical;
	}
	public void setCritical(long critical) {
		this.critical = critical;
	}
	public long getCasesPerOneMillion() {
		return casesPerOneMillion;
	}
	public void setCasesPerOneMillion(long casesPerOneMillion) {
		this.casesPerOneMillion = casesPerOneMillion;
	}
	public long getDeathsPerOneMillion() {
		return deathsPerOneMillion;
	}
	public void setDeathsPerOneMillion(long deathsPerOneMillion) {
		this.deathsPerOneMillion = deathsPerOneMillion;
	}
	public long getTotalTests() {
		return totalTests;
	}
	public void setTotalTests(long totalTests) {
		this.totalTests = totalTests;
	}
	public long getTestsPerOneMillion() {
		return testsPerOneMillion;
	}
	public void setTestsPerOneMillion(long testsPerOneMillion) {
		this.testsPerOneMillion = testsPerOneMillion;
	}
	
    @Override
	public String toString() {
		return "CountryData {country=" + country + ", cases=" + cases + ", todayCases=" + todayCases + ", deaths="
				+ deaths + ", todayDeaths=" + todayDeaths + ", recovered=" + recovered + ", active=" + active
				+ ", critical=" + critical + ", casesPerOneMillion=" + casesPerOneMillion + ", deathsPerOneMillion="
				+ deathsPerOneMillion + ", totalTests=" + totalTests + ", testsPerOneMillion=" + testsPerOneMillion
				+ "}";
	}
}
