import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

// -------------------------------------------------------------------------
/**
 *  This class contains the methods of Doubly Linked List.
 *
 *  @author  Eoghán Kelly
 *  @version 09/10/18 11:13:22
 */


/**
 * Class DoublyLinkedList: implements a *generic* Doubly Linked List.
 * @param <T> This is a type parameter. T is used as a class name in the
 * definition of this class.
 *
 * When creating a new DoublyLinkedList, T should be instantiated with an
 * actual class name that extends the class Comparable.
 * Such classes include String and Integer.
 *
 * For example to create a new DoublyLinkedList class containing String data: 
 *    DoublyLinkedList<String> myStringList = new DoublyLinkedList<String>();
 *
 * The class offers a toString() method which returns a comma-separated sting of
 * all elements in the data structure.
 * 
 * This is a bare minimum class you would need to completely implement.
 * You can add additional methods to support your code. Each method will need
 * to be tested by your jUnit tests -- for simplicity in jUnit testing
 * introduce only public methods.
 */
class DoublyLinkedList<T extends Comparable<T>>
{

    /**
     * private class DLLNode: implements a *generic* Doubly Linked List node.
     */
    private class DLLNode
    {
        public final T data; // this field should never be updated. It gets its
                             // value once from the constructor DLLNode.
        public DLLNode next;
        public DLLNode prev;
    
        /**
         * Constructor
         * @param theData : data of type T, to be stored in the node
         * @param prevNode : the previous Node in the Doubly Linked List
         * @param nextNode : the next Node in the Doubly Linked List
         * @return DLLNode
         */
        public DLLNode(T theData, DLLNode prevNode, DLLNode nextNode) 
        {
          data = theData;
          prev = prevNode;
          next = nextNode;
        }
    }

    // Fields head and tail point to the first and last nodes of the list.
    private DLLNode head, tail;
    private int lenght;
    /**
     * Constructor of an empty DLL
     * @return DoublyLinkedList
     */
    
    public DoublyLinkedList() 
    {
      head = null;
      tail = null;
    }

    /**
     * Tests if the doubly linked list is empty
     * @return true if list is empty, and false otherwise
     *
     * Worst-case asymptotic running time cost: theta(1)
     *
     * Justification:
     *  It can only run two constant time operations with the worst case running time of theta(1).
     */
    public boolean isEmpty()
    {
    	//Checking if there is no head, therefore the DLL is empty, no need to check tail.
    	if(this.head==null)
    	{
    		return true;
    	}
    	return false;
    }

    /**
     * Inserts an element in the doubly linked list
     * @param pos : The integer location at which the new data should be
     *      inserted in the list. We assume that the first position in the list
     *      is 0 (zero). If pos is less than 0 then add to the head of the list.
     *      If pos is greater or equal to the size of the list then add the
     *      element at the end of the list.
     * @param data : The new data of class T that needs to be added to the list
     * @return none
     *
     * Worst-case asymptotic running time cost: theta(N)
     *
     * Justification:
     *  The worst case running time would be the if statement with the longest worst case running time, since everything else would be a constant time operation
     *  of theta(1). The first, second and third if statement has constant time operations of theta(1). The last else has 7 constant time operations and a for-loop.
     *  The worst case running time for the for loop would be theta(N), since it would have to cycle to the last position. Therefore insertBefore would have a
     *  total worst case running time of theta(N).
     */
    public void insertBefore( int pos, T data ) 
    {
    	if (isEmpty())
    	{
    		//if the DLL is empty, add a node and make it the head and tail.
    		DLLNode newNode = new DLLNode(data, null, null);
    		this.head = newNode;
    		this.tail = newNode;
    	}
    	else if (pos<=0)
    	{
    		//if the inputed position is <0, make the new node the head
    		DLLNode newNode = new DLLNode(data, null, this.head);
    		this.head.prev = newNode;
    		this.head = newNode;
    	}
    	else if (pos>this.lenght-1)
    	{
    		//if the inputed position is more than the DLL, make the new node the tail
    		DLLNode newNode = new DLLNode(data, null, null);
    		newNode.prev = this.tail;
    		this.tail.next = newNode;
    		this.tail = newNode;
    	}
    	else
    	{
    		//here it cycles through the nodes from the head until it gets to the position
    		DLLNode currentNode = this.head;
    		DLLNode prevNode = null;
    		for (int i =1; i<=pos; i++)
    		{
    			currentNode = currentNode.next;
    			prevNode = currentNode.prev;
    		}
    		//then it makes a new node at that position and updates pointers of next and previous nodes
    		DLLNode newNode = new DLLNode(data, null, null);
    		newNode.next = currentNode;
    		newNode.prev = prevNode;
    		currentNode.prev = newNode;
    		prevNode.next = newNode;
    	}
    	//adds to the length of the DLL
    	this.lenght++;
    	return;
    }

