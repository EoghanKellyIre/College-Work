/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5:   5
       Comment: Yes, I used easy to understand variable names.
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: Yes, I formatted then correctly.
   3. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: Yes, I indented my code correctly.
   4. Did I implement a while loop or do-while loop as required?
       Mark out of 10:   10
       Comment: I implemented a while loop as required.
      Total Mark out of  25 (Add all the previous marks):  25
*/

import java.util.Scanner;

public class IncrementalStatistics {

	public static final int STARTING_NUMBER = 0;
	public static final int FIRST_TOTAL_NUMBER_OF_NUMBERS_ENTERED = 1;
	
	public static void main(String[] args)
	{
		System.out.println("This program computes the average and variance of all numbers entered.");
		boolean finished = false;
		double average = STARTING_NUMBER;
		double variance = STARTING_NUMBER;
		int amountOfNumbersEnteredSoFar = FIRST_TOTAL_NUMBER_OF_NUMBERS_ENTERED;
		System.out.print("Enter a number (or type 'exit'): ");
		Scanner input = new Scanner( System.in );
		if (input.hasNextDouble())
		{
			double firstNumber = input.nextDouble();
			average = firstNumber;
			System.out.printf("So far the average is %.1f and the variance is %.1f%n", average, variance);
			amountOfNumbersEnteredSoFar++;
		}
		else if (input.hasNext("exit")||input.hasNext("quit"))
		{
			finished = true;
		}
		else
		{
			System.out.println("Error:  You must enter a real number (e.g. 12.5)");
			input.next();
		}
		while (!finished)
		{
			System.out.print("Enter another number (or type 'exit'): ");
			if (input.hasNextDouble())
			{
				double currentNumber = input.nextDouble();
				double oldAverage = average;
				double oldVariance = variance;
				average = oldAverage + ((currentNumber-oldAverage)/amountOfNumbersEnteredSoFar);
				variance = (((amountOfNumbersEnteredSoFar - 1)*oldVariance+((currentNumber - oldAverage)*
						(currentNumber-average)))/amountOfNumbersEnteredSoFar);
				System.out.printf("So far the average is %.1f and the variance is %.1f%n", average, variance);
				amountOfNumbersEnteredSoFar++;
			}
			else if (input.hasNext("exit")||input.hasNext("quit"))
			{
				finished = true;
			}
			else
			{
				System.out.println("Error:  You must enter a real number (e.g. 12.5)");
				input.next();
			}
		}
		input.close();
		System.out.println("Goodbye.");
	}
}
