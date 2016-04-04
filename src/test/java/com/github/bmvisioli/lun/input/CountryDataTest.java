package com.github.bmvisioli.lun.input;

import java.util.List;
import org.junit.*;
import com.github.bmvisioli.lun.model.Country;
import com.github.bmvisioli.lun.output.Query;
import static org.junit.Assert.*;

public class CountryDataTest {

	private CountryData countryData = new CountryData();

	@Test
	public void readDataFromFileTest() {
		List<Country> countryList = countryData.readDataFromFile();
		assertEquals("AD", countryList.get(0).getCode());
		assertEquals("Andorra", countryList.get(0).getName());
		assertEquals(247, countryList.size());
	}
	
	@Test
	public void getMatchingCountriesCountryFoundWithNameTest() {
		assertEquals("AR", countryData.getMatchingCountries("arge").get(0).getCode());
	}
	
	@Test
	public void getMatchingCountriesNoCountryFoundWithNameTest() {
		assertEquals(0, countryData.getMatchingCountries("Arxx").size());
	}
	
	@Test
	public void getMatchingCountriesCountryFoundWithCodeTest() {
		assertEquals("Argentina", countryData.getMatchingCountries("AR").get(0).getName());
	}
	
	@Test
	public void getMatchingCountriesNoCountryFoundWithCodeTest() {
		assertEquals(0, countryData.getMatchingCountries("XX").size());
	}
}