    /**
     * Returns the data stored at a particular position
     * @param pos : the position
     * @return the data at pos, if pos is within the bounds of the list, and null otherwise.
     *
     * Worst-case asymptotic running time cost: theta(N)
     *
     * Justification:
     *  The worst case running time would be the if statement with the longest worst case running time, since everything else would be a constant time operation
     *  of theta(1). The first, second and third if statement has constant time operations of theta(1). The last else has a for-loop. The worst case running
     *  time for the for loop would be theta(N), since it would have to cycle to the last position. Therefore get would have a total worst case running time of theta(N).
     *
     */
    public T get(int pos) 
    {
    	DLLNode currentNode = head;
    	//checks if the DLL is empty or position asked is not in the DLL, then returns null.
    	if (isEmpty() || (pos<0) || (pos>this.lenght-1))
    	{
    		return null;
    	}
    	//checks if the position is 0 then returns the data of the head node
    	else if ((pos==0))
    	{
    		return this.head.data;
    	}
    	//checks if the position is at the end of the DLL then returns the data of the tail node
    	else if ((pos==this.lenght-1))
    	{
    		return this.tail.data;
    	}
    	else
    	{
    		//cycles from the head node to the position then returns the data of the node at that position
    		for (int i =1; i<=pos; i++)
    		{
    			currentNode = currentNode.next;
    		}
    	      return currentNode.data;
    	}
    }

    /**
     * Deletes the element of the list at position pos.
     * First element in the list has position 0. If pos points outside the
     * elements of the list then no modification happens to the list.
     * @param pos : the position to delete in the list.
     * @return true : on successful deletion, false : list has not been modified. 
     *
     * Worst-case asymptotic running time cost: theta(N)
     *
     * Justification:
     *  The worst case running time would be the if statement with the longest worst case running time, since everything else would be a constant time operation
     *  of theta(1). The first, second, third, fourth and fifth if statement has constant time operations of theta(1). The last else has a for-loop. The worst case running
     *  time for the for loop would be theta(N), since it would have to cycle to the last position. Therefore deleteAt would have a total worst case running time of theta(N).
     */
    public boolean deleteAt(int pos) 
    {
    	//checks if the DLL is empty or position asked is not in the DLL, then returns false
    	if (isEmpty() || (pos<0) || (pos>this.lenght-1))
    	{
    		return false;
    	}
    	//checks if the DLL has only one node
    	else if (this.lenght==1)
    	{
    		//sets the head and tail of DLL to null & minus 1 from the length of the DLL
    		this.head = null;
    		this.tail = null;
    		this.lenght--;
    		return true;
    	}
    	//checks if the position is at the head, then makes the next node the head & minus 1 from the length of the DLL
    	else if (pos==0)
    	{
    		this.head = this.head.next;
    		this.lenght--;
    		return true;
    	}
    	//checks if the length was 2 and makes the previous node the tail & minus 1 from the length of the DLL
    	else if (this.lenght==2)
    	{
    		this.tail = this.head;
    		this.head.next = null;
    		this.lenght--;
    		return true;
    	}
    	//checks if the node is the tail and makes the previous node the tail & minus 1 from the length of the DLL
    	else if (pos==this.lenght-1)
    	{
    		this.tail = this.tail.prev;
    		this.lenght--;
    		return true;
    	}
    	else
    	{
    		//cycles from the head node to the position then updates pointers of next and previous nodes & minus 1 from the length of the DLL
        	DLLNode currentNode = this.head;
    		for (int i =1; i<=pos; i++)
    		{
    			currentNode = currentNode.next;
    		}
        	currentNode.next.prev = currentNode.prev;
        	currentNode.prev.next = currentNode.next;
    		this.lenght--;
            return true;
    	}
    }

