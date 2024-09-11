

/**
*  This class contains static methods that implementing sorting of an array of numbers
*  using different sort algorithms.
*
*  @author Eoghán Kelly
*  @version HT 2020
*/

class SortComparison {

	/**
	* Sorts an array of doubles using InsertionSort.
	* This method is static, thus it can be called as SortComparison.sort(a)
	* @param a: An unsorted array of doubles.
	* @return array sorted in ascending order.
	*
	*/
	static double [] insertionSort (double a[])
	{
		double temporary;
		for (int i=1; i<a.length; i++)
		{
			// Starting by looking at the first element
			for(int j=i; j>0; j--)
			{
				// Then shift the element back until a smaller element
				if(a[j] < a[j-1])
				{
					temporary = a[j];
					a[j] = a[j-1];
					a[j-1] = temporary;
				}
				// Repeat until you reach the end of the array
			}
		}
		return a;
	}	//end insertionsort
	
	/**
	* Sorts an array of doubles using Selection Sort.
	* This method is static, thus it can be called as SortComparison.sort(a)
	* @param a: An unsorted array of doubles.
	* @return array sorted in ascending order
	*
	*/
	static double [] selectionSort (double a[])
	{
		int lenght = a.length;
		for (int i = 0; i < lenght-1; i++)
		{
			// Find the minimum element in unsorted array
			int min_element = i;
			for (int j = i+1; j < lenght; j++)
			{
				if (a[j] < a[min_element])
					{
						min_element = j;
					}
			}
			// Exchanging the position
			double temporary = a[min_element];
			a[min_element] = a[i];
			a[i] = temporary;
		}
		
		return a;
		
	}//end selectionsort

	/**
	* Sorts an array of doubles using Quick Sort.
	* This method is static, thus it can be called as SortComparison.sort(a)
	* @param a: An unsorted array of doubles.
	* @return array sorted in ascending order
	*
	*/
	static double [] quickSort (double a[])
	{
		recursiveQuick(a, 0, a.length-1);
		return a;
		
	}//end quicksort
	
	static double [] recursiveQuick (double[] a, int lo, int hi)
	{
		if(hi <= lo)
		{
			return a;
		}
		// Partitioning the array
		int pivotPos = partition(a, lo, hi);
		// Sorting each sub array
		recursiveQuick(a, lo, pivotPos-1);
		recursiveQuick(a, pivotPos+1, hi);
		return a;
	}
	
	static private int partition (double[] a, int low, int high)
	{
		int i = low;
		int j = high+1;
		double pivot = a[low];
		boolean finished = false;
		while(!finished)
		{
			while(i<a.length-1 && (a[++i]-pivot < 0)&& !finished)
			{
				if(i == high) finished = true;
			}
			finished = false;
			while((pivot - a[--j] < 0) && !finished)
			{
				if(j == low) finished = true;
			}
			finished = false;
			if(i >= j) finished = true;
			else
			{
				double temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		a[low] = a[j];
		a[j] = pivot;
		return j;
	}
	/**
	* Sorts an array of doubles using Merge Sort.
	* This method is static, thus it can be called as SortComparison.sort(a)
	* @param a: An unsorted array of doubles.
	* @return array sorted in ascending order
	*
	*/
	/**
	* Sorts an array of doubles using iterative implementation of Merge Sort.
	* This method is static, thus it can be called as SortComparison.sort(a)
	*
	* @param a: An unsorted array of doubles.
	* @return after the method returns, the array must be in ascending sorted order.
	*/
	
	static double[] mergeSortIterative (double[] a) 
	{
		int N = a.length;
		double[] aux = new double [N];
		for (int sz = 1; sz<N; sz=sz+sz)
		{
			for (int lo = 0; lo<N-sz; lo+=sz+sz)
			{
				merge(a,aux,lo,lo+sz-1,Math.min(lo+sz+sz-1, N-1));
			}
		}
		return a;
		
	}//end mergesortIterative
	 
	 
	 
	/**
	* Sorts an array of doubles using recursive implementation of Merge Sort.
	* This method is static, thus it can be called as SortComparison.sort(a)
	*
	* @param a: An unsorted array of doubles.
	* @return after the method returns, the array must be in ascending sorted order.
	*/
	static double[] mergeSortRecursive (double[] a)
	{
		double[] aux = new double [a.length];
		sort(a, aux, 0, a.length-1);
		return a;
		
	}//end mergeSortRecursive
	
	
	private static void sort(double[] a, double[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo +(hi-lo)/2;
		sort(a,aux,lo,mid);
		sort(a,aux,mid+1,hi);
		if (a[mid+1]-a[mid]>=0) return;
		merge(a,aux,lo,mid,hi);
	}

	private static void merge(double[] a, double[] aux, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k++)
		{
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid+1;
		for (int k = lo; k <= hi; k++)
		{
			if (i>mid) 								a[k] = aux[j++];
			else if (j>hi) 							a[k] = aux[i++];
			else if ((aux[j]-aux[i]<0))	a[k] = aux[j++];
			else	 								a[k] = aux[i++];
		}
	}
}

