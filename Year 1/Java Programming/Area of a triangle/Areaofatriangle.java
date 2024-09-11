import java.util.Scanner;
	
public class Areaofatriangle {
		public static void main(String[] args) {
			System.out.println("Enter the X&Y coordinates of each point (X number then space Y) ");
			Scanner input =new Scanner(System.in );
			double firstXvalue = input.nextDouble();
			double firstYvalue = input.nextDouble();
			double secondXvalue = input.nextDouble();
			double secondYvalue = input.nextDouble();
			double thirdXvalue = input.nextDouble();
			double thirdYvalue = input.nextDouble();
			input.close();
		
			double area = (
				Math.abs(((firstXvalue*(secondYvalue-thirdYvalue))+secondXvalue*(thirdYvalue-firstYvalue)+
				thirdXvalue*(firstYvalue-secondYvalue))/2)
			);
				
			System.out.println(
				"For points (" + firstXvalue + "," + firstYvalue + ") , (" + secondXvalue + "," + secondYvalue + ") , ("
				+ thirdXvalue + "," + thirdYvalue + ") , the area of this triangle is " + area
			);		
		}

}