package RPSGame;

import java.util.Scanner;

public class PlayGround {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {
			
			PlayGame game = new PlayGame();
			System.out.println("ROCK --> Paper --> SCISSOR");
			System.out.println("Please select type of game 1[Multiplayer] 2[Computer]");
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
			System.out.println("Please enter the valid input type ");
			System.out.println(e.getMessage().toString());
		}
		finally {
			sc.close();
		}

	}
}
