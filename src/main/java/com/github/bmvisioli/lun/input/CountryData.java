package com.github.bmvisioli.lun.input;

import java.util.ArrayList;
import java.util.List;
import com.github.bmvisioli.lun.model.Country;

public class CountryData {

	public List<Country> readDataFromFile() {
		List<Country> result = new ArrayList<Country>();
		result.add(new Country(302672,"AD","Andorra","EU","http://en.wikipedia.org/wiki/Andorra",""));
		return result;
	}

}
