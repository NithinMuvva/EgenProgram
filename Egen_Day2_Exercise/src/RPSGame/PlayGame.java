package RPSGame;

enum Game 
{ 
	R, P, S; 
} 
public class PlayGame {

	public PlayGame() {

	}

	public void Play(RPSPlayer user1, RPSPlayer user2) {

		System.out.print("Player1 move");
		String move1 = user1.playMove();
		System.out.print("Player2 move");
		String move2 = user2.playMove();

		if (move1 == move2)
		{
			System.out.print("It is a tie");
		} else {
			switch (move1){
			case "R":
				if (move2 == "S")
					System.out.print("Player 1 wins!");
				else
					System.out.print("Player 2 wins!");
				break;
			case "S":
				if (move2 == "P")
					System.out.print("Player 1 wins!");
				else
					System.out.print("Player 2 wins!");
				break;
			case "P":
				if (move2 == "R")
					System.out.print("Player 1 wins!");
				else
					System.out.print("Player 2 wins!");
				break;
			}
		}
	}


}
