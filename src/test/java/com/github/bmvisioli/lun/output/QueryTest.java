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
		query = new Query("AI");
		String expected = "Anguilla\n|- Wallblake Airport\n  |- 233591\n";
		assertEquals(expected, query.build());
	}
	
	@Test
	public void buildTwoCountriesFoundTest() {
		query = new Query("Ira");
		assertEquals(String.format(Query.TOO_MANY_COUNTRIES_FOUND_MESSAGE, "Iraq, Iran"), query.build());
	}
	
	@Test
	public void buildNoCountryFoundTest() {
		query = new Query("XX");
		assertEquals(Query.NO_COUNTRY_FOUND_MESSAGE, query.build());
	}
}
