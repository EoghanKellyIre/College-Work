import java.util.Scanner;


public class Hours_Worked {

	private static final double MINUTES_PER_HOUR = 60.0;

	public static void main(String[] args) {
		System.out.print("Enter hourly rate (Euros.Cents):");
		Scanner input = new Scanner( System.in );
		double hourlyrate = input.nextDouble();
		System.out.print("What is your time worked? (Hours:Minutes) ");
		input.useDelimiter("(\\p{javaWhitespace}|\\:)+");
		int hoursWorked = input.nextInt();
		int minutesWorked = input.nextInt();
		input.close();	
		double totalHoursWorked = ((double) hoursWorked) +
				(((double) minutesWorked)/((double) MINUTES_PER_HOUR));
				double totalWages = hourlyrate * totalHoursWorked;
				System.out.println("Amount earned: €" + totalWages); 
		}	

}
