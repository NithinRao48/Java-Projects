package TrafficCrashAnalysisHeap;


/**
 * MaxHeapArray.java - Implement Max heap using arrays
 * @author nsrao
 */
public class MaxHeapArray {
	/**
	 * Parameter to define the size of the array
	 */
	private static final int MAX_SIZE = 400000;
	
	/**
	 * creating nodes for the heap data structure of type Node
	 */
    private Node [] heap;
    
    /**
     * size of the heap data structure
     */
    private int size;
    
    
    /**
     * Constructor to create heap using arrays
     */
    public MaxHeapArray()
    {
    	heap = new Node[MAX_SIZE];
        size = 0;
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
     * return the index of the left child 
     * @param i index
     * @return index of the left child
     */
    public static int leftChild(int i) {
        return 2*i + 1;
    }
    
    /**
     * return the index of the right child 
     * @param i index
     * @return index of the left child
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
    	int flag=0;
        if (size >= MAX_SIZE) {
            System.out.println("The heap is full. Cannot insert");
            return;
        }

        
        
        //Handle duplicates by aggregating based on city
        for (int k=0;k<size;k++)
        {
     	   if (heap[k].data.getCity().equals(data.getCity())){
     		   heap[k].acc_count++;
     		   i=k;
     		   flag=1;
     		   break;
     	   }
        }
        
        if (flag==0) {
        	heap[size] = new Node(data);
        	//Increment Size
            size = size + 1;
            i = size - 1;
        }
      	
        // move up until the heap property satisfies
        while (i != 0 && heap[MaxHeapArray.parent(i)].acc_count < heap[i].acc_count)
        {
            Node temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = MaxHeapArray.parent(i);
        }
    }
    
    /**
     * Inserts the data related to accident into the heap data structure with the day
     * @param data Each record about the accident
     * @param day date of each accident is transformed to day of week
     */
    public void insertByDay(TrafficAccident data,String day) {
    	int flag =0;
    	int i=0;
        if (size >= MAX_SIZE) {
            System.out.println("The heap is full. Cannot insert");
            return;
        }
        //Handle duplicates
        for (int k=0;k<size;k++)
        {
     	   if (heap[k].day.equals(day)){
     		   heap[k].acc_count++;
     		   i=k;
     		   flag =1;
     		   break;
     	   }
        }
        if (flag==0) {
        	heap[size] = new Node(data,day);
            //Increment Size
            size = size + 1;
            i = size - 1;
        }
        
        // move up until the heap property satisfies
        while (i !=0 && heap[MaxHeapArray.parent(i)].acc_count < heap[i].acc_count)
        {
            Node temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = MaxHeapArray.parent(i);
        }   
    }
    
    /**
     * Inserts the data related to accident into the heap data structure with only age of the victim
     * @param age Each record about the accident victim
     */
    public void insertByAge(String age) {
    	int flag =0;
    	int i=0;
        if (size >= MAX_SIZE) {
            System.out.println("The heap is full. Cannot insert");
            return;
        }

        //Handle duplicates
        for (int k=0;k<size;k++)
        {
     	   if (heap[k].ageGroup.equals(age)){
     		   heap[k].acc_count++;
     		   i=k;
     		   flag =1;
     		   break;
     	   }
        }
        if (flag==0) {
        	heap[size] = new Node(age);
            //Increment Size
            size = size + 1;
            i = size - 1;
        }
        
        // move up until the heap property satisfies
        while (i !=0 && heap[MaxHeapArray.parent(i)].acc_count < heap[i].acc_count)
        {
            Node temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = MaxHeapArray.parent(i);
        }   
    }
    
    /**
     * moves the item at position i of array a into its right position
     * @param i node that needs to put in right position
     */
    public void maxHeapify(int i){
    	
        // get left child node
        int left = MaxHeapArray.leftChild(i);

        // get right child node
        int right = MaxHeapArray.rightChild(i);

        // find the largest 
        int largest = i;

        // check if the current node is less than left node
        if (left <= size && heap[left].acc_count > heap[largest].acc_count) {
            largest = left;
        }

        // check if the current node and left node is less than left node
        if (right <= size && heap[right].acc_count > heap[largest].acc_count) {
            largest = right;
        }
        
        // Swap the nodes and Heapify
        if (largest != i) {
            Node temp = heap[i];
            heap[i] = heap[largest];
            heap[largest] = temp;
            maxHeapify(largest);
        }
    }
    
    /**
     * deletes the max item and return
     * @return the largest node
     */
    public Node extractMax() {
    	
        Node temp = heap[0];
        // replace the first node with last
        heap[0] = heap[size - 1];
        size = size - 1;

        // maintain the heap property by heapifying 
        maxHeapify(0);
		return temp;
    }

}
