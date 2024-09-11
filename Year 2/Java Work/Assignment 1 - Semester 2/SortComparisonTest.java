import static org.junit.Assert.*;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Time taken in Nanoseconds/ Average of 3
 * <pre>
 | 		  Key          |    Insert    |	Selection	  |	Quick     |	  Merge Rec	  |	  Merge It	  |
 |---------------------|--------------|---------------|-----------|---------------|---------------|
 | 1000 random 		   |	12304900  |		4644033	  |	646467	  |	529767		  |		578100	  |
 | 1000 few unique 	   |	748700	  |		426633	  |	182700	  |	206600		  |		188900	  |
 | 1000 nearly ordered |	641500	  |		501800	  |	250300	  |	257933		  |		350767	  |
 | 1000 reverse order  |	908033	  |		490667	  |	3423467	  |	228000		  |		252067	  |
 | 1000 sorted 		   |	590400	  |		594333	  |	748300	  |	235533		  |		262133	  |
 | 10000 random 	   |	55887300  |		31618433  |	3293700   |	3244933		  |		3562733	  |
 *</pre>
 	a. Which of these sorting algorithms does the order of input have an impact on? Why?
 	Looking at the data the order of inputs has a big difference for each sorting algorithm.
 	For insertion sort, we can see that the best case is where the array is where it is sorted and
 	the worst case is when it is in reverse order. It doesn't have to change anything for sorted and for
 	reversed sorted, it will have to change each and every one.
 	For selection sort, it seems that is it insensitive to input, although true random seems to be longer.
 	It should be insensitive to input, since it would still need to do a full pass which each element.
	For quick sort, we can see that when the array is sorted or reversed sorted it will be it's worst case.
 	This is when the picked pivot is always the extreme element and has to filter through the array.
 	For Merge Recursive sort and iterative sort, it doesn't matter the order of the array, it will
 	have to examine each array once.
 	
	b. Which algorithm has the biggest difference between the best and worst performance, based
	on the type of input, for the input of size 1000? Why?
	The biggest difference is seen with insertion sort. This is since the algorithm just has to pass through the
	array once if sorted and change each individual case for reverse sorted.
	
	
	c. Which algorithm has the best/worst scalability, i.e., the difference in performance time
	based on the input size? Please consider only input files with random order for this answer.
	Looking at these, quick and merge recursive has the best scalability.   
	 
	d. Did you observe any difference between iterative and recursive implementations of merge
	sort?
	The recursive implementations of merge sort was consistently faster than the iterative implementation.
	
	e. Which algorithm is the fastest for each of the 7 input files?
	I think that overall quick sort is the fastest with the 7 input files
	

 */
//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Eoghán Kelly
 *  @version HT 2020
 */
@RunWith(JUnit4.class)
public class SortComparisonTest 
{
	//~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    
	
	@Test
	public void testInsertionSort() {
		double [] a = {1,3,4,2,4,7,3,678,9,4,67,8,4,23,1};
		double [] expectedResult = {1,1,2,3,3,4,4,4,4,7,8,9,23,67,678};
        assertEquals( "Checking InsertionSort", Arrays.toString(expectedResult), Arrays.toString(SortComparison.insertionSort(a)));
	}

	@Test
	public void testSelectionSort() {
		double [] a = {1,3,4,2,4,7,3,678,9,4,67,8,4,23,1};
		double [] expectedResult = {1,1,2,3,3,4,4,4,4,7,8,9,23,67,678};
        assertEquals( "Checking SelectionSort", Arrays.toString(expectedResult), Arrays.toString(SortComparison.selectionSort(a)));
	}

	@Test
	public void testQuickSort() {
		double [] a = {1,3,4,2,4,7,3,678,9,4,67,8,4,23,1};
		double [] expectedResult1 = {1,1,2,3,3,4,4,4,4,7,8,9,23,67,678};
        assertEquals( "Checking QuickSort", Arrays.toString(expectedResult1), Arrays.toString(SortComparison.quickSort(a)));
        
        // Checking sorted array
		double [] b = {1,2,3,4,5,6,7,8,9,10};
		double [] expectedResult2 = {1,2,3,4,5,6,7,8,9,10};
        assertEquals( "Checking QuickSort", Arrays.toString(expectedResult2), Arrays.toString(SortComparison.quickSort(b)));
        
        // Checking reverse sorted array
		double [] c = {10,8,7,5,3,2,1};
		double [] expectedResult3 = {1,2,3,5,7,8,10};
        assertEquals( "Checking QuickSort", Arrays.toString(expectedResult3), Arrays.toString(SortComparison.quickSort(c)));
	}

	@Test
	public void testMergeSortIterative() {
		double [] a = {1,3,4,2,4,7,3,678,9,4,67,8,4,23,1};
		double [] expectedResult = {1,1,2,3,3,4,4,4,4,7,8,9,23,67,678};
        assertEquals( "Checking MergeSortIterative", Arrays.toString(expectedResult), Arrays.toString(SortComparison.mergeSortIterative(a)));
	}

