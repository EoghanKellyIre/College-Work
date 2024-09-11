import java.util.Arrays;
import java.util.Scanner;

public class Median {

	public static double computeMedian( double[] numbersEntered )
	{
		if (!(numbersEntered==null))
		{
			double[] sortedArray = createSortedArray( numbersEntered );
			double median;
			if (sortedArray.length % 2 == 0)
			    median = ((double)sortedArray[sortedArray.length/2] + (double)sortedArray[sortedArray.length/2 - 1])/2;
			else
			    median = (double) sortedArray[sortedArray.length/2];
			return median;
		}
		else
		{
			return 0;
		}
	}
	
	public static double[] createSortedArray( double[] numbersEntered )
	{
		if (!((numbersEntered==null) || (numbersEntered.length==1)))
		{
			double[] sortedArray = numbersEntered.clone();
			Arrays.sort(sortedArray);
			return sortedArray;
		}
		else
		{
			return numbersEntered;
		}
	}
	
	public static double computeRollingAverage( double[] numbersEntered, int noOfRollingDays )
	{
		double total = 0;
		if (noOfRollingDays<=0)
		{
			return 0;
		}
		else if (numbersEntered.length<=noOfRollingDays)
		{
			for (int i=numbersEntered.length; i>0; i--)
			{
				if (numbersEntered.length<4)
				{
					total += numbersEntered[numbersEntered.length-i];
				}
				else
				{
					total += numbersEntered[numbersEntered.length-i];
				}
			}
			double rollingAverage = total/numbersEntered.length;
			return rollingAverage;
		}
		else
		{
			for (int i=noOfRollingDays; i>0; i--)
			{
				if (numbersEntered.length<4)
				{
					total += numbersEntered[numbersEntered.length-i];
				}
				else
				{
					total += numbersEntered[numbersEntered.length-i];
				}
			}
			double rollingAverage = total/noOfRollingDays;
			return rollingAverage;
		}
	}
	
    public static String convertToString(double[] numbersEntered) {
        if (numbersEntered == null)
        {
            return "{ }";
        }
        else
        {
        StringBuilder stringOfNumbersEntered = new StringBuilder();
        stringOfNumbersEntered.append('{');
        stringOfNumbersEntered.append(' ');
        for (int i = 0; ; i++)
        {
        	stringOfNumbersEntered.append(String.format("%.1f", numbersEntered[i]));
            if (i == numbersEntered.length - 1)
            {
            	stringOfNumbersEntered.append(' ');
                return stringOfNumbersEntered.append('}').toString();
            }
            stringOfNumbersEntered.append(", ");
        }
        }
    }
	
	public static void main(String[] args) {
		System.out.println("Welcome to the median & rolling average system.");
		Scanner input = new Scanner (System.in);
		double[] numbersEntered = null;
		boolean finished = false;
		while (!finished)
		{
			System.out.print("Enter a number (or enter quit): ");
			if (input.hasNextDouble())
			{
				double[] tempArray = null;
				if (numbersEntered == null)
				{
					tempArray = new double[1];
				}
				else
				{
					tempArray = new double[numbersEntered.length+1];
					System.arraycopy( numbersEntered,  0,  tempArray,  0,  numbersEntered.length );
				}
				numbersEntered = tempArray;
				numbersEntered[numbersEntered.length-1] = input.nextDouble();
				
				int noOfRollingDays = 0;
				if (numbersEntered.length<3)
				{
					noOfRollingDays = numbersEntered.length;
				}
				else
				{
					noOfRollingDays = 3;
				}

				System.out.printf("The median of %s is %.1f and the rolling average of the last 3 values is %.1f.%n",
						convertToString(numbersEntered), computeMedian(numbersEntered ), computeRollingAverage(numbersEntered,noOfRollingDays ));
			}
			else if (input.hasNext("quit"))
			{
				finished = true;
			}
			else
			{
				System.out.println("Error - Enter any real number or quit.");
				input.next();
			}
		}
		input.close();

	}
}
