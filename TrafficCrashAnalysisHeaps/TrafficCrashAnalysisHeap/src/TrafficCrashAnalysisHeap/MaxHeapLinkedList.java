package TrafficCrashAnalysisHeap;

import java.util.LinkedList;

/**
 * MaxHeapLinkedList.java - Implementing Max Heap using Linked List
 * @author nsrao
 */

public class MaxHeapLinkedList{
	/**
	 * Creating a Linked List of type Node to represent Heap using LL
	 */
    private LinkedList<Node> heapLL;
    
    /**
     * Constructor
     */
    public MaxHeapLinkedList()
    {
    	heapLL = new LinkedList<Node>();
    }
    
    /**
     * Function to return the index of the parent
     * @param i index
     * @return index of the parent
     */
    public static int parent(int i) {
        return (i - 1) / 2;
    }
    
    /**
     * Function to return the index of the left child 
     * @param i index
     * @return index of the left child
     */
    public static int leftChild(int i) {
        return 2*i + 1;
    }
    
    /**
     * Function return the index of the right child 
     * @param i index
     * @return index of the right child
     */
    public static int rightChild(int i) {
        return 2*i + 2;
    }
    
    /**
     * Inserts the data related to accident into the heap data structure with city
     * @param data Each record about the accident
     */
    public void insertByCity(TrafficAccident data) {
    	int i=0;
    	var wrapper = new Object(){ Node n; };
        //Handle duplicates
    	heapLL.forEach(ele ->{
    		if(ele.data.getCity().equals(data.getCity())){
    			ele.acc_count++;
    			wrapper.n = ele;
    		}
    		
    	});
    	int k = heapLL.indexOf(wrapper.n);
    	
        if (!heapLL.contains(wrapper.n)) {
        	heapLL.add(new Node(data));
        	i = heapLL.size() - 1;
        }
        else {
        	i=k;
        }
      	
        // move up until the heap property satisfies
        while (i != 0&& i<heapLL.size() && heapLL.get(parent(i)).acc_count < heapLL.get(i).acc_count)
        {
            Node temp = heapLL.get(i);
            heapLL.set(i,heapLL.get(parent(i)));
            heapLL.set(parent(i),temp);
            i = parent(i);
        }
    }
    
    /**
     * Inserts the data related to accident into the heap data structure with the day
     * @param data Each record about the accident
     * @param day date of each accident is transformed to day of week
     */
    public void insertByDay(TrafficAccident data,String day) {
    	int i=0;
       
        //Handle duplicates
    	var wrapper = new Object(){ Node n; };
        //Handle duplicates
    	heapLL.forEach(ele ->{
    		if(ele.day.equals(day)){
    			ele.acc_count++;
    			wrapper.n = ele;
    		}
    		
    	});
    	int k = heapLL.indexOf(wrapper.n);
    	
        if (!heapLL.contains(wrapper.n)) {
        	heapLL.add(new Node(data,day));
        	i = heapLL.size() - 1;
        }
        else {
        	i=k;
        }
        
        // move up until the heap property satisfies
        while (i !=0 && i< heapLL.size() && heapLL.get(parent(i)).acc_count < heapLL.get(i).acc_count)
        {
        	Node temp = heapLL.get(i);
            heapLL.set(i,heapLL.get(parent(i)));
            heapLL.set(parent(i),temp);
            i = parent(i);
        }   
    }
    
    /**
     * Inserts the data related to accident into the heap data structure with only age of the victim
     * @param age Each record about the accident victim
     */
    public void insertByAge(String age) {
    	int i=0;
    	var wrapper = new Object(){ Node n; };
        //Handle duplicates
    	heapLL.forEach(ele ->{
    		if(ele.ageGroup.equals(age)){
    			ele.acc_count++;
    			wrapper.n = ele;
    		}
    		
    	});
    	int k = heapLL.indexOf(wrapper.n);
    	
        if (!heapLL.contains(wrapper.n)) {
        	heapLL.add(new Node(age));
        	i = heapLL.size() - 1;
        }
        else {
        	i=k;
        }
        // move up until the heap property satisfies
        while (i !=0 && heapLL.get(parent(i)).acc_count < heapLL.get(i).acc_count)
        {
        	Node temp = heapLL.get(i);
            heapLL.set(i,heapLL.get(parent(i)));
            heapLL.set(parent(i),temp);
            i = parent(i);
        }   
    }
    
    /**
     * moves the item at position i of array a into its right position
     * @param i node that needs to put in right position
     */
    public void maxHeapify(int i){
        // get left child node
        int left = leftChild(i);

        // get right child node
        int right = rightChild(i);

        // get the largest
        int largest = i;

        // check if the current node is less than left node
        if (left < heapLL.size() && heapLL.get(left).acc_count > heapLL.get(largest).acc_count) {
            largest = left;
        }

        // check if the current node and left node is less than left node
        if (right < heapLL.size() && heapLL.get(right).acc_count > heapLL.get(largest).acc_count) {
            largest = right;
        }
        
     // Swap the nodes and Heapify 
        if (largest != i) {
        	Node temp = heapLL.get(i);
            heapLL.set(i,heapLL.get(largest));
            heapLL.set(largest,temp);
            maxHeapify(largest);
        }
    }
    
    
    /**
     * deletes the max item and return
     * @return the largest node
     */
    public Node extractMax() {
        Node temp = heapLL.get(0);
        
        //replace the first node with last
        heapLL.set(0, heapLL.get(heapLL.size() - 1));
        heapLL.removeLast();

        // maintain the heap property by heapifying
        maxHeapify(0);
		return temp;
    }

}
