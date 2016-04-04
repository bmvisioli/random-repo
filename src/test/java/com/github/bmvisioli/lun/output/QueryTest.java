package com.github.bmvisioli.lun.output;

import org.junit.*;
import static org.junit.Assert.*;

public class QueryTest {

	private Query query;
	
	@Test
	public void constructorTest() {
		query = new Query("India");
		assertEquals("India", query.getCountry());
	}
	
	@Test
	public void buildTest() {
		query = new Query("Netherlands");
		assertEquals("query Netherlands", query.build());
	}
	
	@Test
	public void getMatchingCountriesCountryFoundTest() {
		query = new Query("AR");
		assertEquals("AR", query.getMatchingCountries("Arge").get(0).getCode());
	}
	
	@Test
	public void getMatchingCountriesNoCountryFoundTest() {
		query = new Query("AR");
		assertEquals(0, query.getMatchingCountries("Axx").size());
	}
}
