import java.util.Scanner;

/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5:   5
       Comment: I used easy-to-understand meaningful and properly formatted variable names.
    2. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: I indented my code correctly.
   3. Did I make use of the functions appropriately within main and the other functions?
       Mark out of 10:   10
       Comment:  Yes, I think I did use the functions appropriately within main and the other functions.
       Total Mark out of  20 (Add all the previous marks):  20
*/

public class ThreeNumbers {
	
	public static final int NUMBER_OF_INTEGERS_ALLOWED = 3;

	public static int medianOf( int firstNumber, int secondNumber, int thirdNumber )
	{
		int median = (firstNumber>=secondNumber?(secondNumber>=thirdNumber?secondNumber:(firstNumber>=thirdNumber?thirdNumber:firstNumber)):
			(firstNumber>=thirdNumber?firstNumber:(secondNumber>thirdNumber?thirdNumber:secondNumber)));	
		return median;
	}
	
	public static double averageOf( int firstNumber, int secondNumber, int thirdNumber )
	{
		double firstNumberAsDouble = firstNumber;
		double secondNumberAsDouble = secondNumber;
		double thirdNumberAsDouble = thirdNumber;
		double average = ((firstNumberAsDouble + secondNumberAsDouble + thirdNumberAsDouble)/NUMBER_OF_INTEGERS_ALLOWED);
		return average;
	}

	public static int countOfNumbersGreaterThanTheAverage( int firstNumber, int secondNumber, int thirdNumber )
	{
		int countOfNumbersGreaterThanTheAverage = 0;
		double average = averageOf(firstNumber, secondNumber, thirdNumber);
		if(firstNumber>average)
		{
			countOfNumbersGreaterThanTheAverage+=1;
		}
		if(secondNumber>average)
		{
			countOfNumbersGreaterThanTheAverage+=1;
		}
		if(thirdNumber>average)
		{
			countOfNumbersGreaterThanTheAverage+=1;
		}
		return countOfNumbersGreaterThanTheAverage;
	}
	
	public static String getFormattedOutputString( int median, int countOfNumbersGreaterThanTheAverage )
	{
		String formattedOutputString = ("");
		if (countOfNumbersGreaterThanTheAverage<2)
		{
			formattedOutputString = ("The median of your numbers is " + median + ", and " + 
					countOfNumbersGreaterThanTheAverage + " of them is greater than their average.");
		}
		else
		{
			formattedOutputString = ("The median of your numbers is " + median + ", and " + 
					countOfNumbersGreaterThanTheAverage + " of them are greater than their average.");
		}
		return formattedOutputString;
	}
	
	public static void main(String[] args)
	{
		boolean finished = false;
		Scanner input = new Scanner( System.in );
		while (!finished)
		{
			System.out.print("Please enter your three integers separated by spaces (or enter 'quit'):  ");
			if (input.hasNextInt())
			{
				int firstNumber = input.nextInt();
				int secondNumber = input.nextInt();
				int thirdNumber = input.nextInt();
				int median = medianOf(firstNumber, secondNumber, thirdNumber);
				int countOfNumbersGreaterThanTheAverage = countOfNumbersGreaterThanTheAverage(firstNumber, secondNumber, thirdNumber);
				System.out.println(getFormattedOutputString(median, countOfNumbersGreaterThanTheAverage));
			}
			else if (input.hasNext("exit")||input.hasNext("quit"))
			{
				finished = true;
			}
			else
			{
				System.out.println("Error: No integers were entered");
				input.next();
			}
		}
		input.close();
	}

}
