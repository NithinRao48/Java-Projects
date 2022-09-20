package trafficCrashesAnalysis;

import java.util.Arrays;
import java.util.Comparator;

/** 
 * ArrayQueue.java - a custom Queue implemented using array storing objects of type TrafficAccident 
 * @author nsrao
 */
public class ArrayQueue {

	private static int front, rear, capacity;
    private static TrafficAccident queue[];
 
    /**
     * constructor to create Queue with size
     */
    ArrayQueue(int c)
    {
        front = rear = 0;
        capacity = c;
        queue = new TrafficAccident[capacity];
    }
 
    /**
     * function to insert an element at the rear of the queue
     * @param data
     */
    
    public void queueEnqueue(TrafficAccident data)
    {
        // check queue is full or not
        if (capacity == rear) {
            System.out.printf("\nQueue is full\n");
            return;
        }
 
        // insert element at the rear
        else {
            queue[rear] = data;
            rear++;
        }
        return;
    }
    
    /**
     * Get Element by Index
     * @param index
     * @return TrafficAccident Object
     */
    public TrafficAccident get(int index)
    {
    	return getQueue()[index];
    }
    
    /**
     * function to delete an element from the front of the queue
     * @return TrafficAccident Object
     */ 
    
    public TrafficAccident queueDequeue()
    {
    	TrafficAccident rem;
        // if queue is empty
        if (isQueueEmpty()) {
            System.out.printf("\nQueue is empty\n");
            return new TrafficAccident();
        }
 
        // shift all the elements from index 2 till rear
        // to the right by one
        else {
        	rem = queue[0];
            for (int i = 0; i < rear - 1; i++) {
                queue[i] = queue[i + 1];
            }
 
            // store 0 at rear indicating there's no element
            if (rear < capacity)
                queue[rear] = new TrafficAccident();
 
            // decrement rear
            rear--;
        }
        return rem;
    }
    
    /**
     * Returns true if the Queue is empty
     * @return Boolean
     */
    
    public boolean isQueueEmpty() {
    	return rear==front;
    }
 
    /**
     * Returns  Queue size
     * @return Integer Data Type
     */
    
    public int size() {
    	return rear;
    }
    
    /** 
     * Sort the Queue array based on Vehicle ID
     * @return Array Data Type
     */
    
    public TrafficAccident[] TrafficAccidentSort() {
    	Arrays.sort(queue,0,size(),new TrafficAccidentVehicleIdComparator());
    	return queue;
    }
    
    /** 
     * Sort the Queue array based on City 
     * @return Array Data Type
     */
    
    public TrafficAccident[] TrafficAccidentSortCity() {
    	Arrays.sort(queue,0,size(),new TrafficAccidentComparator());
    	return queue;
    }
    
    /** 
     * Return the underlying array in Queue 
     * @return Array Data Type
     */
    
    public TrafficAccident[] getQueue() {
    	return queue;
    }
    
    /**
     * Binary Search the Queue Array using Vehicle ID
     * @param vid
     * @param cmp
     * @return Integer Data Type
     */
    
    public int binarySearchByVehicleId(String vid, Comparator<? super TrafficAccident> cmp) {
        int low = 0;
        int high = size() - 1;
        int mid;
        while (low <= high) {
            mid = (low + high) / 2;
            if (cmp.compare(queue[mid], new TrafficAccident(null,null,null,vid,null,null,null,null,null)) < 0) {
                low = mid + 1;
            } else if (cmp.compare(queue[mid], new TrafficAccident(null,null,null,vid,null,null,null,null,null)) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1; // NOT_FOUND = -1
    }
}
