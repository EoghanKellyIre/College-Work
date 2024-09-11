/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:   10
       Comment: Yes, I used easy-to-understand meaningful variable names.
   2. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: I formated each variable name correctly.
   3. Did I indent the code appropriately?
       Mark out of 15:   15
       Comment: Yes, I indented my code correctly to make it easy-to-understand.
      Total Mark out of  30 (Add all the previous marks):  30
*/

import java.util.Scanner;

public class PlantClassifier {

	public static void main(String[] args) {
		Scanner input = new Scanner( System.in );
		System.out.print("Does the plant have cells and tissues which are organised into functional structures (Yes/No)? ");
		String isOrgansisedIntoFunctionalStrutures = input.next();
		boolean isOrgansisedIntoFunctionalStruturesAnswer = isOrgansisedIntoFunctionalStrutures.equalsIgnoreCase("Yes");
		if (!isOrgansisedIntoFunctionalStruturesAnswer) 
		{
			System.out.println("The plant is an ALGAE.");
		}
		else
		{
			System.out.print("Does the plant have vascular tissues (Yes/No)? ");
			String haveVascularTissues = input.next();
			boolean haveVascularTissuesAnswer = haveVascularTissues.equalsIgnoreCase("Yes");
			if(!haveVascularTissuesAnswer)
			{
				System.out.println("The plant is a BRYOPHYTE.");
			}
			else
			{
				System.out.print("Is the plant dispersed by seeds (Yes/No)? ");
				String isDispersedBySeeds = input.next();
				boolean isDispersedBySeedsAnswer = isDispersedBySeeds.equalsIgnoreCase("Yes");
				
				if (!isDispersedBySeedsAnswer)
				{
					System.out.println("The plant is a PTERIDOPHYTE.");
				}
				else 
				{
					System.out.print("Are the seeds enclosed (Yes/No)? ");
					String seedsEnclosed = input.next();
					boolean seedsEnclosedAnswer = seedsEnclosed.equalsIgnoreCase("Yes");
					
					if (!seedsEnclosedAnswer)
					{
						System.out.println("The plant is a GYMNOSPERM.");
					}
					else 
					{
						System.out.println("The plant is an ANGIOSPERM.");
					}
				}
			}
		}
		input.close();
	}
}
