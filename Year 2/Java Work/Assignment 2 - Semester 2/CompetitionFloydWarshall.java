import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.lang.NullPointerException;
import java.lang.UnsupportedOperationException;

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
 *    · Each contestant walks at a given estimated speed.
 *    · The city is a collection of intersections in which some pairs are connected by one-way
 * streets that the contestants can use to traverse the city.
 *
 * This class implements the competition using Floyd-Warshall algorithm
 */

public class CompetitionFloydWarshall
{
    public boolean isValidForCompetition;
	public static CreateGraphFloyd network;
    public double longestDistance;
    public FindShortestPathFloyd shortestPaths;
    public int slowestPerson;
    public String networkFile;
	int sA, sB, sC;
    /**
     * @param filename: A filename containing the details of the city road network
     * @param sA, sB, sC: speeds for 3 contestants
     */
    CompetitionFloydWarshall (String filename, int sA, int sB, int sC)
    {
    	try
    	{
            this.networkFile = filename;
            File file = new File(filename);
            Scanner input = new Scanner(file);
            CompetitionFloydWarshall.network = new CreateGraphFloyd(input);
            this.shortestPaths = new FindShortestPathFloyd(CompetitionFloydWarshall.network);
            this.longestDistance = 0.0;
            this.slowestPerson = Math.min(Math.min(sA,sB),sC);
            this.networkFile = filename;
			this.sA = sA;
			this.sB = sB;
			this.sC = sC;
        
        } catch (FileNotFoundException | NullPointerException | UnsupportedOperationException e)
    	{
            this.networkFile = null;
            CompetitionFloydWarshall.network = null;
            this.isValidForCompetition = false;
        } 

        if(this.shortestPaths != null && CompetitionFloydWarshall.network.isValidForCompetition() && !this.shortestPaths.hasNegativeCycle)
        {
            this.isValidForCompetition = true;
            for (int from = 0; from < CompetitionFloydWarshall.network.Intersections(); from++)
            {
                for (int to = 0; to < CompetitionFloydWarshall.network.Intersections(); to++)
                {
                	if(this.longestDistance < shortestPaths.distanceTo(from, to))
                    {
                		this.longestDistance = shortestPaths.distanceTo(from, to);
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
        if(this.longestDistance <= 0.0 || this.slowestPerson < 50 || this.networkFile == null || this.sA > 100|| this.sB > 100|| this.sC > 100)
        {
        	return -1;
        }
        double minutes = (1000*this.longestDistance)/this.slowestPerson;
        return (int) Math.ceil(minutes);
    }

}