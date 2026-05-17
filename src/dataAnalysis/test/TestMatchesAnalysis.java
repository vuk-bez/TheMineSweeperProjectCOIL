package dataAnalysis.test;

import dataAnalysis.*;
import game.GameOutcome;
public class TestMatchesAnalysis {

	
	public static void test1(MatchDataset m) {
		System.out.println(m.getAverageClicksByResult("1"));
	}
	
	public static void test2(MatchDataset m) {
		System.out.println(m.getMatchWithHighestClickRate());
	}
	
	public static void main(String[] args) {

		MatchDataset m = Factory.readMatchSummary("src/data/result.csv");
		
		test1(m);
		test2(m);
	}

}
