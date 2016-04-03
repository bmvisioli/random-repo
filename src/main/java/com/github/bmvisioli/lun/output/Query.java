package com.github.bmvisioli.lun.output;

public class Query {

	private String country;
	
	public Query(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return country;
	}

	public String build() {
		return "query " + country;
	}

}
