
public class Connect4Grid2DArray implements Connect4Grid
{
	//Private member variables
	private String [][] grid;
	private int [] countOfColumn;
	private int [] lastPlay;

	// Constructor
	public Connect4Grid2DArray()
	{
		grid = new String[6][7];
	    countOfColumn = new int [7];
	    lastPlay = new int [2];
	}

	@Override
	public void emptyGrid()
	{
		for (int i=0; i<6; i++)
		{
			for (int j=0; j<7; j++)
			{
				grid[i][j] = " ";  
			}
		}
		countOfColumn = new int [7];
	}
	   
	@Override
	public String toString()
	{
		String gridAsString = "";
		for (int i=0; i<6; i++)
			{
				for (int j=0; j<7; j++)
				{
					gridAsString += grid[i][j];
					gridAsString += "|";
				}
				gridAsString += "%n";
			}
		return gridAsString;
	}

	@Override
	public boolean isValidColumn(int column)
	{
		if (column-1<0 || column-1>7)
		{
			return false;
		}
		return true;
	}
	   
	@Override
	public boolean isColumnFull(int column)
	{
		if (!(column-1<0 || column-1>7))
		{
			if (countOfColumn[column-1] == 6)
			{
				return true;
			}
		}
		return false;
	}
	   
	@Override
	public void dropPiece(ConnectPlayer player, int column)
	{
		grid[(countOfColumn[column-1]==0)?  5 - countOfColumn[column-1]: 5 - countOfColumn[column-1]][column-1] = player.toString();
		lastPlay [0] = 5 - countOfColumn[column-1];
		lastPlay [1] = column-1;
		countOfColumn[column-1]++;
	}
	   
	@Override
	public boolean didLastPieceConnect4()
	{
		int count = 0;
		if (checkhorizontal() || checkDiagonallyUp() || checkDiagonallyDown())
		{
		count++;
		}
		if (lastPlay [0] <= 2)
		{
			if (checkDown())
			{
			count++;
			}
		}
		if (count>=1)
		{
			return true;
		}
		return false;
	}
	
	public boolean checkhorizontal()
	{
		int count = 0;
		boolean stop = false;
		for (int i=lastPlay [1]; i>=((lastPlay [1]-3<0)?0:lastPlay [1]-3); i--)
		{
			if ((grid [lastPlay [0]][lastPlay [1]] == grid [lastPlay [0]][i]) && stop == false)
			{
				count++;
			}
			else
			{
				stop = true;
			}
		}
		stop = false;
		for (int i=lastPlay [1]; i<=((lastPlay [1]+3>6)?6:lastPlay [1]+3); i++)
		{
			if ((grid [lastPlay [0]][lastPlay [1]] == grid [lastPlay [0]][i]) && stop == false)
			{
				count++;
			}
			else
			{
				stop = true;
			}
		}
		if(count>=5)
		{
			return true;
		}
		return false;
	}
	
	public boolean checkDown()
	{
		int count = 0;
		for (int i=1; i<4; i++)
		{
			if ((grid [lastPlay [0]][lastPlay [1]] == grid [lastPlay [0]+i][lastPlay [1]]))
			{
				count++;
			}
		}
		if(count>=3)
		{
			return true;
		}
		return false;
	}
	
	public boolean checkDiagonallyUp()
	{
		boolean stop = false;
		int count = 0;
		for (int i=lastPlay [1], j=lastPlay [0]; i>=((lastPlay [1]-3<0)?0:lastPlay [1]-3) && j<=((lastPlay [1]+3>5)?5:lastPlay [1]+3); i--, j++)
		{
			if ((grid [lastPlay [0]][lastPlay [1]] == grid [j][i]) && stop == false)
			{
				count++;
			}
			else
			{
				stop = true;
			}
		}
		stop = false;
		for (int i=lastPlay [1], j=lastPlay [0]; i<=((lastPlay [1]+3>6)?6:lastPlay [1]+3) && j>=((lastPlay [1]-3<0)?0:lastPlay [1]-3); i++, j--)
		{
			if ((grid [lastPlay [0]][lastPlay [1]] == grid [j][i]) && stop == false)
			{
				count++;
			}
			else
			{
				stop = true;
			}
		}
		if(count>=5)
		{
			return true;
		}
		return false;
	}
	
	public boolean checkDiagonallyDown()
	{
		boolean stop = false;
		int count = 0;
		for (int i=lastPlay [1], j=lastPlay [0]; i<=((lastPlay [1]+3>6)?6:lastPlay [1]+3) && j<=((lastPlay [1]+3>5)?5:lastPlay [1]+3); i++, j++)
		{
			if ((grid [lastPlay [0]][lastPlay [1]] == grid [j][i]) && stop == false)
			{
				count++;
			}
			else
			{
				stop = true;
			}
		}
		stop = false;
		for (int i=lastPlay [1], j=lastPlay [0]; i>=((lastPlay [1]-3<0)?0:lastPlay [1]-3) && j>=((lastPlay [1]-3<0)?0:lastPlay [1]-3); i--, j--)
		{
			if ((grid [lastPlay [0]][lastPlay [1]] == grid [j][i]) && stop == false)
			{
				count++;
			}
			else
			{
				stop = true;
			}
		}
		if(count>=5)
		{
			return true;
		}
		return false;
	}
	   
	@Override
	public boolean isGridFull()
	{
		int count = 0;
		for(int i=0; i<7; i++)
		{
			if (countOfColumn[i]==6)
			{
				count++;
			}
		}
		if (count==6)
		{
			return true;
		}
		return false;
	}
}
