import java.util.Scanner;

public class CreateGraphDijkstra
{
	private final int Intersections; 
	private int Streets; 
	private boolean isValidForCompetition;
	public int[] noHeadsAdjacent;
	public GenericForEdges<CreateEdge>[] edgesAdjacentTo; 

	@SuppressWarnings("unchecked")
	public CreateGraphDijkstra(Scanner input)
	{
		this.Intersections = input.nextInt();
		this.Streets = input.nextInt();
		this.isValidForCompetition = true;
		int currentEdges = Streets;
		edgesAdjacentTo = (GenericForEdges<CreateEdge>[]) new GenericForEdges[Intersections];
		if(this.Intersections < 3)
		{
			this.isValidForCompetition = false;
		}
		if(this.isValidForCompetition)
		{
			this.noHeadsAdjacent = new int[Intersections];
			for (int from = 0; from < this.Intersections; from++)
			{
				edgesAdjacentTo[from] = new GenericForEdges<CreateEdge>();
			}
			for (int i = 0; i < currentEdges; i++)
			{
				int from = input.nextInt();
				int to = input.nextInt();
				double weight = input.nextDouble();
				if( from >= 0 && to >= 0 && weight >= 0.0)
				{
					addEdge(new CreateEdge(from, to, weight));
				}
			}
			checkNetwork();
		}
	}

	public void checkNetwork()
	{
		boolean isValidForCompetition = true;
		for(int from=0; from<this.Intersections; from++)
		{
			if(noHeadsAdjacent[from] < 1)
			{
				isValidForCompetition = false;
			}
		}
		this.isValidForCompetition = isValidForCompetition;
	}

	public boolean isValidForCompetition()
	{
		if(this.isValidForCompetition)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void addEdge(CreateEdge edge)
	{
		int from = edge.from();
		int to = edge.to();
		noHeadsAdjacent[to]++;
		edgesAdjacentTo[from].add(edge);
		Streets++;
	}

	public Iterable<CreateEdge> edgesAdjacentTo(int from) 
	{
		return edgesAdjacentTo[from];
	}

	public int Intersections() 
	{
		return Intersections;
	}
}