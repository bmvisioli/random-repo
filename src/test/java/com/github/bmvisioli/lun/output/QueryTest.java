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
	public void buildOneCountryFoundTest() {
		query = new Query("Netherlands");
		assertEquals("query Netherlands", query.build());
	}
	
	@Test
	public void buildTwoCountriesFoundTest() {
		query = new Query("Ira");
		assertEquals(String.format(Query.TOO_MANY_COUNTRIES_FOUND_MESSAGE, "Iraq, Iran"), query.build());
	}
	
	@Test
	public void getMatchingCountriesCountryFoundWithNameTest() {
		query = new Query("AR");
		assertEquals("AR", query.getMatchingCountries("Arge").get(0).getCode());
	}
	
	@Test
	public void getMatchingCountriesNoCountryFoundWithNameTest() {
		query = new Query("AR");
		assertEquals(0, query.getMatchingCountries("Arxx").size());
	}
	
	@Test
	public void getMatchingCountriesCountryFoundWithCodeTest() {
		query = new Query("AR");
		assertEquals("Argentina", query.getMatchingCountries("AR").get(0).getName());
	}
	
	@Test
	public void getMatchingCountriesNoCountryFoundWithCodeTest() {
		query = new Query("AR");
		assertEquals(0, query.getMatchingCountries("XX").size());
	}
}
