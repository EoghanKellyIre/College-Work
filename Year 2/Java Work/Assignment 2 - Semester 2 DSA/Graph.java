import java.util.*;

public class Graph
{
	static class Edge
	{
		int source;
		int destination;
		double weight;

		public Edge(int source, int destination, double weight)
		{
		this.source = source;
		this.destination = destination;
		this.weight = weight;
		}
	}
	
	int vertices;
	LinkedList<Edge> [] adjacencylist;

	@SuppressWarnings("unchecked")
	Graph(int vertices)
	{
		this.vertices = vertices;
		adjacencylist = new LinkedList[vertices];
		//initialize adjacency lists for all the vertices
		for (int i = 0; i <vertices ; i++)
		{
				adjacencylist[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int source, int destination, double weight)
	{
		Edge edge = new Edge(source, destination, weight);
		adjacencylist[source].addFirst(edge); //for directed graph
	}
	public int getVertices() {
		return vertices;
	}
}
