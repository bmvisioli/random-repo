package com.github.bmvisioli.lun.app;

import org.junit.*;
import static org.junit.Assert.*;

public class EntryPointTest {

	@Test
	public void handleInputNoOptionTest() {
		String[] input = {};
		assertEquals(EntryPoint.WRONG_SYNTAX_MESSAGE, EntryPoint.handleInput(input));
	}
	
	@Test
	public void handleInputReportsOptionTest() {
		String[] input = {"reports"};
		assertTrue(EntryPoint.handleInput(input).startsWith("Top 10 countries"));
	}
	
	@Test
	public void handleInputQueryOptionTest() {
		String[] input = {"query", "Brazil"};
		assertTrue(EntryPoint.handleInput(input).startsWith("Brazil"));
	}
	
	@Test
	public void handleInputQueryOptionNoCountryTest() {
		String[] input = {"query"};
		assertEquals(EntryPoint.WRONG_SYNTAX_MESSAGE, EntryPoint.handleInput(input));
	}
}
