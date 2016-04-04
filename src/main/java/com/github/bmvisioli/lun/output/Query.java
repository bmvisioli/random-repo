package com.github.bmvisioli.lun.output;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.github.bmvisioli.lun.input.CountryData;
import com.github.bmvisioli.lun.model.Country;

public class Query {

	private String country;

	public Query(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public String build() {
		return "query " + getMatchingCountries(country).get(0).getName();
	}

	protected List<Country> getMatchingCountries(String criteria) {
		Stream<Country> countryStream = new CountryData().readDataFromFile().stream();
		return countryStream.filter(country -> 
			criteria.length() == 2 ? 
					country.getCode().equals(criteria) :
					country.getName().startsWith(criteria)
		).collect(Collectors.toList());
	}
}
