import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNull;

import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @author  
 *  @version 13/10/16 18:15
 */
@RunWith(JUnit4.class)
public class DoublyLinkedListTest
{
    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new DoublyLinkedList<Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    
    /**
     * Check if the isEmpty works
     */
    @Test
    public void testIsEmpty()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        Boolean expectedResult = null;
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
     // test non-empty list
        expectedResult = false;
        assertEquals( "Checking isEmpty to a list containing 3 elements - expected false", expectedResult, testDLL.isEmpty() );
        
     // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        expectedResult = true;
        assertEquals( "Checking isEmpty to an empty list - expected true", expectedResult, testDLL.isEmpty() );
    }
    
    /**
     * Check if the insertBefore works
     */
    @Test
    public void testInsertBefore()
    {
        // test non-empty list
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);

        testDLL.insertBefore(0,4);
        assertEquals( "Checking insertBefore to a list containing 3 elements at position 0", "4,1,2,3", testDLL.toString() );
        testDLL.insertBefore(1,5);
        assertEquals( "Checking insertBefore to a list containing 4 elements at position 1", "4,5,1,2,3", testDLL.toString() );
        testDLL.insertBefore(2,6);       
        assertEquals( "Checking insertBefore to a list containing 5 elements at position 2", "4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(-1,7);        
        assertEquals( "Checking insertBefore to a list containing 6 elements at position -1 - expected the element at the head of the list", "7,4,5,6,1,2,3", testDLL.toString() );
        testDLL.insertBefore(7,8);        
        assertEquals( "Checking insertBefore to a list containing 7 elemenets at position 8 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8", testDLL.toString() );
        testDLL.insertBefore(700,9);        
        assertEquals( "Checking insertBefore to a list containing 8 elements at position 700 - expected the element at the tail of the list", "7,4,5,6,1,2,3,8,9", testDLL.toString() );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);        
        assertEquals( "Checking insertBefore to an empty list at position 0 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(10,1);        
        assertEquals( "Checking insertBefore to an empty list at position 10 - expected the element at the head of the list", "1", testDLL.toString() );
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(-10,1);        
        assertEquals( "Checking insertBefore to an empty list at position -10 - expected the element at the head of the list", "1", testDLL.toString() );
    }
    
    /**
     * Check if the get works
     */
    @Test
    public void testGet()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        Integer expectedResult = null;
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
        // test if position is less than 0
        expectedResult = null;
        assertEquals( "Checking get to a list containing 3 elements at position -5 - expected the element at the head of the list - expected null", expectedResult, testDLL.get(-5) );
        
        // test if position is more than list
        expectedResult = null;
        assertEquals( "Checking get to a list containing 3 elements at position 5 - expected the element at the tail of the list - expected null", expectedResult, testDLL.get(5) );
        
        // test if position is at the head
        expectedResult = 1;
        assertEquals( "Checking get to a list containing 3 elements at position 1 - expected the element at the head of the list - expected 1", expectedResult, testDLL.get(0) );
        assertEquals( "Checking get to a list containing 3 elements at position 1 - expected the element at the head of the list - expected 1", expectedResult, testDLL.get(0) );
        
        // test if position is at the tail
        expectedResult = 3;
        assertEquals( "Checking get to a list containing 3 elements at position 3 - expected the element at the tail of the list - expected 3", expectedResult, testDLL.get(2) );
        assertEquals( "Checking get to a list containing 3 elements at position 3 - expected the element at the tail of the list - expected 3", expectedResult, testDLL.get(2) );
        
        // test if position is within the list
        expectedResult = 2;
        assertEquals( "Checking get to a list containing 3 elements at position 2 - expected 2", expectedResult, testDLL.get(1) );
        assertEquals( "Checking get to a list containing 3 elements at position 2 - expected 2", expectedResult, testDLL.get(1) );

        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        expectedResult = null;
        assertEquals( "Checking get to an empty list - expected null", expectedResult, testDLL.get(1) );
    }
    
    /**
     * Check if the deleteAt works
     */
    @Test
    public void testDeleteAt()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        Boolean expectedResult = null;
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
        // test if position is less than 0
        expectedResult = false;
        assertEquals( "Checking deleteAt to a list containing 3 elements at position -5 - false", expectedResult, testDLL.deleteAt(-5) );
        
        // test if position is more than list
        expectedResult = false;
        assertEquals( "Checking deleteAt to a list containing 3 elements at position 5 - false", expectedResult, testDLL.deleteAt(5) );
        
        // test if position is at the head
        expectedResult = true;
        assertEquals( "Checking deleteAt to a list containing 3 elements at position 1 - true", expectedResult, testDLL.deleteAt(0) );
        
        testDLL.insertBefore(0,1);
        // test if position is at the tail
        expectedResult = true;
        assertEquals( "Checking deleteAt to a list containing 3 elements at position 3 - true", expectedResult, testDLL.deleteAt(2) );
     
        testDLL.insertBefore(2,3);
        // test if position is within the list
        expectedResult = true;
        assertEquals( "Checking deleteAt to a list containing 3 elements at position 2 - true", expectedResult, testDLL.deleteAt(1) );
        
        // test list with length 1
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        expectedResult = true;
        assertEquals( "Checking deleteAt to a list containing 1 elements at position 2 - true", expectedResult, testDLL.deleteAt(0) );
        
        // test list with length 2
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(2,3);
        expectedResult = true;
        assertEquals( "Checking deleteAt to a list containing 1 elements at position 1 - true", expectedResult, testDLL.deleteAt(1) );
        
        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        expectedResult = false;
        assertEquals( "Checking deleteAt to an empty list - expected null", expectedResult, testDLL.deleteAt(1) );
    }
    
    /**
     * Check if the reverse works
     */
    @Test
    public void testReverse()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        Integer expectedResult = null;
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
        // test reverse
        testDLL.reverse();
        expectedResult = 1;
        assertEquals( "Checking reverse to a list containing 3 elements at position 3 - expected 1", expectedResult, testDLL.get(2) );
        expectedResult = 2;
        assertEquals( "Checking reverse to a list containing 3 elements at position 2 - expected 3", expectedResult, testDLL.get(1) );
        expectedResult = 3;
        assertEquals( "Checking reverse to a list containing 3 elements at position 1 - expected 3", expectedResult, testDLL.get(0) );
        
        // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.reverse();
        expectedResult = null;
        assertEquals( "Checking reverse to an empty list - expected null", expectedResult, testDLL.get(1) );
    }
    
    /**
     * Check if the makeUnique works
     */
    @Test
    public void testMakeUnique()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        Integer expectedResult = null;
        
        // test Unique
        testDLL.insertBefore(0,1);
        testDLL.makeUnique();
        expectedResult = 1;
        assertEquals( "Checking makeUnique to a list containing 1 elements at position 1 - expected 1", expectedResult, testDLL.get(0) );
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(2,3);
        testDLL.insertBefore(7,1);
        testDLL.makeUnique();
        expectedResult = 1;
        assertEquals( "Checking makeUnique to a list containing 6 elements at position 1 - expected 1", expectedResult, testDLL.get(0) );
        expectedResult = 3;
        assertEquals( "Checking makeUnique to a list containing 6 elements at position 3 - expected 3", expectedResult, testDLL.get(2) );
        expectedResult = null;
        assertEquals( "Checking makeUnique to a list containing 6 elements at position 5 - expected null", expectedResult, testDLL.get(5) );
        
     // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.makeUnique();
        expectedResult = null;
        assertEquals( "Checking makeUnique to an empty list - expected null", expectedResult, testDLL.get(1) );
    }
    
    /**
     * Check if the push works
     */
    @Test
    public void testpush()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        String expectedResult = null;
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
     // test non-empty list
        testDLL.push(5);
        expectedResult = "5,1,2,3";
        assertEquals( "Checking push to a list containing 3 elements - expected 5,1,2,3", expectedResult, testDLL.toString() );
        
     // test non-empty list of 1
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.insertBefore(0,1);
        testDLL.push(5);
        expectedResult = "5,1";
        assertEquals( "Checking push to a list containing 1 elements - expected 5,1", expectedResult, testDLL.toString() );
        
     // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(5);
        expectedResult = "5";
        assertEquals( "Checking push to an empty list - expected 5", expectedResult, testDLL.toString() );
    }
    
    /**
     * Check if the pop works
     */
    @Test
    public void testPop()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        String expectedResult = null;
        testDLL.insertBefore(0,1);
        testDLL.insertBefore(1,2);
        testDLL.insertBefore(2,3);
        
     // test non-empty list
        testDLL.push(5);
        testDLL.pop();
        expectedResult = "1,2,3";
        assertEquals( "Checking pop to a list containing 3 elements - expected 1,2,3", expectedResult, testDLL.toString() );
        
     // test non-empty list of 1
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.push(5);
        testDLL.pop();
        expectedResult = "";
        assertEquals( "Checking pop to a list containing 1 elements - expected  ", expectedResult, testDLL.toString() );
        
     // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.pop();
        expectedResult = "";
        assertEquals( "Checking pop  to an empty list - expected  ", expectedResult, testDLL.toString() );
    }

    /**
     * Check if the enqueue works
     */
    @Test
    public void testEnqueue()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        Integer expectedResult = null;
        
     // test non-empty list
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);
        expectedResult = 1;
        assertEquals( "Checking enqueue with 3 elements - expected 1", expectedResult, testDLL.dequeue() );
        
     // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        expectedResult = 1;
        assertEquals( "Checking enqueue to an empty list - expected 1", expectedResult, testDLL.dequeue() );
    }
    
    /**
     * Check if the dequeue works
     */
    @Test
    public void testDequeue()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        Integer expectedResult = null;
        
     // test non-empty list
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);
        expectedResult = 1;
        assertEquals( "Checking dequeue to a list containing 3 elements - expected 1", expectedResult, testDLL.dequeue() );
        expectedResult = null;
        assertEquals( "Checking dequeue to a list if deleted - expected null", expectedResult, testDLL.get(3) );
        
     // test non-empty list of 1
        testDLL = new DoublyLinkedList<Integer>();
        testDLL.enqueue(1);
        expectedResult = 1;
        assertEquals( "Checking dequeue to a list containing 3 elements - expected 1", expectedResult, testDLL.dequeue() );
        expectedResult = null;
        assertEquals( "Checking dequeue to a list if deleted - expected null", expectedResult, testDLL.get(1) );
        
     // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        expectedResult = null;
        assertEquals( "Checking dequeue  to an empty list - expected null", expectedResult, testDLL.dequeue() );
    }

    /**
     * Check if the toString works
     */
    @Test
    public void testToString()
    {
        DoublyLinkedList<Integer> testDLL = new DoublyLinkedList<Integer>();
        String expectedResult = null;
        
     // test non-empty list
        testDLL.enqueue(1);
        testDLL.enqueue(2);
        testDLL.enqueue(3);
        expectedResult = "1,2,3";
        assertEquals( "Checking toString to a list containing 3 elements - expected 1,2,3", expectedResult, testDLL.toString() );
        
      // test empty list
        testDLL = new DoublyLinkedList<Integer>();
        expectedResult = "";
        assertEquals( "Checking toString to a empty list - expected  ", expectedResult, testDLL.toString() );
    }
}
