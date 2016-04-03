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
}
