package RPSGame;

import java.util.Random;

public class ComputerPlayer implements RPSPlayer{

	@Override
	public String playMove() {
		// TODO Auto-generated method stub
		return Moves[new Random().nextInt(Moves.length)];
	}

}
