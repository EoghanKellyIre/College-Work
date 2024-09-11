import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for Doubly Linked List
 *
 *  @version 3.1 09/11/15 11:32:15
 *
 *  @author  Eoghán Kelly
 */

@RunWith(JUnit4.class)
public class BSTTest
{
  
	//~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
      new BST<Integer,Integer>();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    
    /**
     * Check if the isEmpty works
     */
    @Test
    public void testIsEmpty()
    {
        BST<Integer,Integer> testBST = new BST<Integer,Integer>();
        Boolean expectedResult = null;
        testBST.put(0, 1);
        testBST.put(1, 5);
        
     // test non-empty list
        expectedResult = false;
        assertEquals( "Checking isEmpty to a BST containing 2 elements - expected false", expectedResult, testBST.isEmpty() );
        
     // test empty list
        testBST = new BST<Integer,Integer>();
        expectedResult = true;
        assertEquals( "Checking isEmpty to an empty BST - expected true", expectedResult, testBST.isEmpty() );
    }

    /**
     * Check if the size works
     */
    @Test
    public void testsize()
    {
        BST<Integer,Integer> testBST = new BST<Integer,Integer>();
        Integer expectedResult = null;
        Integer result = null;
        testBST.put(0, 1);
        testBST.put(1, 5);
        
     // test non-empty list
        expectedResult = 2;
        result = testBST.size();
        assertEquals( "Checking size to a BST containing 2 elements - expected 2", expectedResult, result);
        
     // test empty list
        testBST = new BST<Integer,Integer>();
        expectedResult = 0;
        result = testBST.size();
        assertEquals( "Checking size to an empty BST - expected 0", expectedResult, result );
    }
    
    /**
     * Check if the contains works
     */
    @Test
    public void testContains()
    {
        BST<Integer,Integer> testBST = new BST<Integer,Integer>();
        Boolean expectedResult = null;
        testBST.put(0, 1);
        testBST.put(1, 5);
        testBST.put(2, 6);
        testBST.put(3, 2);
        testBST.put(4, 7);
        
     // test non-empty list
        expectedResult = true;
        assertEquals( "Checking contains to a BST containing 5 elements - expected true", expectedResult, testBST.contains(1));
        
        expectedResult = true;
        assertEquals( "Checking contains to a BST containing 5 elements - expected true", expectedResult, testBST.contains(3));
        
        expectedResult = true;
        assertEquals( "Checking contains to a BST containing 5 elements - expected true", expectedResult, testBST.contains(4));
        
        expectedResult = false;
        assertEquals( "Checking contains to a BST containing 5 elements - expected false", expectedResult, testBST.contains(15));
        
     // test empty list
        testBST = new BST<Integer,Integer>();
        expectedResult = false;
        assertEquals( "Checking isEmpty to an empty BST - expected false", expectedResult, testBST.contains(5) );
    }
    
    /**
     * Check if the get works
     */
    @Test
    public void testGet()
    {
        BST<Integer,Integer> testBST = new BST<Integer,Integer>();
        Integer expectedResult = null;
        Integer result = null;
        testBST.put(7, 7);
        testBST.put(8, 8);
        testBST.put(3, 3);
        testBST.put(1, 1);
        testBST.put(2, 2); 
        testBST.put(6, 6);
        testBST.put(4, 4);
        testBST.put(5, 5);
        
        // test non-empty list
        expectedResult = null;
        result = testBST.get(0);
        assertEquals( "Checking get to a BST containing 5 elements - expected null", expectedResult, result);
        
        expectedResult = 1;
        result = testBST.get(1);
        assertEquals( "Checking get to a BST containing 5 elements - expected 1", expectedResult, result);
        
        expectedResult = 2;
        result = testBST.get(2);
        assertEquals( "Checking get to a BST containing 5 elements - expected 2", expectedResult, result);
        
        expectedResult = 4;
        result = testBST.get(4);
        assertEquals( "Checking get to a BST containing 5 elements - expected 4", expectedResult, result);
        
        expectedResult = null;
        result = testBST.get(19);
        assertEquals( "Checking get to a BST containing 5 elements - expected null", expectedResult, result);
        
     // test empty list
        testBST = new BST<Integer,Integer>();
        expectedResult = null;
        assertEquals( "Checking get to an empty BST - expected null", expectedResult, testBST.get(5) );
    }
    
