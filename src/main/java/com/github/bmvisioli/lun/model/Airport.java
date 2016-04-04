package com.github.bmvisioli.lun.model;

import java.util.ArrayList;
import java.util.List;

public class Airport {

	private String name;
	private String country;
	private List<Runway> runwayList;
	private int id;

	public String getName() {
		return name;
	}

	public String getCountry() {
		return country;
	}

	public List<Runway> getRunwayList() {
		if(runwayList == null) {
			runwayList = new ArrayList<Runway>();
		}
		return runwayList;
	}

	public int getId() {
		return id;
	}

}
