package TrafficCrashAnalysisChicago;

import java.util.ArrayList;

/**
 * Node.java  -  A class representing each nodes in a tree.
 * @author nsrao
 *
 */
public class Node {
	/**
	 * data field of a node
	 */
	TrafficAccident data;
	
	/**
	 * left,right pointers of node 
	 */
    Node left, right;
    
    /**
     * height of the node
     */
    int height;
    
    /**
     * count of node if duplicate exists.
     */
	int count;
	
	/**
	 * arraylist of duplicate entries.
	 */
	ArrayList<TrafficAccident> duplicateEntries = new ArrayList<TrafficAccident>();
 
	/**
	 * Default Constructor
	 */
	
	Node()
	{
		this.data = null;
        this.left = this.right = null;
        count=1;
	}
	
	/**
	 * Parameterized constructor with TrafficAccident Data
	 * @param data traffic accident data
	 */
    Node(TrafficAccident data)
    {
        this.data = data;
        this.left = this.right = null;
        count=1;
    }
    
}
