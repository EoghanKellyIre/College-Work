import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * A Contest to Meet (ACM) is a reality TV contest that sets three contestants at three random
 * city intersections. In order to win, the three contestants need all to meet at any intersection
 * of the city as fast as possible.
 * It should be clear that the contestants may arrive at the intersections at different times, in
 * which case, the first to arrive can wait until the others arrive.
 * From an estimated walking speed for each one of the three contestants, ACM wants to determine the
 * minimum time that a live TV broadcast should last to cover their journey regardless of the contestants
 * initial positions and the intersection they finally meet. You are hired to help ACM answer this question.
 * You may assume the following:
 *    ‚· Each contestant walks at a given estimated speed.
 *    ‚· The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Dijkstra's algorithm
 */

public class CompetitionDijkstra
{
	public CreateGraphDijkstra network;
	public String filename;
	public boolean isValidForCompetition;
	public int slowestPerson;
	public double longestDistance;
	int sA, sB, sC;

    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     * @throws FileNotFoundException 
    */
    CompetitionDijkstra (String filename, int sA, int sB, int sC)
    {
		try
		{
			this.filename = filename;
			File file = new File(filename);
			Scanner in;
			in = new Scanner(file);
			this.network = new CreateGraphDijkstra(in);
			this.longestDistance = 0.0;
			this.filename = filename;
			this.slowestPerson = Math.min(Math.min(sA,sB),sC);
			this.sA = sA;
			this.sB = sB;
			this.sC = sC;
		}
		catch (FileNotFoundException | NullPointerException e)
		{
			this.network = null;
			this.isValidForCompetition = false;
			this.filename = null;
		}
		if(this.network != null && this.network.isValidForCompetition())
		{
			this.isValidForCompetition = true;
			for(int i = 0; i < network.Intersections(); i++)
			{
				FindShortestPathDijkstra routedGraph = new FindShortestPathDijkstra(network, i);
				for(int j = 0; j < network.Intersections(); j++)
				{
					if(this.longestDistance < routedGraph.distanceTo(j))
					{
						this.longestDistance = routedGraph.distanceTo(j);
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
		if(this.filename == null || this.slowestPerson < 50 || this.longestDistance <= 0.0 || this.sA > 100|| this.sB > 100|| this.sC > 100)
		{
			return -1;
		}
		double minutes = (1000*this.longestDistance)/this.slowestPerson;
		return (int) Math.ceil(minutes);
    }
}