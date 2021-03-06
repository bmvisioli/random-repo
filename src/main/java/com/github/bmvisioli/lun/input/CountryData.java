package com.github.bmvisioli.lun.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import com.github.bmvisioli.lun.model.Country;

public class CountryData {

	private static List<Country> countryList;
	
	public List<Country> getMatchingCountries(String criteria) {
		Stream<Country> countryStream = getCountryList().stream();
		return countryStream.filter(country -> 
			criteria.length() == 2 ? 
					country.getCode().toUpperCase().equals(criteria.toUpperCase()) :
					country.getName().toUpperCase().startsWith(criteria.toUpperCase())
		).collect(Collectors.toList());
	}
	
	public List<Country> getCountryList() {
		if(countryList == null) {
			countryList = readDataFromFile();
		}
		return countryList;
	}
	
	private List<Country> readDataFromFile() {
		List<Country> result = new ArrayList<Country>();
		
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("country.xml");
        BeanReader in = factory.createReader("country", new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("countries.csv"))));
        Object record = null;
        
        //skip header line
        in.skip(1);
        
        while ((record = in.read()) != null) {
        	Country country = (Country)record;
        	country.getAirportList().addAll(new AirportData().getAirportByCountry(country.getCode()));        	
        	result.add(country);
        }
        
        in.close();
		return result;
	}

}
