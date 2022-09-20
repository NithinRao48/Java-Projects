package trafficCrashesAnalysis;

import java.util.Arrays;
import java.util.Comparator;

/** 
 * ArrayStack.java - a custom Stack implemented using array storing objects of type TrafficAccident 
 * @author nsrao
 */

public class ArrayStack <T extends TrafficAccident>{
	
	private int stackSize;
    private TrafficAccident[] stackArray;
    private int top;
 
    
    /**
     * constructor to create stack with size
     * @param size
     */
    public ArrayStack(int size) {
        this.stackSize = size;
        this.stackArray = (TrafficAccident[]) new TrafficAccident[stackSize];
        this.top = -1;
    }
 
    /**
     * Adds new entry to the top of the stack
     * @param entry
     */
     
    public void push(TrafficAccident entry){
        if(this.isStackFull()){
        	System.out.println("Stack Overflow");
            this.increaseStackCapacity();
        }
        this.stackArray[++top] = entry;
    }
 

     /**
      *  Removes an entry from the top of the stack.
      *  @return TrafficAccident Object
      */
     
    public TrafficAccident pop(){
        if(this.isStackEmpty()){
        	System.out.println("Stack underflow.");
        }
        TrafficAccident entry = this.stackArray[top--];
        return entry;
    }
 
    
    /**
     * Returns top of the stack without removing it.
     * @return Integer data type
     */
    
    public TrafficAccident peek() {
        return stackArray[top];
    }
    
    /**
     * Return the underlying Stack array data structure
     * @return Array
     */
    
    public TrafficAccident[] getArray() {
    	return stackArray;
    }
    
    /**
     * Returns true if the stack is empty
     * @return Boolean
     */
     
    public boolean isStackEmpty() {
        return (top == -1);
    }
 
    
    /**
     *  Returns true if the stack is full
     * @return Boolean
     */
    
    public boolean isStackFull() {
        return (top == stackSize - 1);
    }
 
    
     /**
      * Increase stack capacity
      */
     
    private void increaseStackCapacity(){	         
    	TrafficAccident[] newStack = (TrafficAccident[]) new TrafficAccident[this.stackSize*2];
        for(int i=0;i<stackSize;i++){
            newStack[i] = this.stackArray[i];
        }
        this.stackArray = newStack;
        this.stackSize = this.stackSize*2;
    }
    
    /** 
     * Size of the stack
     * @return Integer Data type
     */
    public int size() {
    	return top;
    }
    
    /** 
     * Sort the stack array based on Vehicle ID
     * @return Array Data Type
     */
    
    public TrafficAccident[] TrafficAccidentSort() {
    	Arrays.sort(stackArray,0,size(),new TrafficAccidentVehicleIdComparator());
    	return stackArray;
    }
    
    /**
     * Sort the stack array based on City Name
     * @return Array Data type
     */
    public TrafficAccident[] TrafficAccidentSortCity() {
    	Arrays.sort(stackArray,0,size(),new TrafficAccidentComparator());
    	return stackArray;
    }
    
    /**
     * Get stack array value by index
     * @param index
     * @return TrafficAccident Object
     */
    public TrafficAccident get(int index)
    {
    	return getArray()[index];
    }
    
    /**
     * Binary Search the Stack Array using Vehicle ID
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
            if (cmp.compare(stackArray[mid], new TrafficAccident(null,null,null,vid,null,null,null,null,null)) < 0) {
                low = mid + 1;
            } else if (cmp.compare(stackArray[mid], new TrafficAccident(null,null,null,vid,null,null,null,null,null)) > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}


