package TrafficCrashAnalysisHeap;

/**
 * MinHeapArray.java - Implement Min heap using arrays
 * @author nsrao
 */
public class MinHeapArray {
	
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
    public MinHeapArray()
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
        //Handle duplicates
        for (int k=0;k<size;k++)
        {
     	   if (heap[k].data.getCity().equals(data.getCity())){
     		   heap[k].acc_count++;
     		   i=k;
     		   flag=1;
     	   }
        }
        
        if (flag==0) {
        	heap[size] = new Node(data);
        	//Increment Size
            size = size + 1;
            i = size - 1;
        }
      	
        // move up until the heap property satisfies
        while (i > 0 && heap[MinHeapArray.parent(i)].acc_count > heap[i].acc_count)
        {
            Node temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = MinHeapArray.parent(i);
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
     	   }
        }
        if (flag==0) {
        	heap[size] = new Node(data,day);
            //Increment Size
            size = size + 1;
            i = size - 1;
        }
        
        // move up until the heap property satisfies
        while (i !=0 && heap[MinHeapArray.parent(i)].acc_count > heap[i].acc_count)
        {
            Node temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = MinHeapArray.parent(i);
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
     	   }
        }
        if (flag==0) {
        	heap[size] = new Node(age);
            //Increment Size
            size = size + 1;
            i = size - 1;
        }
        
        // move up until the heap property satisfies
        while (i !=0 && heap[MinHeapArray.parent(i)].acc_count > heap[i].acc_count)
        {
            Node temp = heap[i];
            heap[i] = heap[parent(i)];
            heap[parent(i)] = temp;
            i = MinHeapArray.parent(i);
        }   
    }
    
    /**
     * moves the item at position i of array a into its right position
     * @param i node that needs to put in right position
     */
    public void minHeapify(int i){
        // find left child node
        int left = MinHeapArray.leftChild(i);

        // find right child node
        int right = MinHeapArray.rightChild(i);

        // find the smallest among 3 nodes
        int smallest = i;

        // check if the left node is smaller than the current node
        if (left <= size && heap[left].acc_count < heap[smallest].acc_count) {
            smallest = left;
        }

        // check if the right node is smaller than the current node 
        // and left node
        if (right <= size && heap[right].acc_count < heap[smallest].acc_count) {
            smallest = right;
        }
        // swap the largest node with the current node 
        // and repeat this process until the current node is larger than 
        // the right and the left node
        if (smallest != i) {
            Node temp = heap[i];
            heap[i] = heap[smallest];
            heap[smallest] = temp;
            minHeapify(smallest);
        }
    }
    
    /**
     * deletes the min item and return
     * @return the smallest node
     */
    public Node extractMin() {
        Node temp = heap[0];
        // replace the first item with the last item
        heap[0] = heap[size - 1];
        size = size - 1;

        // maintain the heap property by heapifying the 
        // first item
        minHeapify(0);
		return temp;
    }

}
