package com.github.bmvisioli.lun.model;

import java.util.ArrayList;
import java.util.List;

public class Country {

	private String code;
	private String name;
	private List<Airport> airportList;
	
	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}

	public List<Airport> getAirportList() {
		if(airportList == null) {
			airportList = new ArrayList<Airport>();
		}
		return airportList;
	}
	
}