    /**
     * Check if the put works
     */
    @Test
    public void testPut()
    {
        BST<Integer,Integer> testBST = new BST<Integer,Integer>();
        Integer expectedResult = null;
        Integer result = null;
        
        // test non-empty list
        testBST.put(7, 7);
        expectedResult = 1;
        result = testBST.size();
        assertEquals( "Checking put to a BST containing 0 elements - expected 1", expectedResult, result);
        
        testBST.put(8, 8);
        testBST.put(3, 3);
        testBST.put(1, 1);
        testBST.put(2, 2); 
        testBST.put(6, 6);
        testBST.put(4, 4);
        testBST.put(5, 5);
        testBST.put(0, 1);
        testBST.put(7, 1);
        expectedResult = 9;
        result = testBST.size();
        assertEquals( "Checking put to a BST containing 1 elements - expected 9", expectedResult, result);
        expectedResult = null;
        result = testBST.get(77);
        assertEquals( "Checking put to a BST, if values are in order - expected null", expectedResult, result);
        expectedResult = 3;
        result = testBST.get(3);
        assertEquals( "Checking put to a BST, if values are in order - expected 3", expectedResult, result);
        expectedResult = 5;
        result = testBST.get(5);
        assertEquals( "Checking put to a BST, if values are in order - expected 5", expectedResult, result);
        
        
     // test empty list
        testBST = new BST<Integer,Integer>();
        testBST.put(1, null);
        expectedResult = null;
        assertEquals( "Checking put to an empty BST - expected null", expectedResult, testBST.get(5) );
    }
    
    /**
     * Check if the height works
     */
    @Test
    public void testHeight()
    {
        BST<Integer,Integer> testBST = new BST<Integer,Integer>();
        Integer expectedResult = null;
        Integer result = null;
        
        // test non-empty list
        testBST.put(7, 7);
        expectedResult = 0;
        result = testBST.height();
        assertEquals( "Checking height to a BST containing 1 elements - expected 0", expectedResult, result);
        
        testBST.put(8, 8);
        testBST.put(3, 3);
        expectedResult = 1;
        result = testBST.height();
        assertEquals( "Checking height to a BST in triangle - expected 1", expectedResult, result);
        testBST.put(1, 1);
        expectedResult = 2;
        result = testBST.height();
        assertEquals( "Checking height to a BST, if values are in not perfect triangle - expected 2", expectedResult, result);
        testBST.put(2, 2); 
        testBST.put(6, 6);
        testBST.put(4, 4);
        testBST.put(5, 5);
        expectedResult = 4;
        result = testBST.height();
        assertEquals( "Checking height to a BST, if values are in not perfect triangle - expected 4", expectedResult, result);
        
        
     // test empty list
        testBST = new BST<Integer,Integer>();
        expectedResult = -1;
        result = testBST.height();
        assertEquals( "Checking height to an empty BST - expected -1", expectedResult, result );
    }
    
    /**
     * Check if the median works with select
     */
    @Test
    public void testMedian()
    {
        BST<Integer,Integer> testBST = new BST<Integer,Integer>();
        Integer expectedResult = null;
        Integer result = null;
        
        // test non-empty list
        testBST.put(7, 7);
        expectedResult = 7;
        result = testBST.median();
        assertEquals( "Checking median to a BST containing 1 elements - expected 7", expectedResult, result);
        
        testBST.put(8, 8);
        testBST.put(3, 3);
        expectedResult = 7;
        result = testBST.median();
        assertEquals( "Checking median to a BST - expected 7", expectedResult, result);
        expectedResult = 3;
        testBST.put(1, 1);
        result = testBST.median();
        assertEquals( "Checking median to a BST - expected 3", expectedResult, result);
        expectedResult = 4;
        testBST.put(2, 2); 
        testBST.put(6, 6);
        testBST.put(4, 4);
        testBST.put(5, 5);
        result = testBST.median();
        assertEquals( "Checking median to a BST - expected 4", expectedResult, result);
        
        
     // test empty list
        testBST = new BST<Integer,Integer>();
        expectedResult = null;
        result = testBST.median();
        assertEquals( "Checking median to an empty BST - expected null", expectedResult, result );
    }
    
