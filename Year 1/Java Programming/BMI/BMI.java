import java.util.Scanner;

public class BMI {

	public static void main(String[] args) {
		System.out.print("What is your weight in kg? ");
		Scanner input = new Scanner( System.in );
		double weight = input.nextDouble();
		System.out.print("What is your height in metres? ");
		double height = input.nextDouble();
		double bmi = weight/(height*height):
		input.close();	
		
		System.out.println("Your BMI is " + bmi);
		}
			
	}

