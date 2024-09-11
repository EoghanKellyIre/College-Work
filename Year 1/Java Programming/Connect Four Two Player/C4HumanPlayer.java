import java.util.InputMismatchException;
public class C4HumanPlayer extends ConnectPlayer
{	
	// Constructor
	public C4HumanPlayer(String signal)
	{
		super(signal);
	}

	//Abstract method, overridden
	@Override
	public void move(Connect4Grid2DArray grid, ConnectPlayer player)
	{
		System.out.println("Which column would you like to play? (1/2/3/4/5/6/7)");
		boolean finished = false;
		while (!finished)
		{
			try
			{
				int column = Connect4Game.input.nextInt();
				Connect4Game.input.nextLine();
				if (!(grid.isColumnFull(column))&&grid.isValidColumn(column))
				{
					grid.dropPiece(player, column);
					finished = true;
				}
				else
				{
					System.out.println("Please enter a valid column");
				}
			}

			catch (InputMismatchException a) {
				System.out.println("Please enter: (1/2/3/4/5/6/7)");
			}
		}
	}
}