    /**
     * Check if the printKeysInOrder works
     */
    
    @Test
    public void testPrintKeysInOrder() {
        BST<Integer, Integer> bst = new BST<Integer, Integer>();
        assertEquals("Checking order printing of empty tree",
                "()", bst.printKeysInOrder());
         
                             //  -7
                             //   |-3
                             //   | |-1
                             //   | | |-null
        bst.put(7, 7);       //   | |  -2
        bst.put(8, 8);       //   | |   |-null
        bst.put(3, 3);       //   | |    -null
        bst.put(1, 1);       //   |  -6
        bst.put(2, 2);       //   |   |-4
        bst.put(6, 6);       //   |   | |-null
        bst.put(4, 4);       //   |   |  -5
        bst.put(5, 5);       //   |   |   |-null
                             //   |   |    -null
                             //   |    -null
                             //    -8
                             //     |-null
                             //      -null
        
        String result = 
        		"(((()1(()2()))3((()4(()5()))6()))7(()8()))";
        assertEquals("Checking order printing of non-empty tree", result, bst.printKeysInOrder());
        }
        
  // GIVEN
  /** <p>Test {@link BST#prettyPrintKeys()}.</p> */
      
 @Test
 public void testPrettyPrint() {
     BST<Integer, Integer> bst = new BST<Integer, Integer>();
     assertEquals("Checking pretty printing of empty tree", "-null\n", bst.prettyPrintKeys());
      
                          //  -7
                          //   |-3
                          //   | |-1
                          //   | | |-null
     bst.put(7, 7);       //   | |  -2
     bst.put(8, 8);       //   | |   |-null
     bst.put(3, 3);       //   | |    -null
     bst.put(1, 1);       //   |  -6
     bst.put(2, 2);       //   |   |-4
     bst.put(6, 6);       //   |   | |-null
     bst.put(4, 4);       //   |   |  -5
     bst.put(5, 5);       //   |   |   |-null
                          //   |   |    -null
                          //   |    -null
                          //    -8
                          //     |-null
                          //      -null
     
     String result = 
      "-7\n" +
      " |-3\n" + 
      " | |-1\n" +
      " | | |-null\n" + 
      " | |  -2\n" +
      " | |   |-null\n" +
      " | |    -null\n" +
      " |  -6\n" +
      " |   |-4\n" +
      " |   | |-null\n" +
      " |   |  -5\n" +
      " |   |   |-null\n" +
      " |   |    -null\n" +
      " |    -null\n" +
      "  -8\n" +
      "   |-null\n" +
      "    -null\n";
     assertEquals("Checking pretty printing of non-empty tree", result, bst.prettyPrintKeys());
     }

  
     /** <p>Test {@link BST#delete(Comparable)}.</p> */
     @Test
     public void testDelete() {
         BST<Integer, Integer> bst = new BST<Integer, Integer>();
         bst.delete(1);
         assertEquals("Deleting from empty tree", "()", bst.printKeysInOrder());
         
         bst.put(7, 7);   //        _7_
         bst.put(8, 8);   //      /     \
         bst.put(3, 3);   //    _3_      8
         bst.put(1, 1);   //  /     \
         bst.put(2, 2);   // 1       6
         bst.put(6, 6);   //  \     /
         bst.put(4, 4);   //   2   4
         bst.put(5, 5);   //        \
                          //         5
         
         assertEquals("Checking order of constructed tree",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
         
         bst.delete(9);
         assertEquals("Deleting non-existent key",
                 "(((()1(()2()))3((()4(()5()))6()))7(()8()))", bst.printKeysInOrder());
 
         bst.delete(8);
         assertEquals("Deleting leaf", "(((()1(()2()))3((()4(()5()))6()))7())", bst.printKeysInOrder());
 
         bst.delete(6);
         assertEquals("Deleting node with single child",
                 "(((()1(()2()))3(()4(()5())))7())", bst.printKeysInOrder());
 
         bst.delete(3);
         assertEquals("Deleting node with two children",
                 "(((()1())2(()4(()5())))7())", bst.printKeysInOrder());
         
         bst = new BST<Integer, Integer>();
         bst.put(7, 7);
         bst.delete(7);
         assertEquals("Deleting node of BST with one node",
                 "()", bst.printKeysInOrder());
     }
     
}
