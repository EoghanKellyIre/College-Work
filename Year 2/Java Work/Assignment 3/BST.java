/*************************************************************************
 *  Binary Search Tree class.
 *  Adapted from Sedgewick and Wayne.
 *
 *  @version 3.0 1/11/15 16:49:42
 *
 *  @author Eogh�n Kelly
 *
 *************************************************************************/
public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST

    /**
     * Private node class.
     */
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        private int N;             // number of nodes in subtree

        public Node(Key key, Value val, int N) {
            this.key = key;
            this.val = val;
            this.N = N;
        }
    }

    // is the symbol table empty?
    public boolean isEmpty() { return size() == 0; }

    // return number of key-value pairs in BST
    public int size() { return size(root); }

    // return number of key-value pairs in BST rooted at x
    private int size(Node x) {
        if (x == null) return 0;
        else return x.N;
    }

	/**
     *  Search BST for given key.
     *  Does there exist a key-value pair with given key?
     *
     *  @param key the search key
     *  @return true if key is found and false otherwise
     */
    public boolean contains(Key key) {
        return get(key) != null;
    }

    /**
     *  Search BST for given key.
     *  What is the value associated with given key?
     *
     *  @param key the search key
     *  @return value associated with the given key if found, or null if no such key exists.
     */
    public Value get(Key key) { return get(root, key); }

    private Value get(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) return get(x.left, key);
        else if (cmp > 0) return get(x.right, key);
        else              return x.val;
    }

    /**
     *  Insert key-value pair into BST.
     *  If key already exists, update with new value.
     *
     *  @param key the key to insert
     *  @param val the value associated with key
     */
    public void put(Key key, Value val) {
        if (val == null) { delete(key); return; }
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) return new Node(key, val, 1);
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(x.left,  key, val);
        else if (cmp > 0) x.right = put(x.right, key, val);
        else              x.val   = val;
        x.N = 1 + size(x.left) + size(x.right);
        return x;
    }

    /**
     * Tree height.
     *
     * Asymptotic worst-case running time using Theta notation:
     * 
     * In the height function, everything has a worst case running time of 1, since they are constant time operations, except for the other function call in line 122.
     * This function examines the height at the left and right nodes and through recursion all nodes in the tree. It has only constant time operations, that will repeat for
     * each node in the tree, therefore will have a worst case running time of Theta(n).
     *
     * @return the number of links from the root to the deepest leaf.
     *
     * Example 1: for an empty tree this should return -1.
     * Example 2: for a tree with only one node it should return 0.
     * Example 3: for the following tree it should return 2.
     *   B
     *  / \
     * A   C
     *      \
     *       D
     */
    public int height() 
    {
    	// Checks if tree is empty and returns required value of -1
    	if (root == null)
    	{
    		return -1;
    	}
    	else
    	{
    		// calls private recursive function
    		int height = height(root);
    		return height;
    	}
    }

    private int height(BST<Key, Value>.Node node) 
    {
    	if (node == null)
    	{
    		// returns -1 since we add one after to make 0
    		return -1;
    	}
    	else
    	{
    		// finds the height of the left and right node till it finds an empty node
    		int heightLeftNode = height(node.left);
    		int heightRightNode = height(node.right);
    		//returns greatest value of the height of the left and right node
    		return (heightLeftNode>heightRightNode) ? heightLeftNode+1 :  heightRightNode+1;
    	}
	}

	/**
     * Median key.
     * If the tree has N keys k1 < k2 < k3 < ... < kN, then their median key 
     * is the element at position (N+1)/2 (where "/" here is integer division)
     *
     * @return the median key, or null if the tree is empty.
     */
    public Key median()
    {
    	if (isEmpty())
    	{
    	  	return null;
    	}
    	// calls private function
    	return median(root);
    }

    private Key median(BST<Key, Value>.Node node)
    {
    	// Uses the select function to find the median node
    	Key median = select((size()-1)/2);
		return median;
	}

	public Key select(int n)
	{
		// calls private recursive function
    	Node x = select(root, n);
    	return x.key;
    }
    	
	private Node select(Node x, int n)
	{
		//sorts through tree until it finds the node by comparing the values then following that side of tree
    	int t = size(x.left);
    	if (t > n)
    		{
    			return select(x.left, n);
    		}
    	else if (t < n)
    		{
    		return select(x.right, n-t-1);
    		}
    	else return x;
    }

    /**
     * Print all keys of the tree in a sequence, in-order.
     * That is, for each node, the keys in the left subtree should appear before the key in the node.
     * Also, for each node, the keys in the right subtree should appear before the key in the node.
     * For each subtree, its keys should appear within a parenthesis.
     *
     * Example 1: Empty tree -- output: "()"
     * Example 2: Tree containing only "A" -- output: "(()A())"
     * Example 3: Tree:
     *   B
     *  / \
     * A   C
     *      \
     *       D
     *
     * output: "((()A())B(()C(()D())))"
     *
     * output of example in the assignment: (((()A(()C()))E((()H(()M()))R()))S(()X()))
     *
     * @return a String with all keys in the tree, in order, parenthesized.
     */
    public String printKeysInOrder()
    {
    	// returns required value if given empty tree
    	if (isEmpty()) return "()";
    	// calls private function
    	return printKeysInOrder(root);
    }
    
    private String printKeysInOrder(BST<Key, Value>.Node node)
    {
    	// returns required value if given empty node
    	if (node == null)
    	{
    		return "()";
    	}
    	else
    	{
    		// Uses recursion to print the nodes to the left, then the node and then the node to the right.
    		StringBuilder s = new StringBuilder();
    		s.append("(");
    		s.append(printKeysInOrder(node.left));
    		s.append(node.key);
    		s.append(printKeysInOrder(node.right));
    		s.append(")");		
			return s.toString();
    	}
	}

	/**
     * Pretty Printing the tree. Each node is on one line -- see assignment for details.
     *
     * @return a multi-line string with the pretty ascii picture of the tree.
     */
    public String prettyPrintKeys() {
    	// returns required value if given empty tree
        if (isEmpty()) return "-null\n";
        StringBuilder s = new StringBuilder();
        // calls private recursive function with an empty prefix for the start
        return prettyPrintKeys(root, s);
    }

    private String prettyPrintKeys(BST<Key, Value>.Node node, StringBuilder argumentPrefix)
    {
    	if (node==null)
    	{
    		// if the node is empty add the current prefix and return "-null\n"
    		StringBuilder s = new StringBuilder();
    		s.append(argumentPrefix);
    		s.append("-null\n");
    		return s.toString();
    	}
    	else
    	{
    		// Using recursion, print the current prefix and current node
    		StringBuilder s = new StringBuilder();
    		s.append(argumentPrefix);
    		s.append("-"+node.key+"\n");
    		// Amends the current prefix with " |" for the left side and calls to print the left node
    		StringBuilder leftPrefix = new StringBuilder();
    		leftPrefix.append(argumentPrefix + " |");
    		s.append(prettyPrintKeys(node.left, leftPrefix));
    		// Amends the current prefix with "  " for the right side and calls to print the right node
    		StringBuilder rightPrefix = new StringBuilder();
    		rightPrefix.append(argumentPrefix + "  ");
    		s.append(prettyPrintKeys(node.right, rightPrefix));
			return s.toString();
    	}
	}

	/**
     * Deletes a key from a tree (if the key is in the tree).
     * Note that this method works symmetrically from the Hibbard deletion:
     * If the node to be deleted has two child nodes, then it needs to be
     * replaced with its predecessor (not its successor) node.
     *
     * @param key the key to delete
     */
    public void delete(Key key)
    {
    	// returns if given empty tree
    	if (isEmpty())
    	{
    		return;
    	}
    	// deletes tree if size of the tree is one and key is the same as root
    	else if(this.size()==1 & key==root.key)
    	{
    		root = null;
    	}
    	// calls private recursive function
    	else 
    	{
    		delete(root, key);
    	}
    }

	private BST<Key, Value>.Node delete(BST<Key, Value>.Node node, Key key)
	{
		// returns if the node is empty
		if (node == null)
		{
			return null;
		}
		// Compares the key with the current node to find out which side of the tree to follow
		int compareNode = key.compareTo(node.key);
		if (compareNode < 0)
		{
			node.left = delete(node.left, key);
		}
		else if (compareNode > 0)
		{	
			node.right = delete(node.right, key);
		}
		// returns if the node is null
		else
		{ 
			if (node.left == null)
			{
				return node.right;
			}
			if (node.right == null)
			{
				return node.left;
			}
			// when found the node it deletes the node by updating the links between the nodes and using the floor and deleteMax functions
			Node t = node;
			node = floor(t.left, key);
			node.left = deleteMax(t.left);
			node.right = t.right;
		}
		node.N = size(node.left) + size(node.right) + 1;
		return node;
	}
	 
	private Node deleteMax(Node x)
	{
		if (x.right == null)
		{
			return x.left;
		}
		x.right = deleteMax(x.right);
		x.N = 1 + size(x.left) + size(x.right);
		return x;
	}
	
	private Node floor(Node x, Key key)
	{
		if (x == null)
		{
			return null;
		}
		Node t = floor(x.right, key);
		if (t != null)
		{
			return t;
		}
		else 
		{
			return x;
		}
	}
}