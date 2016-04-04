package com.github.bmvisioli.lun.input;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import com.github.bmvisioli.lun.model.Runway;

public class RunwayData {

	private static List<Runway> runwayList;
	
	public List<Runway> getRunwayList() {
		if(runwayList == null) {
			runwayList = readDataFromFile();
		}
		return runwayList;
	}
	
	public List<Runway> getRunwayByAirport(int airportId) {
		return getRunwayList().stream()
				.filter(runway -> runway.getAirport() == airportId)
				.collect(Collectors.toList());
	}
	
	private List<Runway> readDataFromFile() {
		List<Runway> result = new ArrayList<Runway>();
		
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("runway.xml");
        BeanReader in = factory.createReader("runway", new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("runways.csv"))));
        Object record = null;
        
        //skip header line
        in.skip(1);
        
        while ((record = in.read()) != null) {
            result.add((Runway)record);
        }
        
        in.close();
		return result;
	}

}
