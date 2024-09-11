import java.util.Scanner;

public class Connect4Game {
	
	public static final Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("Welcome to Connect Four Two Player.");
		boolean finished = false;
		ConnectPlayer player1 = null;
		ConnectPlayer player2 = null;
		while (!finished)
		{
			System.out.println("Would you like to play a game? (y/n) ");
			String userInput = input.next();
			input.nextLine();
			if (userInput.equals("n"))
			{
				finished = true;
			}
			else if (userInput.equals("y"))
			{
				while (!finished)
				{
					System.out.println("Is there a human for Player 1? (y/n) ");
					userInput = input.next();
					input.nextLine();
					if (userInput.equals("n"))
					{
						player1 = new C4RandomAIPlayer("x");
						finished = true;
					}
					else if (userInput.equals("y"))
					{
						player1 = new C4HumanPlayer("x");
						finished = true;
					}
					else
					{
						System.out.println("Please type either y or n.");
					}
				}
				finished = false;
				while (!finished)
				{
					System.out.println("Is there a human for Player 2? (y/n) ");
					userInput = input.next();
					input.nextLine();
					if (userInput.equals("n"))
					{
						player2 = new C4RandomAIPlayer("o");
						finished = true;
					}
					else if (userInput.equals("y"))
					{
						player2 = new C4HumanPlayer("o");
						finished = true;
					}
					else
					{
						System.out.println("Please type either y or n.");
					}
				}
				finished = false;
				runGame(player1,player2);
			}
			else
			{
				System.out.println("Please type either y or n.");
			}
		}
		input.close();
	}
	
	public static void runGame(ConnectPlayer player1, ConnectPlayer  player2)
	{
		Connect4Grid2DArray grid = new Connect4Grid2DArray();
		grid.emptyGrid();
		boolean finished = false;
		String winner = "";
		while(!finished)
		{
			System.out.printf(grid.toString());
			System.out.println("Player 1's turn.");
			player1.move(grid, player1);
			if (grid.didLastPieceConnect4())
			{
				finished = true;
				winner = "Player 1";
			}
			else if (!grid.isGridFull())
			{
				System.out.printf(grid.toString());
				System.out.println("Player 2's turn.");
				player2.move(grid, player2);
				if (grid.didLastPieceConnect4())
				{
					winner = "Player 2";
					finished = true;
				}
			}
			else
			{
				finished = true;
			}
		}
		finished = false;
		System.out.printf(grid.toString());
		System.out.println((winner==""?"NO WINNER":"Congrats," + winner + " won."));
	}
}
/* SELF ASSESSMENT

Connect4Game class (35 marks)
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside
a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised
- must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece.
I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment: It fulfills all criteria.

Connect4Grid interface (10 marks)
I define all 7 methods within this interface.
Comment: I do.

Connect4Grid2DArray class (25 marks) 
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the
column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full.
It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment:It fulfills all criteria.

ConnectPlayer abstract class (10 marks)
My class provides at lest one non-abstract method and at least one abstract method. 
Comment:It does.

C4HumanPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides the Human player functionality.
Comment:It does.

C4RandomAIPlayer class (10 marks)
My class extends the ConnectPlayer class and overrides the abstract method(s). It provides AI player functionality. 
Comment:It does.

Total Marks out of 100:100

*/