package TrafficCrashAnalysisChicago;

/**
 * LinkedListNode - Class representing node of a Linked List
 * @author nsrao
 */
public class LinkedListNode {
	
	/**
	 * data field of node
	 */
	TrafficAccident data;
	
	/**
	 * pointer to next node
	 */
	LinkedListNode next;

	/**
	 * Parameterized constructor having TrafficAccident data
	 * @param data traffic accident data
	 */
	LinkedListNode(TrafficAccident data)
	{
		this.data = data;
		this.next = null;
	}
	
	/**
	 * Default constructor
	 */
	LinkedListNode()
	{
		this.data = null;
		this.next = null;
	}
	
}
