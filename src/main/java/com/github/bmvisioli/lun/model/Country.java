package com.github.bmvisioli.lun.model;

public class Country {

	private int id;
	private String code;
	private String name;
	private String continent;
	private String wikipediaLink;
	private String keywords;
	
	public Country(int id, String code, String name, String continent, String wikipediaLink, String keywords) {
		this.id = id;
		this.keywords = keywords;
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.wikipediaLink = wikipediaLink;
	}

	public int getId() {
		return id;
	}

	public String getKeywords() {
		return keywords;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public String getContinent() {
		return continent;
	}

	public String getWikipediaLink() {
		return wikipediaLink;
	}

}
