import static org.junit.Assert.assertEquals;

public class test {

	public static void main(String[] args) 
	{
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        Integer expectedResult = null;
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
        // test if position is less than 0
        expectedResult = null;
        testDLL.get(-5);
        
        // test if position is more than list
        expectedResult = null;
        testDLL.get(5);
        
        // test if position is at the head
        expectedResult = 1;
        testDLL.get(0);
        
        // test if position is at the tail
        expectedResult = 3;
        testDLL.get(2);
     
        // test if position is within the list
        expectedResult = 2;
        testDLL.get(1);
        
        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        expectedResult = null;
        testDLL.get(1);
	 }
}
