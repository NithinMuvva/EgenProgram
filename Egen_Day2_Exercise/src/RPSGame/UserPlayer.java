package RPSGame;

import java.util.Scanner;

public class UserPlayer implements RPSPlayer{
	
	private final Scanner scanner;

	public UserPlayer(Scanner scanner) {
	    this.scanner = scanner;
	}

	@Override
	public String playMove() {
		 System.out.println("Select R, P, or S for Rock, Paper, Scissors");
	     String choice = this.scanner.next();
	     return choice;
	}

}
