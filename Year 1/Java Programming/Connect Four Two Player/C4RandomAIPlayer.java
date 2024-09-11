import java.util.concurrent.ThreadLocalRandom;

public class C4RandomAIPlayer extends ConnectPlayer
{
	// Constructor
	public C4RandomAIPlayer(String signal)
	{
		super(signal);
	}

	//Abstract method, overridden
	@Override
	public void move(Connect4Grid2DArray grid, ConnectPlayer player)
	{
		boolean finished = false;
		while (!finished)
		{
			int randomNum = ThreadLocalRandom.current().nextInt(1, 7 + 1);
			if (!(grid.isColumnFull(randomNum)) && grid.isValidColumn(randomNum))
			{
				grid.dropPiece(player, randomNum);
				finished = true;
			}
		}
	}
}
