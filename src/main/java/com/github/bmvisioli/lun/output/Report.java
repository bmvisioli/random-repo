package com.github.bmvisioli.lun.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.github.bmvisioli.lun.input.CountryData;
import com.github.bmvisioli.lun.model.Country;

public class Report {

	public String build() {
		return "reports";
	}
	
	public String getTypesOfRunwayPerCountry() {
		StringBuilder result = new StringBuilder();
		List<Country> countryList = new CountryData().getCountryList();
		countryList.forEach(country -> {
			result.append(country.getName() + "\n");
			List<String> runwayTypeList = new ArrayList<String>();
			country.getAirportList().forEach(airport -> 
				airport.getRunwayList().forEach(runway -> 
					runwayTypeList.add(runway.getSurface())
				)
			);
			runwayTypeList.stream().distinct().forEach(type -> result.append("|-" + type + "\n"));
		});
		return result.toString();
	}

	public String getCountriesByAirportCount(int size, boolean ascending) {
		List<Country> countryList = new CountryData().getCountryList();
		return countryList.stream()
			.sorted((e1, e2) -> {
				if(ascending) {
					return Integer.compare(e1.getAirportList().size(),e2.getAirportList().size());
				} else {
					return Integer.compare(e2.getAirportList().size(),e1.getAirportList().size());
				}
			})
			.limit(size)
			.map(country -> country.getName() + " (" + country.getAirportList().size() + ")")
			.collect(Collectors.joining(", "));
	}
}

