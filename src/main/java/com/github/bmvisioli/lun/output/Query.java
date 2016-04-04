package com.github.bmvisioli.lun.output;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import com.github.bmvisioli.lun.input.CountryData;
import com.github.bmvisioli.lun.model.Country;

public class Query {

	public static final String TOO_MANY_COUNTRIES_FOUND_MESSAGE = "Found more than one country (%s) for this criteria. Please be more specific.";

	public static final String NO_COUNTRY_FOUND_MESSAGE = "Found no country that matches the criteria.";
	
	private String countryCriteria;

	public Query(String country) {
		this.countryCriteria = country;
	}

	public String getCountry() {
		return countryCriteria;
	}

	public String build() {
		String result;
		List<Country> matchingCountries = getMatchingCountries(countryCriteria);
		switch(matchingCountries.size()) {
			case 1:
				result = "query " + getMatchingCountries(countryCriteria).get(0).getName();
				break;
			case 0:
				result = NO_COUNTRY_FOUND_MESSAGE;
				break;
			default:
				result = String.format(TOO_MANY_COUNTRIES_FOUND_MESSAGE, 
						String.join(", ", matchingCountries.stream()
								.map(Country::getName)
								.collect(Collectors.toList())));
				break;
		}
		
		return result;
	}

	protected List<Country> getMatchingCountries(String criteria) {
		Stream<Country> countryStream = new CountryData().readDataFromFile().stream();
		return countryStream.filter(country -> 
			criteria.length() == 2 ? 
					country.getCode().toUpperCase().equals(criteria.toUpperCase()) :
					country.getName().toUpperCase().startsWith(criteria.toUpperCase())
		).collect(Collectors.toList());
	}
}
