package com.github.bmvisioli.lun.input;

import java.util.List;
import org.junit.*;
import com.github.bmvisioli.lun.model.Runway;
import static org.junit.Assert.*;

public class RunwayDataTest {
	
	private RunwayData runwayData = new RunwayData();
	
	@Test
	public void getRunwayListTest() {
		List<Runway> runwayList = runwayData.getRunwayList();
		assertEquals(269408, runwayList.get(0).getId());
		assertEquals(6523, runwayList.get(0).getAirport());
		assertEquals("ASPH-G", runwayList.get(0).getSurface());
		assertEquals(39536, runwayList.size());
	}
	
	@Test
	public void getRunwayByAirportTest() {
		List<Runway> runwayList = runwayData.getRunwayByAirport(6523);
		assertEquals(269408, runwayList.get(0).getId());
		assertEquals(6523, runwayList.get(0).getAirport());
		assertEquals("ASPH-G", runwayList.get(0).getSurface());
		assertEquals(1, runwayList.size());
	}
	
}
