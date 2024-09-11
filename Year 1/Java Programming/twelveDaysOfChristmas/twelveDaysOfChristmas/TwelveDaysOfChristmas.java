
/*
 * 		12 drummers drumming
		11 pipers piping
		10 lords a-leaping
		Nine ladies dancing
		Eight maids a-milking
		Seven swans a-swimming
		Six geese a-laying
		Five golden rings
		Four calling birds
		Three french hens
		Two turtle doves, and
		A partridge in a pear tree
*/
package twelveDaysOfChristmas;

public class TwelveDaysOfChristmas {

	public static void main(String[] args) {
		
		for(int days=1; (days<13); days++)
		{	
			System.out.print("On the ");
			switch (days)
			{
			case 1:
				System.out.print("first");
			break;
			case 2:
				System.out.print("second");
				break;
			case 3:
				System.out.print("third");
				break;
			case 4:
				System.out.print("fourth");
				break;
			case 5:
				System.out.print("fifth");
				break;
			case 6:
				System.out.print("sixth");
				break;
			case 7:
				System.out.print("seventh");
				break;
			case 8:
				System.out.print("eighth");
				break;
			case 9:
				System.out.print("ninth");
				break;
			case 10:
				System.out.print("tenth");
				break;
			case 11:
				System.out.print("eleventh");
				break;
			default:
				System.out.print("twelfth");
			break;
			}
			System.out.println(" day of Christmas my true love sent to me:");
			int switchDays = -days + 13;
			switch (switchDays)
			{
			case 1:
				System.out.println("12 drummers drumming,");
			case 2:
				System.out.println("11 pipers piping,");
			case 3:
				System.out.println("10 lords a-leaping,");
			case 4:
				System.out.println("Nine ladies dancing,");
			case 5:
				System.out.println("Eight maids a-milking,");
			case 6:
				System.out.println("Seven swans a-swimming,");
			case 7:
				System.out.println("Six geese a-laying,");
			case 8:
				System.out.println("Five golden rings,");
			case 9:
				System.out.println("Four calling birds,");
			case 10:
				System.out.println("Three french hens,");
			case 11:
				System.out.println("Two turtle doves, and");
			default:
				System.out.println("A partridge in a pear tree.");
			break;
			}
		}
	}

}
