package RPSGame;

import java.util.Scanner;

import org.apache.log4j.Logger;

import oopsConcepts.CarpetCostCalculator.CarpetCostCalculator;

public class PlayGround {

	private static Logger logger = Logger.getLogger(PlayGround.class);
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			
			PlayGame game = new PlayGame();
			logger.info("ROCK --> Paper --> SCISSOR");
			logger.info("Please select type of game 1[Multiplayer] 2[Computer]");
			int option = sc.nextInt();

			RPSPlayer player1 = new UserPlayer(sc);
			if( option == 1) {
				RPSPlayer player2 = new UserPlayer(sc);
				game.Play(player1, player2);
			}else {
				RPSPlayer player2 = new ComputerPlayer();
				game.Play(player1, player2);
			}

		}
		catch (Exception e) {
			// TODO: handle exception
			logger.error("Please enter the valid input type ");
			logger.error(e.getMessage().toString());
		}
		finally {
			sc.close();
		}

	}
}
