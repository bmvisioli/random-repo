package com.github.bmvisioli.lun.app;

import org.junit.*;
import static org.junit.Assert.*;

public class EntryPointTest {

	@Test
	public void handleInputNoOption() {
		String[] emptyArgs = {};
		assertEquals(EntryPoint.NO_OPTION_MESSAGE,EntryPoint.handleInput(emptyArgs));
	}
	
}
