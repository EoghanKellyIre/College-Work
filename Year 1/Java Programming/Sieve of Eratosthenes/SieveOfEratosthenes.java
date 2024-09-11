import java.util.Scanner;

public class SieveOfEratosthenes {

	public static void main(String[] args) {
		System.out.println("Welcome to the Sieve of Eratosthenes system.");
		System.out.println("This system finds all the prime numbers in the range from 2 through to any given number N.");
		Scanner input = new Scanner (System.in);
		boolean finished = false;
		while (!finished)
		{
			System.out.print("Please enter an upper limit N (A postive whole number greater than 2): ");
			if (input.hasNextInt())
			{
				int upperLimit = input.nextInt();
				if (!(upperLimit<2))
				{
					sieve ( upperLimit );
					finished = true;
				}
			}
			else
			{
				System.out.println("Error, the number needs to be a positive whole number, greater than 2.");
			}
		}
		input.close();

	}
	
	public static String[] createSequence ( int inputedNumber )
	{
		int upperLimit = inputedNumber;
		String[] numbersUpToLimit = null;
		numbersUpToLimit = new String[upperLimit-1];
		for (int i=2; i<=upperLimit; i++)
		{
			numbersUpToLimit[i-2] = String.valueOf(i);
		}
		return numbersUpToLimit;
	}
	
	public static String[] crossOutHigherMultiples  ( String[] numbersUpToLimit, int upperLimit)
	{
		if (!(numbersUpToLimit==null))
		{
			boolean changed = false;
			for (int i=upperLimit-1; i<=numbersUpToLimit.length-1; i++)
			{
				if ((i+2)%upperLimit==0)
				{
					if (!numbersUpToLimit[i].contains("["))
					{
						numbersUpToLimit[i] = ("[" + numbersUpToLimit[i] + "]");
						changed = true;
					}
				}
			}
			if (changed == true)
			{
				System.out.println(sequenceToString ( numbersUpToLimit ));
			}
		}
		return numbersUpToLimit;
	}
	
	public static String[] sieve ( int upperLimit )
	{
		String[] numbersUpToLimit = createSequence ( upperLimit );
		String[] finised = null;
		System.out.println(sequenceToString ( numbersUpToLimit ));
		for (int i=2; i<=numbersUpToLimit.length; i++)
		{
			finised = crossOutHigherMultiples  ( numbersUpToLimit, i);
		}
		System.out.println(nonCrossedOutSubseqToString ( numbersUpToLimit ));
		
		return finised;
	}
	
	public static String sequenceToString ( String[] numbersUpToLimit )
	{
		if(!(numbersUpToLimit==null))
		{
			String allNumbers = "";
			for (int i=0; i<=numbersUpToLimit.length-1; i++)
			{
				if (!(i==numbersUpToLimit.length-1))
				{
					allNumbers += numbersUpToLimit[i]+ ", ";
				}
				else
				{
					allNumbers += numbersUpToLimit[i];
				}
			}
			return allNumbers;
		}
		return null;
	}
	
	public static String nonCrossedOutSubseqToString ( String[] numbersUpToLimit )
	{
		if (!(numbersUpToLimit==null))
		{
			String allPrimeNumbers = "";
			for (int i=0; i<=numbersUpToLimit.length-1; i++)
			{
				if(!numbersUpToLimit[i].contains("["))
				{
					allPrimeNumbers += numbersUpToLimit[i]+ ", ";
				}
			}
			return allPrimeNumbers.substring(0, allPrimeNumbers.length() - 2);
		}
		return null;
	}

}
/* SELF ASSESSMENT 
1.    createSequence:
Did I use the correct method definition?
Mark out of 5:5
Comment:Yes i did.
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment:Yes I did.
Did I return the correct item?
Mark out of 5:5
Comment:Yes I did.
2.    crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment:Yes I did.
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2:2
Comment:Yes I did.
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment:Yes I did.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3:3
Comment:Yes
3.    sieve   
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes I did.
Did I make calls to other methods?
Mark out of 5:5
Comment:Yes I did.
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:2
Comment:Yes I did.
4.    sequenceTostring  
Did I have the correct function definition?
Mark out of 5:5
Comment:Yes I did.
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: Yes I did.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10
Comment:Yes I did.
5.    nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5:5
Comment:Yes I did.
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment:Yes I did.
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5:5
Comment:Yes I did.
6.    main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5:5
Comments:Yes I did.
Did I make calls to other methods (at least one)?
Mark out of 5:5
Comment:  Yes I did.
Did I print the output as shown in the question?  
Mark out of 5:5
Comment:  Yes I did.
7.    Overall
Is my code indented correctly?
Mark out of 4:4
Comments:Yes I did.
Do my variable names make sense?
Mark out of 4:4
Comments:Yes they did.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4:4
Comments:Yes they do.
   Total Mark out of 100 (Add all the previous marks): 100
*/