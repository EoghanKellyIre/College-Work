
public class better3Sum {

	public static int Sum( int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			int j = i+1;
			int k = array.length -1;
			while (j<k)
			{
				if (array[i]+array[j]+array[k] ==0)
				{
					System.out.println("Yes");
				}
				else if (array[i] + array[j] + array [k] < 0)
				{
					j++;
				}
				else
				{
					k--;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] array = {-40, -20, -10, 0, 5, 10, 30, 40};
		Sum(array);
	}
	
}