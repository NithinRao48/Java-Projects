package TrafficCrashAnalysisMaps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * HashMap.java implementation of custom Hashmap using array of linked list
 * @author nsrao
 * 
 * @param <K> key type
 * @param <V> value type
 */
public class HashMap<K, V extends TrafficAccident> {

	/**
	 * Capacity of the array since it is fixed
	 */
    private static final int ARRAY_SIZE = 400000;
    
    /**
     * Represents each node in a hash map as a key value pair
     */
    private Node<K, V>[] nodeList = new Node[ARRAY_SIZE];
    
    /**
     * Hashmap containing RD_Number as key and the corresponding Traffic accident as values
     */
    public static HashMap<String, TrafficAccident> hashMapRdNo = new HashMap<>();
    
    /**
     * Hashmap containing Vehicle ID as key and the corresponding Traffic accident as values
     */
    public static HashMap<String, TrafficAccident> hashMapVId = new HashMap<>();
    
    /**
     * Hashmap containing Person ID as key and the corresponding Traffic accident as values
     */
    public static HashMap<String, TrafficAccident> hashMapPId = new HashMap<>();
    
    /**
     * Hashmap containing City Name as key and the corresponding Traffic accident as values
     */
    public static HashMap<String, TrafficAccident> hashMapCity = new HashMap<>();
    
    /**
     * Hashmap containing CrashDate(having only month and year) as key and the corresponding Traffic accident as values
     */
    
    public static HashMap<String, TrafficAccident> hashMapmmYY = new HashMap<>();
    
    /**
     * Array List of traffic accident to handle duplicates
     */
    static ArrayList<TrafficAccident> ta = new ArrayList<TrafficAccident>();
    
    
    /**
     * Function of HashMap to add a new key value pair into the data structure
     * @param key Key to be added to the hashmap
     * @param value value to be added to the hashmap
     */
    public void put(K key, V value)  {

        long hashCode = this.getHashCode(key);
        int index = this.getIndex(hashCode);
        if (index > ARRAY_SIZE) {
            System.out.println("Invalid key, please check again!");
        }

    	// Check if there is a Node at this index 
        if (this.nodeList[index] != null) {

            Node<K, V> existingNode = this.nodeList[index];

            while (existingNode.getNext() != null) {
                existingNode = existingNode.getNext();
            }

    		// We're creating the new Node.
            Node<K, V> newNode = new Node<>();
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setHashCode(hashCode);
            existingNode.setNext(newNode);

        } else {
        	
    		// If there's no Node, we create a new Node and add to the array
            Node<K, V> newNode = new Node<>();
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setHashCode(hashCode);
            this.nodeList[index] = newNode;
        }
    }
    
    /**
     * Function of hashmap to add key value pair with lasrge number of duplicates to be stored in values
     * @param key Key to be added to the hashmap
     * @param value value to be added to the hashmap
     */
    protected void putLong(K key, V value)  {

        long hashCode = this.getHashCode(key);
        int index = this.getIndex(hashCode);
        if (index > ARRAY_SIZE) {
            System.out.println("Invalid key, please check again!");
        }

        // Check if there is a Node at this index 	
        if (this.nodeList[index] != null) {

            Node<K, V> exitingNode = this.nodeList[index];

            exitingNode.entries.add(value);

        } else {
        	// If there's no Node, we create a new Node and add to the array
            Node<K, V> newNode = new Node<>();
            newNode.setKey(key);
            newNode.setValue(value);
            newNode.setHashCode(hashCode);
            newNode.entries.add(value);
            this.nodeList[index] = newNode;
        }
    }

    /**
     * Returns the Hashcode for the given key
     * @param key Key of which the hashcode needs to be generated
     * @return
     */
    private long getHashCode(K key) {

        String keyString = key.toString();
        return keyString.hashCode();
    }

    /**
     * Returns the index of the array for the given hashcode
     * @param hashCode hashcode of which the index corresponding in array needs to be generated.
     * @return
     */
    private int getIndex(long hashCode) {

        return Math.toIntExact((hashCode & 0x7fffffff) % ARRAY_SIZE);
    }
    
    /**
     * Function  to get the value of the Key from the hash map
     * @param key key of the Hashmap
     * @return arraylist of TrafficAccident
     */
    public ArrayList<TrafficAccident> get(K key) {
    	long hashCode = this.getHashCode(key);
        int index = this.getIndex(hashCode);
        
        Node<K, V> node = this.nodeList[index];

        if (node != null) {
            while (node != null) {
                if(node.getKey().equals(key))
                {
                	ta.add(node.getValue());
                }
                node = node.getNext();
            }
        }
       return ta;
        
    }
    
    /**
     * Function  to get the value of the Key from the hash map having large number of duplicates
     * @param key key of the Hashmap
     * @return
     */
    protected Node<K, V> getLong(K entry) {
    	long hashCode = this.getHashCode(entry);
        int index = this.getIndex(hashCode);
        
        Node<K, V> node = this.nodeList[index];

        if (node != null) {
        	return node;
        }
		return node;
    }
    
   

    /**
     * Function which inserts Traffic accident data into hashmaps
     */
    public void insertIntoHashMap()
    {
    	String csvFilePath = "src/TrafficCrashesChicagoData.csv";
   		BufferedReader lineReader;
   		try {
   			lineReader = new BufferedReader(new FileReader(csvFilePath));
   			String lineText = null;
   	        lineReader.readLine(); // skip header line
   	        while ((lineText = lineReader.readLine()) != null) {
   	            String[] data = lineText.split(",");
   	            String person_id = data[0];
   	            String person_type = data[1];
   	            String rd_no = data[2];
   	            String vehicle_id = data[3];
   	            String crash_date = data[4];
   	            String[] str = crash_date.split("-");
   	            String key_date = str[1]+"-"+str[2];
   	            //System.out.println(key_date);
   	            String sex=data[5];
   	            String age=data[6];
   	            String city=data[7];
   	            String zipcode = data[8];
   	            TrafficAccident t = new TrafficAccident(person_id,person_type,rd_no,vehicle_id,crash_date,sex,age,city,zipcode);
   	            hashMapmmYY.putLong(key_date, t);
   	            hashMapRdNo.put(rd_no, t);
   	            hashMapVId.put(vehicle_id, t);
   	            hashMapPId.put(person_id, t);
   	            hashMapCity.putLong(city, t);
   	        }
   	        
   		} catch (FileNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   			System.err.println(e);
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   			System.err.println(e);
   		}
    } 
}
