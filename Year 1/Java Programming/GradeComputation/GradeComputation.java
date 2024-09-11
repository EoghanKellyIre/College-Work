
import java.util.Scanner;

public class GradeComputation {

	 public static final String[] MODULE_CODES   = { "CSU11001", "CSU11010", "CSU11013", "CSU11021", "CSU11022", "CSU11026", "CSU11031", "CSU11081", "CSU12002", "STU11002" };
	 public static final int[]    MODULE_CREDITS = {  5,          10,         5,          5,          5,          10,         5,          5,          5,          5         };

	public static int creditsBelowSpecifiedMark( double[] marks, int specifiedMinimumMark )
	{
		if (!(marks==null))
		{
			double[] tempArray = marks.clone();
			int creditsBelowSpecifiedMark = 0;
			for (int i=0; i<MODULE_CODES.length; i++ )
			{
				if (round(tempArray[i]) < specifiedMinimumMark)
				{
					creditsBelowSpecifiedMark += MODULE_CREDITS[i] ;
				}
			}
			return (int) round(creditsBelowSpecifiedMark);
		}
		else
		{
			return 0;
		}
	}
	public static double round( double number )
	{
		int temp = (int) number;
		if ((number-temp)>=.5)
		{
		return temp+1;
		}
		else
		{
			return temp;
		}
	}

	
	public static double weightedAverageMark( double[] marks )
	{
		if (!(marks==null))
		{
			double[] tempArray = marks.clone();
			double weightedAverageMark = 0;
			for (int i=0; i<MODULE_CODES.length; i++ )
			{
				weightedAverageMark += tempArray[i]*MODULE_CREDITS[i];
			}
			return weightedAverageMark/60;
		}
		else
		{
			return 0;
		}
	}
	
	public static String determineOverallGrade( double[] marks )
	{
		if (!(marks==null))
		{
			int countModulesBellowMinAllowedToPass = 0;
			for (int i=0; i<MODULE_CODES.length; i++ )
			{
				if (round(marks [i])<35)
				{
					countModulesBellowMinAllowedToPass += 1;
				}
			}
			return ((round(weightedAverageMark( marks ))>=40 && round(creditsBelowSpecifiedMark(marks,40))<=10 && countModulesBellowMinAllowedToPass<=0)?((round(weightedAverageMark( marks ))>=50)?
					((round(weightedAverageMark( marks ))>=60)?((round(weightedAverageMark( marks ))>=70)?"I":"II.1"):"II.2"):"III"):"FAIL");
		}
		else
		{
			return null;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to the first year grade assessor.");
		double[] marks = new double [MODULE_CODES.length];
		Scanner input = new Scanner (System.in);
		boolean finishedMain = false;
		
		while (!finishedMain)
		{
			for (int i=0; i<MODULE_CODES.length; i++ )
			{
				boolean finished = false;
				while (!finished)
				{
					System.out.print("Enter the student mark for " + MODULE_CODES[i] + " (or enter quit): ");
					if (input.hasNextDouble())
					{
						double checkIfPossible = input.nextDouble();
						if ((checkIfPossible>=0) && (checkIfPossible<=100))
						{
							marks [i] = checkIfPossible;
							finished = true;
						}
						else
						{
							System.out.println("Error - Enter a number between 0.0 and 100.0 or quit.");
						}
					}
					else if (input.hasNext("quit"))
					{
						finishedMain = true;
						finished = true;
						i=MODULE_CODES.length;
					}
					else
					{
						System.out.println("Error - Enter a number between 0.0 and 100.0 or quit.");
						input.next();
					}
				}
			}
			if (!finishedMain)
			{
				System.out.printf("Result = %s with an overall mark of %.0f", determineOverallGrade( marks ), round(weightedAverageMark( marks )) );
				System.out.print("%.");
				if (determineOverallGrade( marks ) == "FAIL")
				{
					System.out.printf("  %d credits were failed.%n",creditsBelowSpecifiedMark(marks,40 ));
				}
				System.out.printf("%n");
			}
		}
		input.close();
	}

}
