package com.github.bmvisioli.lun.output;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.github.bmvisioli.lun.input.CountryData;
import com.github.bmvisioli.lun.input.RunwayData;
import com.github.bmvisioli.lun.model.Country;
import com.github.bmvisioli.lun.model.Runway;

public class Report {
	
	public String build() {
		StringBuilder result = new StringBuilder();
		result.append("Top 10 countries by airport count: ");
		result.append(getCountriesByAirportCount(10, false).stream()
			.map(country -> country.getName() + " ("+country.getAirportList().size()+")")
			.collect(Collectors.joining(", ")));
		result.append("\n\n");
		result.append("Bottom 10 countries by airport count: ");
		result.append(getCountriesByAirportCount(10, true).stream()
			.map(country -> country.getName() + " ("+country.getAirportList().size()+")")
			.collect(Collectors.joining(", ")));
		result.append("\n\n");
		result.append("Runway types per country: ");
		getTypesOfRunwayPerCountry().forEach((country, list) -> {
			result.append("\n\t" + country.getName() + ": " + String.join(", ",list));
		});
		result.append("\n\n");
		result.append("The 10 most common runway latitudes: " + String.join(", ",getMostCommonRunwayLatitude(10)));
		return result.toString();
	}

	public List<String> getMostCommonRunwayLatitude(int size) {
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
	
	public Map<Country, List<String>> getTypesOfRunwayPerCountry() {
		Map<Country, List<String>> result = new HashMap<Country, List<String>>();
		List<Country> countryList = new CountryData().getCountryList();
		countryList.forEach(country -> {
			List<String> runwayTypeList = new ArrayList<String>();
			country.getAirportList().forEach(airport -> 
				airport.getRunwayList().forEach(runway -> 
					runwayTypeList.add(runway.getSurface())
				)
			);
			result.put(country, runwayTypeList.stream().distinct().collect(Collectors.toList()));
		});
		return result;
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

