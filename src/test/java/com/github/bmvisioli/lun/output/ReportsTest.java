package com.github.bmvisioli.lun.output;

import org.junit.*;
import static org.junit.Assert.*;

public class ReportsTest {

	private Report report = new Report();
	
	@Test
	public void buildTest() {
		assertEquals("reports", report.build());
	}
		
}
