/*  SELF ASSESSMENT of whether my code is easy to understand.
   1. Did I use appropriate CONSTANTS instead of numbers within the code?
       Mark out of 5:    5
       Comment: I used CONSTANTS where appropriate. 
   2. Did I use easy-to-understand, meaningful CONSTANT names?
       Mark out of 5:   5
       Comment: I labeled each CONSTANTS which meaningful names.
        3. Did I format the CONSTANT names properly (in UPPERCASE)?
       Mark out of 5:   5
       Comment: I formated the CONSTANT names appropriately.
   4. Did I use easy-to-understand meaningful variable names?
       Mark out of 10:   10
       Comment: I labeled each variable with easy-to-understand meaningful names.
   5. Did I format the variable names properly (in lowerCamelCase)?
       Mark out of 5:   5
       Comment: I formated the variable names properly.
   6. Did I indent the code appropriately?
       Mark out of 10:   10
       Comment: I indented the code appropriately.
     Total Mark out of  40 (Add all the previous marks):  40
*/

import java.util.Scanner;

public class LoanRepaymentCalculator {
	
	public static final int MONTHS_IN_YEARS = 12;
	
	public static void main(String[] args) {
		System.out.print("Enter loan amount? ");
		Scanner input =new Scanner(System.in );
		double principalAmount = input.nextDouble();
		System.out.print("Enter annual interest rate (e.g. 0.04)? ");
		double annualInterestRate = input.nextDouble();
		System.out.print("Enter the term of the loan in years? ");
		double termOfLoanInYears = input.nextDouble();
		input.close();

		double monthlyInterestRate = (annualInterestRate) / MONTHS_IN_YEARS;
		double termOfLoanInMonths = (termOfLoanInYears) * MONTHS_IN_YEARS;
		
		double monthlyRepaymentAmount =( 
			(principalAmount)*(monthlyInterestRate*(Math.pow((1+monthlyInterestRate),
			termOfLoanInMonths))/((Math.pow((1+monthlyInterestRate), termOfLoanInMonths))-1))
			);

		System.out.printf("The monthly repayment for a %.0f ", termOfLoanInYears);
		System.out.printf("year loan of %.2f ", principalAmount);
		System.out.printf("at an annual interest rate of %.2f ", annualInterestRate);
		System.out.printf("would be %.2f ", monthlyRepaymentAmount);
	}

}
