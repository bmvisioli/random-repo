package com.github.bmvisioli.lun.input;

import java.util.ArrayList;
import java.util.List;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import com.github.bmvisioli.lun.model.Country;

public class CountryData {

	public List<Country> readDataFromFile() {
		List<Country> result = new ArrayList<Country>();
		
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("country.xml");
        BeanReader in = factory.createReader("country", ClassLoader.getSystemResource("countries.csv").getFile());
        Object record = null;
        
        //skip header line
        in.skip(1);
        
        while ((record = in.read()) != null) {
            result.add((Country)record);
        }
        
        in.close();
		return result;
	}

}
