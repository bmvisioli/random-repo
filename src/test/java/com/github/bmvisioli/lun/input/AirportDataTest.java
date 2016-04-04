package com.github.bmvisioli.lun.input;

import java.util.List;
import org.junit.*;
import com.github.bmvisioli.lun.model.Airport;
import static org.junit.Assert.*;

public class AirportDataTest {

	private AirportData airportData = new AirportData();

	@Test
	public void readDataFromFileTest() {
		List<Airport> airportList = airportData.getAirportList();
		assertEquals("Total Rf Heliport",airportList.get(0).getName());
		assertEquals("US",airportList.get(0).getCountry());
		assertEquals(46505,airportList.size());
	}
	
}
