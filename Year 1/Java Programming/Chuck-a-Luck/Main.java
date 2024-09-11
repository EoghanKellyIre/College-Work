import java.util.Scanner;

public class Main {

	public static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		System.out.println("How much would you like to put into the wallet.");
		boolean finished = false;
		Wallet wallet = new Wallet();
		double money = 0;
		while (!finished)
		{
			System.out.println("Please enter a euro amount greater than zero to bet with.");
			if (input.hasNextDouble())
			{
				money = (input.nextDouble()*100);
				if ((money) % 1 == 0)
				{
					finished = true;
				}
			}
			else
			{
				input.next();
			}
		}
		input.nextLine();
		wallet.put(money);
		finished = false;
		while (!finished)
		{
			System.out.printf("Which you you like to bet? %n (1)- Triple %n (2)- Field %n (3)- High %n (4)- Low %n Or type quit %n");
			if (input.hasNext("Triple") || input.hasNext("Field") ||  input.hasNext("High") || input.hasNext("Low"))
			{
				String betType = input.nextLine();
				ResolveBet (betType, wallet);
				if(wallet.check()==0)
				{
					finished = true;
					System.out.println("You ran out of money.");
					System.out.println("You started with " + money/100 + "€.");
					double walletAmount = wallet.check();
					System.out.println("You now have " + walletAmount/100 + "€.");
					System.out.println("You made a " + ((walletAmount>money)?"profit ":"loss ") + "of " + (money-walletAmount)/100 + "€.");
				}

			}
			else if (input.hasNext("quit"))
			{
				finished = true;
				System.out.println("You started with " + money/100 + "€.");
				double walletAmount = wallet.check();
				System.out.println("You now have " + walletAmount/100 + "€.");
				System.out.println("You made a " + ((walletAmount>money)?"profit ":"loss ") + "of " + (money-walletAmount)/100 + "€.");
			}
			else
			{
				System.out.println("Error - Enter any bet type with correct capitalisation or quit.");
				System.out.println("");
				input.next();
			}
		}
		input.close();
	}
	
	public static void ResolveBet ( String betType, Wallet wallet)
	{
		double walletAmount = wallet.check()/100;
		System.out.println("You have this much in your wallet: " + walletAmount + "€");
		System.out.println("How much would you like to bet?");
		boolean finished = false;
		while (!finished)
		{
			if (input.hasNextDouble())
			{
				Double betAmount = input.nextDouble();
				input.nextLine();
				if (!(betAmount<0) && walletAmount>=betAmount && (betAmount*100) % 1 == 0)
				{
					wallet.get(betAmount*100);
					int totalRolled = 0;
					int[] rolls = new int[3];
					Dice[] threeDice = new Dice[3];
					for(int i=0; i<threeDice.length; i++)
					{
						int topFace = 0;
						threeDice[i] = new Dice();
						topFace = threeDice[i].roll();
						totalRolled += topFace;
						rolls[i] = topFace;
						System.out.println("You rolled a " + topFace);
					}
					boolean result = false;
					result = checkBet ( betType, rolls, totalRolled );
					double winnings = 0;
					if (result==true)
					{
						switch (betType)
						{
							case "Triple":
								winnings = betAmount*30 + betAmount;
								break;
							case "Field":
								winnings = betAmount*1 + betAmount;
								break;
							case "High":
								winnings = betAmount*1 + betAmount;
								break;
							case "Low":
								winnings = betAmount*1 + betAmount;
								break;
							default:
								break;
						}
						System.out.println("You won " + winnings + "€.");
						wallet.put(winnings*100);
					}
					System.out.println(result?"You guessed right!":"You were wrong.");
					System.out.println("");
					finished = true;
				}
				else
				{
					System.out.println("Error, the number needs to be a positive number, less than your wallet of " + walletAmount + ".");
				}
			}
			else
			{
				System.out.println("Error, the number needs to be a positive number, less than your wallet of " + walletAmount + ".");
				input.next();
			}
		}
	}
	
	public static boolean checkBet ( String betType, int[] rolls, int totalRolled  )
	{
		String betTypeGuessed = betType;
		boolean correctOrWrong = false;
		boolean isTriple = false;
		if (rolls[0] == rolls[1] && rolls[1] == rolls[2])
		{
			isTriple = true;
		}
		switch (betTypeGuessed)
		{
		case "Triple":
			if(isTriple && !(rolls[0] == 6) && !(rolls[0] == 1))
			{
				correctOrWrong = true;
			}
			break;
		case "Field":
			if(totalRolled<8 || totalRolled>12)
			{
				correctOrWrong = true;
			}
			break;
		case "High":
			if(totalRolled>10 && !isTriple)
			{
				correctOrWrong = true;
			}
			break;
		case "Low":
			if(totalRolled<11 && !isTriple)
			{
				correctOrWrong = true;
			}
			break;
		default:
		break;
		}
		return correctOrWrong;
	}

}

/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7 ].
Comment:Yes it does
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment:Yes it does
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5: 5].
Comment:Yes it does
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15:15 ]..
Comment:Yes it does
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20:20 ].
Comment:Yes it does
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: 10 ].
Comment:Yes it does

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15 ]
Comment: Yes it does
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5: 5]
Comment:Yes it does
I ask the user to enter any of the four bet types or quit [Mark out of 5: 5 ].
Comment:Yes I am
My program calls resolveBet for each bet type entered [Mark out of 5: 5 ].
Comment:Yes it does
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5 ]
Comment:Yes it does

 Total Mark out of 100 (Add all the previous marks):100
*/