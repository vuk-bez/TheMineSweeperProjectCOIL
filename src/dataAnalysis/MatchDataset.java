package dataAnalysis;

import java.util.*;

import java.util.stream.Stream;;

public class MatchDataset {
	
	private List<MatchSummary> matches;
	
	public MatchDataset(Stream<MatchSummary> matchesSt) {
		matches = matchesSt.toList();  
	}
	//CONSTRUCTOR
	public MatchDataset(List<MatchSummary> matches) {
		super();
		this.matches = matches;
	}
	//GETTER
	public List<MatchSummary> getMatches() {
		return matches;
	}
	
	 public Double getAverageClicksByResult(String result) {
		 
		 Integer totalClicks = matches.stream()
				 .mapToInt(MatchSummary::totalClicks)
				 .sum();
				 
	
		 return matches.stream()
				 .filter(m -> m.result().equals(result))
				 .peek(m -> System.out.println("Passed filter: " + m))
				 .mapToDouble(m-> (m.totalClicks()))
		 		 .average()
		 		 .orElse(0.0);
		
	 }
	 
	 public MatchSummary getMatchWithHighestClickRate() {
		    return matches.stream()
		            
		            .max(Comparator.comparing(m -> {
		               
		            	double time = (m.timeMs() == 0) ? 1.0 : (double) m.timeMs();
		                return (double) m.totalClicks() / time;
		            }))
		           
		            .orElse(null);
		}

	
	
	
	

	
	
	
	
	
}
