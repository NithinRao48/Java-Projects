package TrafficCrashAnalysisMaps;

import java.util.ArrayList;

/**
 * Node.java Represents the Key value pair of the HashMap
 * @author nsrao
 * @param <K> Represents Key
 * @param <V> Represents Value
 */
public class Node<K, V> {

	/**
	 * Represents Key
	 */
    private K key;
    
    /**
     * Represents Value
     */
    private V value;
    
    /**
     * Pointer to the next Node 
     */
    private Node<K, V> next;
    
    /**
     * Handles duplicate values by adding it to entries
     */
    ArrayList<V> entries = new ArrayList<V>();
    
    /**
     * HashCode of the key 
     */
    private long hashCode;

    /**
     * Returns Key of the Node
     * @return K Key type
     */
    public K getKey() {
        return key;
    }

    /**
     * Sets the Node with the Key
     * @param key Key of the node
     */
    public void setKey(K key) {
        this.key = key;
    }

    /**
     * Returns the value of the Node
     * @return V Value type
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets the Node with the Value
     * @param value Value of the node
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Returns the next Node
     * @return Key value Node
     */
    public Node<K, V> getNext() {
        return next;
    }

    /**
     * Sets the Next node Pointer
     * @param next Next Node pointer
     */
    public void setNext(Node<K, V> next) {
        this.next = next;
    }

    /**
     * returns the Hashcode of the key 
     * @return hashcode of long data type
     */
    public long getHashCode() {
        return hashCode;
    }

    /**
     * Sets the hashcode for the Node
     * @param hashCode Hashcode of the node
     */
    public void setHashCode(long hashCode) {
        this.hashCode = hashCode;
    }
}

