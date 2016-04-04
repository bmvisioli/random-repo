package com.github.bmvisioli.lun.output;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import com.github.bmvisioli.lun.input.CountryData;
import com.github.bmvisioli.lun.input.RunwayData;
import com.github.bmvisioli.lun.model.Country;
import com.github.bmvisioli.lun.model.Runway;

public class Report {

	public String build() {
		return "reports";
	}

	public List<String>getMostCommonRunwayLatitude(int size) {
		List<Runway> runwayList = new RunwayData().getRunwayList();
		return runwayList.stream()
		.collect(Collectors.groupingBy(Runway::getLeIdent, Collectors.counting()))
		.entrySet()
		.stream()
		.sorted((e1,e2) -> Long.compare(e2.getValue(),e1.getValue()))
		.limit(size)
		.map(entry -> entry.getKey())
		.collect(Collectors.toList());
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

	public List<Country> getCountriesByAirportCount(int size, boolean ascending) {
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
			.collect(Collectors.toList());
	}
}