    /**
     * Reverses the list.
     * If the list contains "A", "B", "C", "D" before the method is called
     * Then it should contain "D", "C", "B", "A" after it returns.
     *
     * Worst-case asymptotic running time cost: theta(N)
     *
     * Justification:
     *  The first two lines and the last three lines are constant time operations with a worst case running time of theta(1). The while loop will run until it reaches the tail,
     *  therefore having a worst case running time of theta(N). Therefore reverse would have a total worst case running time of theta(N).
     */
    public void reverse()
    {
    	DLLNode currentNode = this.head;
    	DLLNode workingNode = null;
    	while(currentNode!=null)
    	{
    		//starting at the head makes the next node the previous node. This would repeat until the next node is null therefore it has reached the tail.
    		workingNode = currentNode.next;
    		currentNode.next = currentNode.prev;
    		currentNode.prev = workingNode;
    		currentNode = workingNode;
    	}
    	//updates the head and tail of the DLL to the reversed DLL
    	workingNode = this.head;
    	this.head = this.tail;
    	this.tail = workingNode;
    }

    /**
     * Removes all duplicate elements from the list.
     * The method should remove the _least_number_ of elements to make all elements uniqueue.
     * If the list contains "A", "B", "C", "B", "D", "A" before the method is called
     * Then it should contain "A", "B", "C", "D" after it returns.
     * The relative order of elements in the resulting list should be the same as the starting list.
     *
     * Worst-case asymptotic running time cost: O(N^2)
     *
     * Justification:
     *  The first if statement has a constant time operation of theta(1). In the else statement, the first two lines are constant time operations of theta(1). Then there is a while loop.
     *  The outer while loop will cycle through each node of the DLL, until it reaches the tail. Then inner while loop will start at the next node of the current node and cycle through
     *  until it reaches the tail. Therefore the first iteration would be (N-1), then (N-2),....then 1. The total number of comparisons will be the summation of this series, which is
     *  (N(N-1)/2) = O(N^2). Within the inner while loop, there are constant time operations. Therefore the worst case running time for makeUnique is O(N^2).
     */
     public void makeUnique()
    {
    	 //checks if the DLL is empty or has one node, therefore doesn't need to make unique and returns.
    	if (isEmpty() || this.lenght==1)
     	{
     		return;
     	}
     	else
     	{
         	DLLNode currentNode = this.head;
         	DLLNode compareNode = null;
         	//starts at the head node and compares with the next node. It cycles through the nodes until the tail. Then it moves to the second node cycles through the nodes until the tail.
         	//This continues until all elements are compared with eachother.
         	while(currentNode!=null)
     		{
         		compareNode = currentNode.next;
     			while(compareNode!=null)
     			{
     				if (currentNode.data==compareNode.data)
     				{
     					if (compareNode.next == null)
     					{
     						//If the data in the two nodes are the same and it is the tail, updates the pointer of the previous node to null and makes it the tail
     						compareNode.prev.next = null;
     						this.tail = compareNode.prev;
     					}
     					else
     					{
     						//If the data in the two nodes are the same and it is not the tail, it updates pointers of next and previous nodes
         					compareNode.next.prev = compareNode.prev;
         					compareNode.prev.next = compareNode.next;
     					}
     		    		this.lenght--;
     				}
     				compareNode = compareNode.next;
     			}
     			currentNode = currentNode.next;
     		}
     	}
    }


    /*----------------------- STACK API 
     * If only the push and pop methods are called the data structure should behave like a stack.
     */

    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to push on the stack
     *
     * Worst-case asymptotic running time cost: theta(1)
     *
     * Justification:
     * Each statement in this pop method has a constant time operation of theta(1). This is expected since it is a stack and should be LIFO, last in
     * first out.
     */
    public void push(T item) 
    {
    	//makes a new node and puts it at the head
    	DLLNode newNode = new DLLNode(item, null, this.head);
    	//if the DLL wasn't empty it updates the pointers to the next node
    	if (this.head != null)
    	{
    		this.head.prev = newNode;
    	}
    	//if the DLL had 1, it makes the old head the tail.
    	if(this.lenght==1)
    	{
    		this.tail = this.head;
    	}
    	//if the DLL was empty it makes the new node the tail
    	else if(this.lenght==0)
    	{
    		this.tail = newNode;
    	}
    	this.head = newNode;
    	this.lenght++;
    }

