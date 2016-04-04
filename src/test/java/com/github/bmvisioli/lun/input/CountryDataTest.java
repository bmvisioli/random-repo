package com.github.bmvisioli.lun.input;

import java.util.List;
import org.junit.*;
import com.github.bmvisioli.lun.model.Country;
import static org.junit.Assert.*;

public class CountryDataTest {

	private CountryData countryData = new CountryData();

	@Test
	public void readDataFromFileTest() {
		List<Country> countryList = countryData.readDataFromFile();
		assertEquals("AD", countryList.get(0).getCode());
		assertEquals("Andorra", countryList.get(0).getName());
		assertEquals(247, countryList.size());
	}
}