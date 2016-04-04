package com.github.bmvisioli.lun.output;

import java.util.List;
import org.junit.*;
import com.github.bmvisioli.lun.input.CountryData;
import com.github.bmvisioli.lun.model.Country;
import static org.junit.Assert.*;

public class ReportsTest {

	private Report report = new Report();
	
	@Test
	public void buildTest() {
		assertTrue(report.build().startsWith("Top 10 countries"));
	}
	
	@Test
	public void getMostCommonRunwayLatitudeTest() {
		List<String> result = report.getMostCommonRunwayLatitude(5);
		assertEquals("H1", result.get(0));
		assertEquals("16", result.get(4));
		assertEquals(5, result.size());
	}
	
	@Test
	public void getCountriesByAirportCountDescendingTest() {
		List<Country> topCountries = report.getCountriesByAirportCount(5, false);
		assertEquals("US", topCountries.get(0).getCode());
		assertEquals("BR", topCountries.get(1).getCode());
		assertEquals(5, topCountries.size());
	}
	
	@Test
	public void getCountriesByAirportCountAscendingTest() {
		List<Country> bottomCountries = report.getCountriesByAirportCount(5, true);
		assertEquals("GS", bottomCountries.get(0).getCode());
		assertEquals("AI", bottomCountries.get(4).getCode());
		assertEquals(5, bottomCountries.size());
	}
	
	@Test
	public void getTypesOfRunwayPerCountryTest() {
		Country peru = new CountryData().getMatchingCountries("PE").get(0);
		assertEquals("ASP",report.getTypesOfRunwayPerCountry().get(peru).get(0));
	}
		
}