    /**
     * This method returns and removes the element that was most recently added by the push method.
     * @return the last item inserted with a push; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: theta(1)
     *
     * Justification:
     *  Each statement in this pop method has a constant time operation of theta(1). This is expected since it is a stack and should be LIFO,
     *  last in first out.
     */
    public T pop() 
    {
    	T data = null;
    	if(this.lenght!=0)
    	{
    		//if the DLL has one node it updates the tail and head to null and returns data of the removed node
    		if(this.lenght == 1)
    		{
    			data = this.head.data;
    			this.head = null;
    			this.tail = null;
    		}
    		//makes the head node the next node and updates its pointers.
    		else
    		{
    			DLLNode newNode = this.head.next;
    			data = this.head.data;
    			this.head = newNode;
    		}
    		this.lenght--;
    		return data;
    	}
    	// if the node is empty return null
    	return null;
    }

    /*----------------------- QUEUE API
     * If only the enqueue and dequeue methods are called the data structure should behave like a FIFO queue.
     */
 
    /**
     * This method adds an element to the data structure.
     * How exactly this will be represented in the Doubly Linked List is up to the programmer.
     * @param item : the item to be enqueued to the stack
     *
     * Worst-case asymptotic running time cost: theta(1)
     *
     * Justification:
     *  Each statement in this pop method has a constant time operation of theta(1). This is since we have the tail known and can just use it
     *  to facilitate the FIFO method of first in first out.
     */
    public void enqueue(T item) 
    {
    	//creates a new node at the end
    	DLLNode oldLast = this.tail;
    	this.tail = new DLLNode(item, oldLast, null);
    	//if the DLL was empty it makes this new node the head
    	if (this.lenght == 0)
    	{
    		this.head = this.tail;
    		this.lenght++;
    	}
    	//if the DLL was not empty it updates the pointers before the old tail and the new tail
    	else
    	{
    	    oldLast.next = this.tail;
    	    this.lenght++;
    	}
    }

     /**
     * This method returns and removes the element that was least recently added by the enqueue method.
     * @return the earliest item inserted with an equeue; or null when the list is empty.
     *
     * Worst-case asymptotic running time cost: theta(1)
     *
     * Justification:
     *  Each statement in this pop method has a constant time operation of theta(1). This is since we have the head known and can just use it
     *  to facilitate the FIFO method of first in first out.
     */
    public T dequeue() 
    {
    	T item;
    	//if the DLL was empty than it returns null
    	if(lenght==0)
    	{
    	    return null;
    	}
    	else
    	{
    		//it stores the data from the head node
    		item = this.head.data;
    		//makes the next node the head
    		this.head = this.head.next;
    		this.lenght--;
    		//makes the tail null if the DLL had only node node to begin with
    		if(this.lenght==0)
    		{
    			this.tail = null;
    		}
			return item;
    	}
    }
 

    /**
     * @return a string with the elements of the list as a comma-separated
     * list, from beginning to end
     *
     * Worst-case asymptotic running time cost:   Theta(n)
     *
     * Justification:
     *  We know from the Java documentation that StringBuilder's append() method runs in Theta(1) asymptotic time.
     *  We assume all other method calls here (e.g., the iterator methods above, and the toString method) will execute in Theta(1) time.
     *  Thus, every one iteration of the for-loop will have cost Theta(1).
     *  Suppose the doubly-linked list has 'n' elements.
     *  The for-loop will always iterate over all n elements of the list, and therefore the total cost of this method will be n*Theta(1) = Theta(n).
     */
    public String toString() 
    {
      StringBuilder s = new StringBuilder();
      boolean isFirst = true; 

      // iterate over the list, starting from the head
      for (DLLNode iter = head; iter != null; iter = iter.next)
      {
        if (!isFirst)
        {
          s.append(",");
        } else {
          isFirst = false;
        }
        s.append(iter.data.toString());
      }

      return s.toString();
    }


}


