
/*  SELF ASSESSMENT of whether my code is easy to understand.
1. Did I use easy-to-understand meaningful variable and constant names?
    Mark out of 10:   10
    Comment: Yes, I used meaningful variable and constant names.
2. Did I format the variable and constant names properly (in lowerCamelCase and UPPERCASE)?
    Mark out of 5:   5
    Comment: Yes, I formated the variable and constant names correctly.
3. Did I indent the code appropriately?
    Mark out of 10:  10 
    Comment: Yes, I indented the code appropriately.
4. Did I implement a for loop to read the input as required?
    Mark out of 10:  10 
    Comment: Yes, I put the for loop to read the input.
   Total Mark out of  35 (Add all the previous marks):  35
*/

import java.util.Scanner;
public class TotalAverageCalculator {
	
	public static final int MAX_NUMBER_ALLOWED = 10;
	public static final int MIN_NUMBER_ALLOWED = 1;
	public static final int START_VALUE_OF_SUM_OF_NUMBERS = 0;
	
	public static void main(String[] args) {
		System.out.print("How many integers do you want to enter? ");
		Scanner input = new Scanner( System.in );
		int numberOfIntegersWantedToEnter = input.nextInt();
		double sumOfNumbers = START_VALUE_OF_SUM_OF_NUMBERS;
		if ((numberOfIntegersWantedToEnter > MIN_NUMBER_ALLOWED) && (numberOfIntegersWantedToEnter <= MAX_NUMBER_ALLOWED))
		{
			for (int count = 1; (count <= numberOfIntegersWantedToEnter); count++)
			{	
				System.out.print("Enter integer " + count + " : ");
				int inputedNumber = input.nextInt();
				sumOfNumbers +=  inputedNumber;
			}
			double averageOfNumbers = (sumOfNumbers/numberOfIntegersWantedToEnter);
			System.out.printf("The sum of your integers is %.0f ", sumOfNumbers);
			System.out.printf("and the average is %.2f ", averageOfNumbers);
		}
		else 
		{
			System.out.print("Error:  This program is constrained to only compute the total & average of between 2 & 10 integers.");
		}
		input.close();
	}

}
