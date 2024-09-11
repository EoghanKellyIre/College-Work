//import java.util.LinkedList;
import java.util.Scanner;

public class StoringGraph
{
	private final int intersections;
	private int streets; 
	private boolean isValid;
	public Graph graph;
	//LinkedList<Graph.Edge> [] adjacencylist;
	
	public StoringGraph(Scanner input) 
	{
		this.intersections = input.nextInt();
		this.streets = input.nextInt();
		this.isValid = true;
		
		if(this.intersections < 3)
		{
			this.isValid = false;
		}
		else
		{
			for (int i = 0; i < streets; i++)
			{
				int from = input.nextInt();
				int to = input.nextInt();
				double weight = input.nextDouble();

				//Verify that there is no negative vertices/weights
				if( from >= 0 && to >= 0 && weight >= 0.0)
				{
					this.graph.addEdge(from, to, weight);
				}
				else
				{
					this.isValid = false;
				}
			}
			// call to validate fully
		}
	}
	public boolean isValid() {
		// TODO Auto-generated method stub
		return false;
	}
	public int getIntersections() {
		return intersections;
	}
}
