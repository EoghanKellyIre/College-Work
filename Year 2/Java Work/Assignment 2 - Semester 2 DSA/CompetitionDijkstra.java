import java.io.File;
import java.io.FileNotFoundException;
import java.lang.NullPointerException;
import java.util.Scanner;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants’
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *     Each contestant walks at a given estimated speed.
 *     The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra
{

	public StoringGraph graph;
	public int slowestPerson;
	public double maxDist;
	public String networkFile;
	public boolean isValidGraph;
	
    CompetitionDijkstra (String networkFile, int speedOne, int speedTwo, int speedThree)
    {
    	try
    	{
			this.networkFile = networkFile;
			File file = new File(networkFile);
			Scanner input = new Scanner(file);
			
			this.graph = new StoringGraph(input);
			this.slowestPerson = Math.min(Math.min(speedOne,speedTwo),speedThree);
			this.networkFile = networkFile;

			this.maxDist = 0.0;
		}
    	catch (FileNotFoundException | NullPointerException e)
    	{
			this.isValidGraph = false;	
			this.networkFile = null;
		}
    	
    	if(this.graph != null && this.graph.isValid())
    		{
    			this.isValidGraph = true;
    			for(int i = 0; i < graph.getIntersections(); i++)
    			{
    				Dijkstra routedGraph = new Dijkstra(graph, i);
    				for(int j = 0; j < graph.getIntersections(); j++)
    				{
    					if(routedGraph.hasPathTo(j))
    					{
    						if(this.maxDist < routedGraph.distTo(j))
    						{
    							this.maxDist = routedGraph.distTo(j);
    						}
    					}	
    				}
    			}
    		}
    	
    }


    /**
    * @return int: minimum minutes that will pass before the three contestants can meet
     */
    public int timeRequiredforCompetition()
    {
    	if(this.maxDist <= 0.0 || this.slowestPerson <= 0 || this.networkFile == null)
    	{
			return -1;
    	}
		double time = (1000*this.maxDist)/this.slowestPerson;
		return (int) Math.ceil(time);
    }

}