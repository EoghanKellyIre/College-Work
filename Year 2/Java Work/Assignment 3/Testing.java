
public class Testing {

	public static void main(String[] args) {
        BST<Integer, String> bst = new BST<Integer, String>();
        bst.put(7, "B");
        System.out.print(bst.printKeysInOrder());
	}

}
