
public abstract class ConnectPlayer 
{
	//Private member variables
	private String signal;
	
	// Constructor
	public ConnectPlayer(String signal)
	{
		this.signal = signal;
	}

	//Abstract method 
	public abstract void move(Connect4Grid2DArray grid, ConnectPlayer player);
		   
	//Regular method 
	public String toString()
	{
		return signal;
	}
}
