
public class LinearSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	boolean isContained1(int[] A, int[] B) {
		boolean AInB = true;
		for (int i = 0; i < A.length; i++) {
	//	boolean iInB = linearSearch(B, A[i]);
	//	AInB = AInB && iInB;
		}
		return AInB;
		}

	boolean isContained2(int[] A, int[] B) {
	//	int[] C = new int[B.length];
	//	for (int i = 0; i < B.length; i++) { C[i] = B[i] }
	//	sort(C); // heapsort
		boolean AInC = true;
		for (int i = 0; i < A.length; i++) {
	//	boolean iInC = binarySearch(C, A[i]);
	//	AInC = AInC && iInC;
		}
		return AInC;
		}

}
