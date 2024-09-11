import java.util.Iterator;
import java.util.Scanner;

public class CreateGraphFloyd
{
	public final int Intersections;
	public int Streets;
	public CreateEdge[][] edgeFromTo;
	public int[] noHeadsAdjacent;
	public boolean isValidForCompetition;

	public CreateGraphFloyd(Scanner input)
	{
		this.Intersections = input.nextInt();
		this.Streets = input.nextInt();
		int currentEdges = Streets;
		this.isValidForCompetition = true;
		this.edgeFromTo = new CreateEdge[Intersections][Intersections];
		if(this.Intersections < 3)
		{
				this.isValidForCompetition = false;
		}
		if(this.isValidForCompetition)
		{
			this.noHeadsAdjacent = new int[Intersections];
			for (int i = 0; i < currentEdges; i++)
			{
				int from = input.nextInt();
				int to = input.nextInt();
				double weight = input.nextDouble();
				if( from >= 0 && to >= 0)
				{
					if (from == to)
					{
						addEdge(new CreateEdge(from, to, Math.abs(weight)));
					}
					else
					{
						addEdge(new CreateEdge(from, to, weight));
					}
				}
				else
				{
					this.isValidForCompetition = false;
				}
			}
			checkNetwork();
		}
	}
        
	public void addEdge(CreateEdge edge)
	{
		int from = edge.from();
		int to = edge.to();
		noHeadsAdjacent[to]++;
		if (edgeFromTo[from][to] == null)
		{
			Streets++;
			edgeFromTo[from][to] = edge;
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

	public Iterable<CreateEdge> edgeFromTo(int from)
	{
		return new AdjIterator(from);
	}

	public class AdjIterator implements Iterator<CreateEdge>, Iterable<CreateEdge>
	{
		private int from;
		private int to = 0;

		public AdjIterator(int from)
		{
			this.from = from;
		}

		public Iterator<CreateEdge> iterator()
		{
			return this;
		}

		public boolean hasNext()
		{
			while (to < Intersections)
			{
				if (edgeFromTo[from][to] != null)
				{
					return true;
				}
				to++;
			}
			return false;
		}

		public CreateEdge next()
		{
			return edgeFromTo[from][to++];
		}
	}
        
	public int Intersections()
	{
		return Intersections;
	}

	public int Streets()
	{
		return Streets;
	}
}
