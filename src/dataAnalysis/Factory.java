package dataAnalysis;


import java.nio.file.*;
import java.io.IOException;

import java.util.stream.Stream;

public class Factory {
	
	public static MatchSummary parsingMatch(String matchSumStr) {
		String [] parts = matchSumStr.split(",");
		
		int matchld =  Integer.parseInt(parts[0].trim());
		String botType =  parts[1].trim();
		String result = parts[2].trim();
		long timeMs = (long) Double.parseDouble(parts[3].trim());
		int totalClicks = Integer.parseInt(parts[4].trim());
		
		return new MatchSummary(matchld, botType, result, timeMs, totalClicks);	
		
	}

	public static MatchDataset readMatchSummary(String csvPath){
		
		MatchDataset res = null;
		
        try {
            
            Stream<MatchSummary> md = Files.lines(Paths.get(csvPath))
                       
                       .filter(line -> !line.isBlank())
                       .map(Factory::parsingMatch);
                       
            	res = new MatchDataset(md);
        } catch (IOException e) {            
            e.printStackTrace();
        }
        return res;
	}
		
		
	
}
