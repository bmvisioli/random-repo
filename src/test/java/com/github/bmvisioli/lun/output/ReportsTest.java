package com.github.bmvisioli.lun.output;

import org.junit.*;
import static org.junit.Assert.*;

public class ReportsTest {

	private Report report = new Report();
	
	@Test
	public void buildTest() {
		assertEquals("reports", report.build());
	}
	
	@Test
	public void getTopCountriesByAirportQuantityTest() {
		String expected = "United States (21501), Brazil (3839), Canada (2454), Australia (1908), Russia (920)";
		assertEquals(expected, report.getCountriesByAirportCount(5, false));
	}
	
	@Test
	public void getTypesOfRunwayPerCountryTest() {
		String expected = "Andorra\nUnited Arab Emirates\n|-ASP";
		assertTrue(report.getTypesOfRunwayPerCountry().startsWith(expected));
	}
		
}
