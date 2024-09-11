import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

//-------------------------------------------------------------------------
/**
 *  Test class for Collinear.java
 *
 *  @author  
 *  @version 18/09/18 12:21:26
 */
@RunWith(JUnit4.class)
public class CollinearTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new Collinear();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the two methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
        int expectedResult = 0;

        assertEquals("countCollinear failed with 3 empty arrays",       expectedResult, Collinear.countCollinear(new int[0], new int[0], new int[0]));
        assertEquals("countCollinearFast failed with 3 empty arrays", expectedResult, Collinear.countCollinearFast(new int[0], new int[0], new int[0]));
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleFalse()
    {
        int[] a3 = { 15 };
        int[] a2 = { 5 };
        int[] a1 = { 10 };

        int expectedResult = 0;

        assertEquals("countCollinear({10}, {5}, {15})",       expectedResult, Collinear.countCollinear(a1, a2, a3) );
        assertEquals("countCollinearFast({10}, {5}, {15})", expectedResult, Collinear.countCollinearFast(a1, a2, a3) );
    }

    // ----------------------------------------------------------
    /**
     * Check for no false positives in a single-element array
     */
    @Test
    public void testSingleTrue()
    {
        int[] a3 = { 15, 5 };       int[] a2 = { 5 };       int[] a1 = { 10, 15, 5 };

        int expectedResult = 1;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }
    
    // ----------------------------------------------------------
    /**
     * Testing that the array should give four sets of collinear points
     */
    @Test
    public void countCollinearBothTest()
    {
        int[] a3 = { 15, 5, 23, 56, 99, 34, 35, 12, 26 };       int[] a2 = { 5, 23, 100, 45, 24, 21, 96, 58, 12 };       int[] a1 = { 10, 15, 1, 5, 33, 76, 23 };

        int expectedResult = 4;

        assertEquals("countCollinear(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")",     expectedResult, Collinear.countCollinear(a1, a2, a3));
        assertEquals("countCollinearFast(" + Arrays.toString(a1) + "," + Arrays.toString(a2) + "," + Arrays.toString(a3) + ")", expectedResult, Collinear.countCollinearFast(a1, a2, a3));
    }

    // ----------------------------------------------------------
    /**
     * Testing binary search positive
     */
    @Test
    public void binarySearchTestP()
    {
        int[] a1 = { 10, 15, 5, 23, 1, 5, 33, 76, 23 };
        Collinear.sort(a1);
        boolean expectedResult = true;

        assertEquals("binarySearch(" + Arrays.toString(a1) + ")",     expectedResult, Collinear.binarySearch(a1, 33));
    }
    
    // ----------------------------------------------------------
    /**
     * Testing binary search negative
     */
    @Test
    public void binarySearchTestN()
    {
        int[] a1 = { 10, 15, 5, 23, 1, 5, 33, 76, 23 };
        Collinear.sort(a1);
        boolean expectedResult = false;

        assertEquals("binarySearch(" + Arrays.toString(a1) + ")",     expectedResult, Collinear.binarySearch(a1, 30));
    }
    
    // ----------------------------------------------------------
    /**
     * Testing Performance, leaving commented since not uploading In, Stop watch etc.
     */
    /**
    public static void main(String[] args) {
 		In in;
 		int[] a1, a2, a3;
 		Stopwatch stopwatch;
 		double time;
 		// Experiments for countCollinear

 		System.out.println("--- countCollinear ---");
 		// Experiment countCollinear with input size 1000
 		in = new In("input-files/r01000-1.txt");
 		a1 = in.readAllInts();
 		in = new In("input-files/r01000-2.txt");
 		a2 = in.readAllInts();
 		in = new In("input-files/r01000-3.txt");
 		a3 = in.readAllInts();
 		stopwatch = new Stopwatch();
 		Collinear.countCollinear(a1, a2, a3);
 		time = stopwatch.elapsedTime();
 		System.out.println("When N = " + 1000 + ", elapsed time = " + time + " sec.");
 		
 		// Experiment countCollinear with input size 2000
 		in = new In("input-files/r02000-1.txt");
 		a1 = in.readAllInts();
 		in = new In("input-files/r02000-2.txt");
 		a2 = in.readAllInts();
 		in = new In("input-files/r02000-3.txt");
 		a3 = in.readAllInts();
 		stopwatch = new Stopwatch();
 		Collinear.countCollinear(a1, a2, a3);
 		time = stopwatch.elapsedTime();
 		System.out.println("When N = " + 2000 + ", elapsed time = " + time + " sec.");
 		
 		// Experiment countCollinear with input size 4000
 		in = new In("input-files/r04000-1.txt");
 		a1 = in.readAllInts();
 		in = new In("input-files/r04000-2.txt");
 		a2 = in.readAllInts();
 		in = new In("input-files/r04000-3.txt");
 		a3 = in.readAllInts();
 		stopwatch = new Stopwatch();
 		Collinear.countCollinear(a1, a2, a3);
 		time = stopwatch.elapsedTime();
 		System.out.println("When N = " + 4000 + ", elapsed time = " + time + " sec.");
 		
 		// Experiment countCollinear with input size 5000
 		in = new In("input-files/r05000-1.txt");
 		a1 = in.readAllInts();
 		in = new In("input-files/r05000-2.txt");
 		a2 = in.readAllInts();
 		in = new In("input-files/r05000-3.txt");
 		a3 = in.readAllInts();
 		stopwatch = new Stopwatch();
 		Collinear.countCollinear(a1, a2, a3);
 		time = stopwatch.elapsedTime();
 		System.out.println("When N = " + 5000 + ", elapsed time = " + time + " sec.");
 		
 		// Experiments for countCollinearFast

 		System.out.println("--- countCollinearFast ---");
 		// Experiment countCollinearFast with input size 1000
 		in = new In("input-files/r01000-1.txt");
 		a1 = in.readAllInts();
 		in = new In("input-files/r01000-2.txt");
 		a2 = in.readAllInts();
 		in = new In("input-files/r01000-3.txt");
 		a3 = in.readAllInts();
 		stopwatch = new Stopwatch();
 		Collinear.countCollinearFast(a1, a2, a3);
 		time = stopwatch.elapsedTime();
 		System.out.println("When N = " + 1000 + ", elapsed time = " + time + " sec.");
 		
 		// Experiment countCollinearFast with input size 2000
 		in = new In("input-files/r02000-1.txt");
 		a1 = in.readAllInts();
 		in = new In("input-files/r02000-2.txt");
 		a2 = in.readAllInts();
 		in = new In("input-files/r02000-3.txt");
 		a3 = in.readAllInts();
 		stopwatch = new Stopwatch();
 		Collinear.countCollinearFast(a1, a2, a3);
 		time = stopwatch.elapsedTime();
 		System.out.println("When N = " + 2000 + ", elapsed time = " + time + " sec.");
 		
 		// Experiment countCollinearFast with input size 4000
 		in = new In("input-files/r04000-1.txt");
 		a1 = in.readAllInts();
 		in = new In("input-files/r04000-2.txt");
 		a2 = in.readAllInts();
 		in = new In("input-files/r04000-3.txt");
 		a3 = in.readAllInts();
 		stopwatch = new Stopwatch();
 		Collinear.countCollinearFast(a1, a2, a3);
 		time = stopwatch.elapsedTime();
 		System.out.println("When N = " + 4000 + ", elapsed time = " + time + " sec.");
 		
 		// Experiment countCollinearFast with input size 5000
 		in = new In("input-files/r05000-1.txt");
 		a1 = in.readAllInts();
 		in = new In("input-files/r05000-2.txt");
 		a2 = in.readAllInts();
 		in = new In("input-files/r05000-3.txt");
 		a3 = in.readAllInts();
 		stopwatch = new Stopwatch();
 		Collinear.countCollinearFast(a1, a2, a3);
 		time = stopwatch.elapsedTime();
 		System.out.println("When N = " + 5000 + ", elapsed time = " + time + " sec.");
     }
     */
}
    
