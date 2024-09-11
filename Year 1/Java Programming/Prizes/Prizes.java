/*
 * SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 5: 5  
       Comment: Yes, I used easy to understand variable names.
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5: 5
       Comment: Yes, I formated the variable names properly.
   3. Did I indent the code appropriately?
       Mark out of 5:   5
       Comment: Yes, I indented my code correctly.
   4. Did I implement a switch statement as required?
       Mark out of 10:   10
       Comment: Yes I used two switch statements fulfilling the requirement to use at least one switch statement.
       Total Mark out of  25 (Add all the previous marks):  25
*/

import java.util.Scanner;

public class Prizes {

	public static void main(String[] args) {
		System.out.println("This program tells competition participants what prize they have won.");
		Scanner input = new Scanner( System.in );
		boolean finished = false;
		while (!finished)
		{
			System.out.print("Enter your place number (or type 'exit'): ");
			if (input.hasNextInt())
			{
				int placeNumber = input.nextInt();
				switch (placeNumber)
				{
				default:
					System.out.println("Sorry.  You did not win a prize.");
					break;
				case 6:
				case 7:
				case 8:
				case 9:
				case 10:
					System.out.printf("You came in %dth place and hence won", placeNumber);
					System.out.printf(" a 5 Euro book token.%n");
					break;
				case 1:
					System.out.print("You came in 1st place and hence won");
					System.out.printf(" two theatre tickets + drinks during the interval + dinner before the show.%n");
					break;
				case 2:
					System.out.print("You came in 2nd place and hence won");
					System.out.printf(" two theatre tickets + drinks during the interval.%n");
					break;
				case 3:
					System.out.print("You came in 3rd place and hence won");
					System.out.printf(" two theatre tickets.%n");
					break;
				case 4:
				case 5:
					System.out.printf("You came in %dth place and hence won", placeNumber);
					System.out.printf(" a 10 Euro book token.%n");
					break;
				}
			}
			else if (input.hasNext("exit")||input.hasNext("quit"))
			{
				finished = true;
			}
			else
			{
				System.out.println("Error:  Please enter your place number");
				input.next();
			}
		}
		input.close();
	}
}