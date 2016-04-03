package com.github.bmvisioli.lun.app;

import org.junit.*;
import static org.junit.Assert.*;

public class EntryPointTest {

	@Test
	public void handleInputNoOption() {
		String[] input = {};
		assertEquals(EntryPoint.WRONG_SYNTAX_MESSAGE, EntryPoint.handleInput(input));
	}
	
	@Test
	public void handleInputReportsOption() {
		String[] input = {"reports"};
		assertEquals("reports", EntryPoint.handleInput(input));
	}
	
	@Test
	public void handleInputQueryOption() {
		String[] input = {"query", "Brazil"};
		assertEquals("query", EntryPoint.handleInput(input));
	}
	
	@Test
	public void handleInputQueryOptionNoCountry() {
		String[] input = {"query"};
		assertEquals(EntryPoint.WRONG_SYNTAX_MESSAGE, EntryPoint.handleInput(input));
	}
}
