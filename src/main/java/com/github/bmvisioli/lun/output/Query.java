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
		Stream<Country> result;
		if (criteria.length() == 2) {
			result = countryStream.filter(country -> country.getCode().equals(criteria));
		} else {
			result = countryStream.filter(country -> country.getName().startsWith(criteria));
		}
		return result.collect(Collectors.toList());
	}
}
