// -------------------------------------------------------------------------
/**
 *  This class contains only two static methods that search for points on the
 *  same line in three arrays of integers. 
 *
 *  @author  
 *  @version 18/09/18 12:21:09
 */
class Collinear
{

   // ----------------------------------------------------------
    /**
     * Counts for the number of non-horizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinear(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * Array a1, a2 and a3 contain points on the horizontal line y=1, y=2 and y=3, respectively.
     * A non-horizontal line will have to cross all three of these lines. Thus
     * we are looking for 3 points, each in a1, a2, a3 which lie on the same
     * line.
     *
     * Three points (x1, y1), (x2, y2), (x3, y3) are collinear (i.e., they are on the same line) if
     * 
     * x1(y2−y3)+x2(y3−y1)+x3(y1−y2)=0 
     *
     * In our case y1=1, y2=2, y3=3.
     *
     * You should implement this using a BRUTE FORCE approach (check all possible combinations of numbers from a1, a2, a3)
     *  
     *  Experimental Performance
     * ----------------------------------------------------------
     * The experiments here should measure the running time of countCollinear when given random arrays of integers of sizes 1000, 2000, 4000. 
     * 
     *  Input Size N 			Running Time (secs)
     *----------------       -------------------------
     * 		1000						0.254
     * 		2000						2.053
     * 		4000						13.635
     * 		5000						??????
     * 
     * Assuming that the order of growth is N^3
     * If 1000^3 : 0.254 then 5000^3 : 31.75
     * If 2000^3 : 2.053 then 5000^3 : 32.078125
     * If 4000^3 : 13.635 then 5000^3 : 26.630859375
     * Averaging the values gives 30.15s -- My estimate
     * 
     *  Input Size N 			Predicted Running Time (secs)				Actual Running Time (secs)						Error (%)
     *----------------       ---------------------------------			------------------------------------			-----------------
     * 		5000						30.15										25.995									15.9838%
     * 
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of growth: O(N^3)
     *
     *  Explanation: In the program, it has three loop iterating N times. They compare every value in each array. Therefore the code's order of growth is N*N*N = N^3.
     *  			This doesn't scale well, if N= 10, it would be 10^3 or N=1000, it would be 1000^3.
     */
	static int countCollinear(int[] a1, int[] a2, int[] a3)
    {
    	int count = 0;
    	
    	//3 for loops on the arrays a1 and a2 - O(n^3)
    	for (int i=0; i<a1.length; i++)
    	{
        	for (int j=0; j<a2.length; j++)
        	{
            	for (int z=0; z<a3.length; z++)
            	{
            		if ((a1[i]*((2)-(3)) + a2[j]*((3)-(1)) + a3[z]*((1)-(2)))==0)
            		{
            			count +=1;
            		}
            	}
        	}
    	}
    	return count;
    }

    // ----------------------------------------------------------
    /**
     * Counts for the number of non-hoizontal lines that go through 3 points in arrays a1, a2, a3.
     * This method is static, thus it can be called as Collinear.countCollinearFast(a1,a2,a3)
     * @param a1: An UNSORTED array of integers. Each integer a1[i] represents the point (a1[i], 1) on the plain.
     * @param a2: An UNSORTED array of integers. Each integer a2[i] represents the point (a2[i], 2) on the plain.
     * @param a3: An UNSORTED array of integers. Each integer a3[i] represents the point (a3[i], 3) on the plain.
     * @return the number of points which are collinear and do not lie on a horizontal line.
     *
     * In this implementation you should make non-trivial use of InsertionSort and Binary Search.
     * The performance of this method should be much better than that of the above method.
     *
     * Experimental Performance
     * ----------------------------------------------------------
     * The experiments here should measure the running time of countCollinearFast when given random arrays of integers of sizes 1000, 2000, 4000. 
     * 
     *  Input Size N 			Running Time (secs)
     *----------------       -------------------------
     * 		1000						0.034
     * 		2000						0.142
     * 		4000						0.606
     * 		5000						1.024
     * 
     * 
     *  Input Size N 			countCollinear Running Time (secs)		countCollinearFast Running Time (secs)			Speedup = (time of countCollinear)/(time of countCollinearFast)
     *----------------       ---------------------------------			------------------------------------			---------------------------------------------------------------
     * 		1000						0.254											0.034												7.47
     * 		2000						2.053											0.142												14.46
     * 		4000						13.635											0.606												22.5
     * 		5000						25.995											1.024												25.39
     * 
     * 
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: O(N^2 * logn)
     *
     *  Explanation:		Sorting the last array has an O(n^2) as seen in the sort function. As before this is since there is 2 linear for loops N*N.
     *  					Then there is two for loops again going through the first and second array N times, therefore it is N*N = O(N^2).
     *  					Finally there is a binary search which has an O(logn).
     *  					The overall order of growth for this code therefore is O(logn) * O(N^2) = O(N^2 * logn)
     *
     *
     */
    static int countCollinearFast(int[] a1, int[] a2, int[] a3)
    {
    	int count = 0;
    	//Sorting the last array for future binary search - O(n^2)
    	Collinear.sort(a3);
    	
    	//2 for loops on the arrays a1 and a2 - O(n^2)
    	for (int i=0; i<a1.length; i++)
    	{
        	for (int j=0; j<a2.length; j++)
        	{
        		// Finding required a3 to make collinear based off formula given : x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2)=0
        		int requiredA3 = (-(a1[i]*(-1))-(a2[j]*2))/(1-2);
        		// Performing a binary search for required a3 - O(logN)
        		if(binarySearch(a3,requiredA3))
        		{
      			  count++;
      		  	}
            }
        }
    	return count;
    }

    // ----------------------------------------------------------
    /**
     * Sorts an array of integers according to InsertionSort.
     * This method is static, thus it can be called as Collinear.sort(a)
     * @param a: An UNSORTED array of integers. 
     * @return after the method returns, the array must be in ascending sorted order.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: N^2
     *
     *  Explanation: Two linear for-loops.
     *
     */
    static void sort(int[] a)
    {
    	// Given
      for ( int j = 1; j<a.length; j++) // O(n)
      {
        int i = j - 1;
        while(i>=0 && a[i]>a[i+1]) // O(n)
        {
          int temp = a[i];
          a[i] = a[i+1];
          a[i+1] = temp;
          i--;
        }
      }
    }

    // ----------------------------------------------------------
    /**
     * Searches for an integer inside an array of integers.
     * This method is static, thus it can be called as Collinear.binarySearch(a,x)
     * @param a: A array of integers SORTED in ascending order.
     * @param x: An integer.
     * @return true if 'x' is contained in 'a'; false otherwise.
     *
     * ----------------------------------------------------------
     *
     *  Order of Growth
     *  -------------------------
     *
     *  Caclulate and write down the order of growth of your algorithm. You can use the asymptotic notation.
     *  You should adequately explain your answer. Answers without adequate explanation will not be counted.
     *
     *  Order of Growth: O(logN)
     *
     *  Explanation: In binary search, you search through N/2 at the first attempt, then (N/2)/2, ..... or N/2^1, then n/2^2......
     *  			 Therefore the order of growth would be 2^x = N, which can be written as log2(N)
     *  
     *
     */
    static boolean binarySearch(int[] a, int x)
    {
    	// Code from first lab
    	int lo = 0, hi = a.length-1;
		
		while (lo <= hi) 
		{
			int mid = lo + (hi - lo)/2;
			
			if (x < a[mid]) hi = mid - 1;
			else if (x > a[mid]) lo = mid + 1;
			else return true;
		}
      return false;
    }
   
}