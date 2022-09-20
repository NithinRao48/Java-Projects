package TrafficCrashAnalysisHeap;

/**
 * Node.java - Class representing each node in the heap data structure.
 * @author nsrao
 *
 */
public class Node {

	/**
	 * accident entry
	 */
	TrafficAccident data;
	
	/**
	 * Count of accident
	 */
	int acc_count;
	
	/**
	 * accident day
	 */
	String day;
	
	/**
	 * victim ageGroup
	 */
	String ageGroup;
	
	/**
	 * Parameterised constructor with traffic accident data
	 * @param t traffic accident entry
	 */
	public Node(TrafficAccident t)
	{
		data = t;
		acc_count=1;
		day = null;
	}
	
	/**
	 * Parameterised constructor with traffic accident data and day accident occurred
	 * @param t traffic accident entry
	 * @param d day the accident occurred
	 */
	public Node(TrafficAccident t,String d)
	{
		data = t;
		acc_count=1;
		day = d;
	}
	
	/**
	 * Parameterised constructor with victim age group
	 * @param age victim age group
	 */
	public Node (String age)
	{
		data = null;
		acc_count=1;
		ageGroup = age;
	}

	/**
	 * Default constructor
	 */
	public Node() {
		data = null;
		acc_count=0;
		ageGroup = null;
	}
}