	@Test
	public void testMergeSortRecursive() {
		double [] a = {1,3,4,2,4,7,3,678,9,4,67,8,4,23,1};
		double [] expectedResult = {1,1,2,3,3,4,4,4,4,7,8,9,23,67,678};
        assertEquals( "Checking MergeSortRecursive", Arrays.toString(expectedResult), Arrays.toString(SortComparison.mergeSortRecursive(a)));
	}
	
	//Code to check the times for the sorting algorithm.
	public static void main(String[] args) 
	{
		System.out.println("Test sorting algorithm");
		System.out.println(" ");
		
		System.out.println("Insertion sort");
		findTimeInsertionSort("numbers1000.txt");
		findTimeInsertionSort("numbers10000.txt");
		findTimeInsertionSort("numbers1000Duplicates.txt");
		findTimeInsertionSort("numbersNearlyOrdered1000.txt");
		findTimeInsertionSort("numbersReverse1000.txt");
		findTimeInsertionSort("numbersSorted1000.txt");
		
		System.out.println(" "); System.out.println("Selection sort");
		findTimeSelectionSort("numbers1000.txt");
		findTimeSelectionSort("numbers10000.txt");
		findTimeSelectionSort("numbers1000Duplicates.txt");
		findTimeSelectionSort("numbersNearlyOrdered1000.txt");
		findTimeSelectionSort("numbersReverse1000.txt");
		findTimeSelectionSort("numbersSorted1000.txt");
		
		System.out.println(" ");
		System.out.println("Quick sort");
		findTimeIQuickSort("numbers1000.txt");
		findTimeIQuickSort("numbers10000.txt");
		findTimeIQuickSort("numbers1000Duplicates.txt");
		findTimeIQuickSort("numbersNearlyOrdered1000.txt");
		findTimeIQuickSort("numbersReverse1000.txt");
		findTimeIQuickSort("numbersSorted1000.txt");
		
		System.out.println(" ");
		System.out.println("mergeSortIterative sort");
		findTimeMergeSortIterative("numbers1000.txt");
		findTimeMergeSortIterative("numbers10000.txt");
		findTimeMergeSortIterative("numbers1000Duplicates.txt");
		findTimeMergeSortIterative("numbersNearlyOrdered1000.txt");
		findTimeMergeSortIterative("numbersReverse1000.txt");
		findTimeMergeSortIterative("numbersSorted1000.txt");
		
		System.out.println(" ");
		System.out.println("mergeSortRecursive sort");
		findTimemMergeSortRecursive("numbers1000.txt");
		findTimemMergeSortRecursive("numbers10000.txt");
		findTimemMergeSortRecursive("numbers1000Duplicates.txt");
		findTimemMergeSortRecursive("numbersNearlyOrdered1000.txt");
		findTimemMergeSortRecursive("numbersReverse1000.txt");
		findTimemMergeSortRecursive("numbersSorted1000.txt");
	}
	
	public static double[] readFile(String fileName)
	{
		File file = new File(fileName);
    	ArrayList<Double> doubles = new ArrayList<Double>();
		try {
			Scanner doublesFile = new Scanner(file);
	    	int u = 0;
	    	while (doublesFile.hasNextLine()) 
	    		{
	    	       String line = doublesFile.nextLine();
	    	       doubles.add(Double.parseDouble(line));
	    	       u += 1;
	    	    }
	    	doublesFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		double [] a = new double [doubles.size()];
		for (int i =0; i<doubles.size(); i++)
		{
			a[i] = doubles.get(i);
		}
		return a;
	}
	
	public static void findTimeInsertionSort(String fileName)
	{
		double [] a = readFile(fileName);
		System.out.println("For " + fileName);
		Long begin = System.nanoTime();
		Arrays.toString(SortComparison.insertionSort(a));
		Long end = System.nanoTime();          
		Long time = end-begin;
	    System.out.println("Elapsed Time: "+time);
	}
	public static void findTimeSelectionSort(String fileName)
	{
		double [] a = readFile(fileName);
		System.out.println("For " + fileName);
		Long begin = System.nanoTime();
		Arrays.toString(SortComparison.selectionSort(a));
		Long end = System.nanoTime();          
		Long time = end-begin;
	    System.out.println("Elapsed Time: "+time);
	}
	public static void findTimeIQuickSort(String fileName)
	{
		double [] a = readFile(fileName);
		System.out.println("For " + fileName);
		Long begin = System.nanoTime();
		Arrays.toString(SortComparison.quickSort(a));
		Long end = System.nanoTime();          
		Long time = end-begin;
	    System.out.println("Elapsed Time: "+time);
	}
	public static void findTimeMergeSortIterative(String fileName)
	{
		double [] a = readFile(fileName);
		System.out.println("For " + fileName);
		Long begin = System.nanoTime();
		Arrays.toString(SortComparison.mergeSortIterative(a));
		Long end = System.nanoTime();          
		Long time = end-begin;
	    System.out.println("Elapsed Time: "+time);
	}
	public static void findTimemMergeSortRecursive(String fileName)
	{
		double [] a = readFile(fileName);
		System.out.println("For " + fileName);
		Long begin = System.nanoTime();
		Arrays.toString(SortComparison.mergeSortRecursive(a));
		Long end = System.nanoTime();          
		Long time = end-begin;
	    System.out.println("Elapsed Time: "+time);
	}
}
