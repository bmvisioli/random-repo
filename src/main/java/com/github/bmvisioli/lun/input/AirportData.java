package com.github.bmvisioli.lun.input;

import java.util.ArrayList;
import java.util.List;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import com.github.bmvisioli.lun.model.Airport;

public class AirportData {
	
	private static List<Airport> airportList;
	
	public List<Airport> getAirportList() {
		if(airportList == null) {
			airportList = readDataFromFile();
		}
		return airportList;
	}

	private List<Airport> readDataFromFile() {
		List<Airport> result = new ArrayList<Airport>();
		
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("airport.xml");
        BeanReader in = factory.createReader("airport", ClassLoader.getSystemResource("airports.csv").getFile());
        Object record = null;
        
        //skip header line
        in.skip(1);
        
        while ((record = in.read()) != null) {
            result.add((Airport)record);
        }
        
        in.close();
		return result;
	}

}
