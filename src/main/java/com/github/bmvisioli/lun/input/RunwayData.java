package com.github.bmvisioli.lun.input;

import java.util.ArrayList;
import java.util.List;
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
	
	private List<Runway> readDataFromFile() {
		List<Runway> result = new ArrayList<Runway>();
		
		StreamFactory factory = StreamFactory.newInstance();
        factory.loadResource("runway.xml");
        BeanReader in = factory.createReader("runway", ClassLoader.getSystemResource("runways.csv").getFile());
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
