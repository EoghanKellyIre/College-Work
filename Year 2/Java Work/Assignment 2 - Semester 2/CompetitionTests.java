import static org.junit.Assert.*;
import java.io.FileNotFoundException;
import org.junit.Test;

public class CompetitionTests
{
	@Test
	public void testDijkstraConstructor() throws FileNotFoundException
	{
		CompetitionDijkstra tiny = new CompetitionDijkstra("tinyEWD.txt", 35, 27, 284);
		assertEquals("The slowest person is 27 in example", 27, tiny.slowestPerson);
		assertEquals("This network has 8 intersections",8, tiny.network.Intersections());
	}
	@Test
	public void testFWConstructor() throws FileNotFoundException
	{
		CompetitionFloydWarshall tiny = new CompetitionFloydWarshall("tinyEWD.txt", 38, 236, 24);
		assertEquals("The slowest person is 24 in example", 24, tiny.slowestPerson);
		assertEquals("This network has 8 intersections",8, CompetitionFloydWarshall.network.Intersections());
    }	@Test
	public void testNoFile() throws FileNotFoundException
	{
    	CompetitionDijkstra dijkstra = new CompetitionDijkstra("", 35, 27, 284);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("", 38, 236, 24);
		assertEquals("No File", -1, dijkstra.timeRequiredforCompetition());
		assertEquals("No File", -1, floyd.timeRequiredforCompetition());
    }
	@Test
	public void testingInputI() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-I.txt", 67,84,60);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-I.txt", 67,84,60);
		assertEquals("For input-I using Floyd", 200, floyd.timeRequiredforCompetition());
		assertEquals("For input-I using Dijkstra", 200, dijkstra.timeRequiredforCompetition());
	}

	@Test
	public void testingInputUnder50() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-A.txt", 124,38,37);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-A.txt", 124,38,37);
		assertEquals("For input-A using Floyd", -1, floyd.timeRequiredforCompetition());
	    assertEquals("For input-A using Dijkstra", -1, dijkstra.timeRequiredforCompetition());
	}

	@Test
	public void testingInputOver100() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-A.txt", 124,38,37);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-A.txt", 124,38,37);
		assertEquals("For input-A using Floyd", -1, floyd.timeRequiredforCompetition());
	    assertEquals("For input-A using Dijkstra", -1, dijkstra.timeRequiredforCompetition());
	}
	
	@Test
	public void testingInputA() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-A.txt", 67,84,60);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-A.txt", 67,84,60);
		assertEquals("For input-A using Floyd", -1, floyd.timeRequiredforCompetition());
	    assertEquals("For input-A using Dijkstra", -1, dijkstra.timeRequiredforCompetition());
	}
	
	@Test
	public void testingInputF() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-F.txt", 67,84,60);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-F.txt", 67,84,60);
		assertEquals("For input-F using Floyd", -1, floyd.timeRequiredforCompetition());
	    assertEquals("For input-F using Dijkstra", -1, dijkstra.timeRequiredforCompetition());
	}
	
	@Test
	public void testingInputG() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-G.txt", 67,84,60);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-G.txt", 67,84,60);
		assertEquals("For input-G using Floyd", -1, floyd.timeRequiredforCompetition());
	    assertEquals("For input-G using Dijkstra", -1, dijkstra.timeRequiredforCompetition());
	}
	@Test
	public void testingInputJ() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-J.txt", 67,84,60);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-J.txt", 67,84,60);
		assertEquals("For input-J using Floyd", -1, floyd.timeRequiredforCompetition());
	    assertEquals("For input-J using Dijkstra", -1, dijkstra.timeRequiredforCompetition());
	}
	
	@Test
	public void testingInputN() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-N.txt", 67,84,60);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-N.txt", 67,84,60);
		assertEquals("For input-N using Floyd", 134, floyd.timeRequiredforCompetition());
	    assertEquals("For input-N using Dijkstra", 134, dijkstra.timeRequiredforCompetition());
	}
	
	@Test
	public void testingInputM() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-M.txt", 67,84,60);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-M.txt", 67,84,60);
		assertEquals("For input-M using Floyd", 250, floyd.timeRequiredforCompetition());
	    assertEquals("For input-M using Dijkstra", 250, dijkstra.timeRequiredforCompetition());
	}
	
	@Test
	public void testingInputL() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-L.txt", 67,84,60);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-L.txt", 67,84,60);
		assertEquals("For input-L using Floyd", 134, floyd.timeRequiredforCompetition());
	    assertEquals("For input-L using Dijkstra", 134, dijkstra.timeRequiredforCompetition());
	}
	
	@Test
	public void testingInputD() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-D.txt", 67,84,60);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-D.txt", 67,84,60);
		assertEquals("For input-D using Floyd", 31, floyd.timeRequiredforCompetition());
	    assertEquals("For input-D using Dijkstra", 31, dijkstra.timeRequiredforCompetition());
	}
	
	@Test
	public void testingInputC() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-C.txt", 67,84,60);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-C.txt", 67,84,60);
		assertEquals("For input-C using Floyd", -1, floyd.timeRequiredforCompetition());
	    assertEquals("For input-C using Dijkstra", -1, dijkstra.timeRequiredforCompetition());
	}
	
	@Test
	public void testingInputB() throws FileNotFoundException
	{
		CompetitionDijkstra dijkstra = new CompetitionDijkstra("input-B.txt", 67,84,60);
		CompetitionFloydWarshall floyd = new CompetitionFloydWarshall("input-B.txt", 67,84,60);
		assertEquals("For input-B using Floyd", 8334, floyd.timeRequiredforCompetition());
	    assertEquals("For input-B using Dijkstra", 8334, dijkstra.timeRequiredforCompetition());
	}
}