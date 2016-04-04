package com.github.bmvisioli.lun.input;

import java.util.List;
import org.junit.*;
import com.github.bmvisioli.lun.model.Airport;
import static org.junit.Assert.*;

public class AirportDataTest {

	private AirportData airportData = new AirportData();

	@Test
	public void getAirportListTest() {
		List<Airport> airportList = airportData.getAirportList();
		assertEquals("Total Rf Heliport",airportList.get(0).getName());
		assertEquals("US",airportList.get(0).getCountry());
		assertEquals(6523,airportList.get(0).getId());
		assertEquals(269408,airportList.get(0).getRunwayList().get(0).getId());
		assertEquals(46505,airportList.size());
	}
	
	@Test
	public void getAirportByCountryTest() {
		List<Airport> airportList = airportData.getAirportByCountry("US");
		assertEquals("Total Rf Heliport",airportList.get(0).getName());
		assertEquals("US",airportList.get(0).getCountry());
		assertEquals(6523,airportList.get(0).getId());
		assertEquals(269408,airportList.get(0).getRunwayList().get(0).getId());
		assertEquals(21501,airportList.size());
	}
	
}
