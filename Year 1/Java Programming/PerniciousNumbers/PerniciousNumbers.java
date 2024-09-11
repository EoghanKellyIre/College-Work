import java.util.Scanner;

/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful and properly formatted variable names?
       Mark out of 5:   5
       Comment: I used easy-to-understand meaningful and properly formatted variable names.
    2. Is my code easy to follow/understand?
       Mark out of 5:   5
       Comment: My code is easy to follow.
   3. Did I use the functions as required?
       Mark out of 10:   10
       Comment: I used the functions required.
       Total Mark out of  20 (Add all the previous marks):  20
*/

public class PerniciousNumbers {
	
	public static String getBinaryString( int numberEntered )
	{
		String binaryString = Integer.toBinaryString(Math.abs(numberEntered));
		if (numberEntered<0)
		{
			return ("-" + binaryString);
		}
		else
		{
			return binaryString;
		}
	}
	
	public static boolean isPernicious( int numberEntered )
	{
		boolean isPernicious = false;
		if (isPrime(countBinaryOnes( numberEntered )))
		{
			isPernicious = true;
		}
		return isPernicious;
	}
	
	public static int countBinaryOnes( int numberEntered )
	{
		int countBinaryOnes = Integer.bitCount(Math.abs(numberEntered));
		return countBinaryOnes;
	}
	
	public static boolean isPrime( int numberEntered )
	{
		boolean isPrime = true;
		if (numberEntered==1 | numberEntered==0)
		{
			isPrime = false;
		}
		for (int i = 2; i <= numberEntered / 2; ++i)
		{
			if (numberEntered % i == 0)
			{
				isPrime = false;
			}
		}	
		return isPrime;
	}

	public static void main(String[] args) 
	{
		System.out.print("Enter the maximum number you want to consider: ");
		Scanner input = new Scanner( System.in );
		if (input.hasNextInt())
		{
			int numberEntered = input.nextInt();
			for (int i=0 ; i<=numberEntered ; i++ )
			{
				if (isPernicious(i))
					System.out.println(i + " is a pernicious number as it contains " + countBinaryOnes(i) +
							((countBinaryOnes(i)>1)?" ones ":" one ") + "in it's binary representation (" + getBinaryString(i) + ")");
			}
		}
		else
		{
			System.out.println("Please enter an integer");
		}
		input.close();
	}
}
