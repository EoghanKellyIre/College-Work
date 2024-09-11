
public class Swap {
	private String firstNumber;
	private String secondNumber;
	
	public String getFirstNumber()
	{
		return firstNumber;
	}

	public void setFirstNumber(String enteredFirstNumber)
	{
		firstNumber = enteredFirstNumber;
	}
	
	public String getSecondNumber()
	{
		return secondNumber;
	}

	public void setSecondNumber(String enteredSecondNumber)
	{
		secondNumber = enteredSecondNumber;
	}
	
	public void swap(String enteredFirstNumber, String enteredSecondNumber)
	{
		firstNumber = enteredSecondNumber;
		secondNumber = enteredFirstNumber;
	}
}
