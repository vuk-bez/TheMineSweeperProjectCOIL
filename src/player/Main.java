package player;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import game.GameOutcome;

public class Main {

	public static void main(String[] args) {
		
		for(int i = 0; i < 1000; i++) {
			Player player = new Player(8, 6);
			boolean won = true;
			
			int count = 0;
			long startTime = System.nanoTime();
			for(int j = 0; j < 58; j++) {
				
				count++;
				GameOutcome outcome = player.playTurn();
				if(outcome == GameOutcome.DEFEAT) {
					won = false;
					break;
				}
				else if(outcome == GameOutcome.VICTORY) break;
				
			}
			long endTime = System.nanoTime();
			float elapsed = (float)(endTime - startTime) / 1000000;
			
			//MatchId,BotType,Result,TimeMs,TotalClicks
			//NOTE: There isn't any specifications in pdf about BotTypes, beside their existance
			//So for now, let it be UNDEFINED for every bot
			try {
				
				Path location = Paths.get("src/data");
				Path resultLocation = location.resolve("result.csv");
				
				FileWriter fw = new FileWriter(resultLocation.toFile(), true);
				fw.write(Integer.toString(i) + ",");
				fw.write("Undefined" + ",");
				if(won) fw.write(Integer.toString(1) + ",");
				else fw.write(Integer.toString(0) + ",");
				fw.write(Float.toString(elapsed) + ",");
				fw.write(Integer.toString(count) + "\n");
				
				fw.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
			
		}
	}

}
