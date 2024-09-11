
public class Lecture2 {

	public static void main(String[] args) {
		int[] ar = {2, 34, 6, 32, 25, 1, 7, 8, 0};
		int s = 1;
		if(linearSearch1(ar,s))
			{
				System.out.println("Yes");
			}
		else
			{
				System.out.println("No");
			}
		
		if(linearSearch2(ar,s))
		{
			System.out.println("Yes");
		}
	else
		{
			System.out.println("No");
		}
	}

	static boolean linearSearch1(int[] ar, int s) {
		boolean found = false;
		for (int i = 0; i < ar.length; i++) {
		if (ar[i] == s) found = true;
		}
		return found;
		}

	static //Improved Linear Search: return as soon as possible.
			boolean linearSearch2(int[] ar, int s) {
			for (int i = 0; i < ar.length; i++) {
			if (ar[i] == s) return true;
			}
			return false;
			}
}
