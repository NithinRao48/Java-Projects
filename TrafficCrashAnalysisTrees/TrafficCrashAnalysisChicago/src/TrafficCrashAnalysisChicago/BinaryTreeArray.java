package TrafficCrashAnalysisChicago;

/**
 * BinaryTreeArray.java - Binary tree constructed using an array
 * @author nsrao
 *
 */
public class BinaryTreeArray {
	/**
	 * root node of the tree
	 */
	Node root;
	
	/**
	 * Underlying array for a tree
	 */
	public static TrafficAccident [] taArray;
	
    private static final int SIZE = 400000;
    private static int arraySize = 0;
  
    /**
     * Default Constructor
     */
    public BinaryTreeArray() {
        taArray = new TrafficAccident[SIZE];
    }
    
    /**
     * Insert a TrafficAccident Data into an array
     * @param data Traffic accident data
     */
    public void add(TrafficAccident data) {
    	taArray[arraySize ++]= data;
    }
    

    /**
     * Function to insert nodes in level order
     * @param root root node of the tree
     * @param i	position to be inserted
     * @return root of the tree based on insertion in that position
     */
    public Node insert(Node root, int i)
    {
        if (i < arraySize)
        {
            Node temp = new Node(taArray[i]);
            root = temp;
 
            // insert left child
            root.left = insert(root.left,2 * i + 1);
 
            // insert right child
            root.right = insert(root.right,2 * i + 2);
        }	
        return root;
    }
    
    /**
	 * Function to print inorder traversal of the tree.
	 * @param root root node of the tree
	 */
	static void InOrder(Node root)
	{
		if (root != null) {
			preOrder(root.left);
			root.data.printInfo();
			preOrder(root.right);
		}
	}
	
	/**
	 * Function to print preorder traversal of the tree.
	 * @param root root node of the tree
	 */
	static void preOrder(Node root)
	{
		if (root != null) {
			root.data.printInfo();
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	
	/**
	 * Function to print postorder traversal of the tree.
	 * @param root root node of the tree
	 */
	static void postOrder(Node root)
	{
		if (root != null) {
			preOrder(root.left);
			preOrder(root.right);
			root.data.printInfo();
		}
	}
}
