package com.github.bmvisioli.lun.input;

import java.util.List;
import org.junit.*;
import com.github.bmvisioli.lun.model.Country;
import static org.junit.Assert.*;

public class CountryDataTest {

	private CountryData countryData = new CountryData();

	@Test
	public void readDataFromFileTest() {
		List<Country> countryList = countryData.readDataFromFile();
		assertEquals(302672	, countryList.get(0).getId());
		assertEquals("AD", countryList.get(0).getCode());
		assertEquals("Andorra", countryList.get(0).getName());
		assertEquals("EU", countryList.get(0).getContinent());
		assertEquals("http://en.wikipedia.org/wiki/Andorra", countryList.get(0).getWikipediaLink());
		assertEquals("", countryList.get(0).getKeywords());
	}
}
