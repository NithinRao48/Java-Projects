package TrafficCrashAnalysisHeap;

import java.util.LinkedList;

/**
 * MinHeapLinkedList.java - Implementing Min Heap using Linked List
 * @author nsrao
 */
public class MinHeapLinkedList {
	/**
	 * Creating a Linked List of type Node to represent Heap using LL
	 */
    private LinkedList<Node> heapLL;
    
    /**
     * Constructor
     */
    public MinHeapLinkedList()
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
        while (i != 0&& i<heapLL.size() && heapLL.get(parent(i)).acc_count > heapLL.get(i).acc_count)
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
        while (i !=0 && i< heapLL.size() && heapLL.get(parent(i)).acc_count > heapLL.get(i).acc_count)
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
        while (i !=0 && heapLL.get(parent(i)).acc_count > heapLL.get(i).acc_count)
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
    public void minHeapify(int i){
        // find left child node
        int left = leftChild(i);

        // find right child node
        int right = rightChild(i);

        // find the largest among 3 nodes
        int smallest = i;

        // check if the left node is larger than the current node
        if (left < heapLL.size() && heapLL.get(left).acc_count < heapLL.get(smallest).acc_count) {
            smallest = left;
        }

        // check if the right node is larger than the current node and left node
        if (right < heapLL.size() && heapLL.get(right).acc_count < heapLL.get(smallest).acc_count) {
            smallest = right;
        }
     // Swap the nodes and Heapify 
        if (smallest != i) {
        	Node temp = heapLL.get(i);
            heapLL.set(i,heapLL.get(smallest));
            heapLL.set(smallest,temp);
            minHeapify(smallest);
        }
    }
    
    
    /**
    * deletes the min item and return
    * @return the smallest node
    */
    public Node extractMin() {
    	 Node temp = heapLL.get(0);
    	 
         // Maxeplace the first item with the last item
         heapLL.set(0, heapLL.get(heapLL.size() - 1));
         heapLL.removeLast();

         // maintain the heap property 
         minHeapify(0);
 		 return temp;
    }

}
