package TrafficCrashAnalysisChicago;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * BinaryTreeLLExperiments.java - Run all the 5 Experiments in Binary tree constructed by linked list 
 * @author nsrao
 *
 */
public class BinaryTreeLLExperiments {
	
	/**
	 * List containing traffic accident info based on vehicle ID
	 */
	public  ArrayList<TrafficAccident> AccidentList = new ArrayList<TrafficAccident>();
	
	/**
	 * List containing traffic accident info based on rd_no
	 */
	public  ArrayList<TrafficAccident> VictimList = new ArrayList<TrafficAccident>();
	
	/**
	 * List containing traffic accident info based on person ID
	 */
	public  ArrayList<TrafficAccident> personInfoList = new ArrayList<TrafficAccident>();
	
	/**
	 * List containing traffic accident info based on rd_no on a date
	 */
	public  ArrayList<String> RDNoListByDate = new ArrayList<String>();
	
	/**
	 * List containing traffic accident info based on rd_no in a city
	 */
	public  ArrayList<String> RDNoListByCity = new ArrayList<String>();
	
	/**
	 * A binary tree using linked list instantiation
	 */
	public  BinaryTreeLL btLL = new BinaryTreeLL();
	
	/**
	 * head node of linked list 
	 */
	public  LinkedListNode head = null;
	
	/**
	 * Experiment 1: Search Accident History of Vehicle using Vehicle ID
	 * @param root root node of the tree
	 * @param vid vehicle id to be searched
	 * @return array list of traffic accident in which the above vehicle is involved
	 */
	public ArrayList<TrafficAccident> SearchAccidentHistoryVehicleID( Node root, String vid)
    {
        if (root == null)
            return AccidentList;
     
        if (root.data.getVehicleId().equals(vid))
        {
        	AccidentList.add(root.data);
        	//return true;
        }
            
        SearchAccidentHistoryVehicleID(root.left, vid);
        SearchAccidentHistoryVehicleID(root.right, vid);
        return AccidentList;
    
    }
    
	/**
	 * Experiment 2 : Search Victims by Person ID
	 * @param root root node of the tree
	 * @param pid person id to be searched
	 * @return array list of accidents in which the baove person is involved
	 */
    public ArrayList<TrafficAccident> SearchVictimsByPersonId( Node root, String pid)
    {
        if (root == null)
            return personInfoList;
     
        if (root.data.getPersonID().equals(pid))
        {
        	personInfoList.add(root.data);
        	//return true;
        }
            
        SearchVictimsByPersonId(root.left, pid);
        SearchVictimsByPersonId(root.right, pid);
        return personInfoList;
    
    }
    
    /**
     * Experiment 3: Search Victims by RD Number
     * @param root root node of the tree
     * @param rdNo rdNo to be searched
     * @return array list of victim information involved in an accident
     */
    
    public ArrayList<TrafficAccident> SearchVictimsByRdNo( Node root, String rdNo)
    {
        if (root == null)
            return VictimList;
     
        if (root.data.getRD_NO().equals(rdNo))
        {
        	VictimList.add(root.data);
        	//return true;
        }
            
        SearchVictimsByRdNo(root.left, rdNo);
        SearchVictimsByRdNo(root.right, rdNo);
        return VictimList;
    
    }
    
    /**
     * Experiment 4: Search count of accidents on particular date
     * @param root root node of the tree
     * @param date date to be searched
     * @return array list of accidents that have occured in that date
     */
    public  ArrayList<String> SearchCountofCasesByDate(Node root, String date)
	{
		
		//Check whether tree is empty  
        if(root == null){  
          System.out.println("Tree is empty");  
        }  
        else{  
          //If value is found in the given binary tree then, set the flag to true  
          if(root.data.getCrashDate().equals(date)){ 
        	  RDNoListByDate.add(root.data.getRD_NO());
          }  
          //Search in left subtree  
          if(root.left != null){  
        	  SearchCountofCasesByDate(root.left, date);  
          }  
          //Search in right subtree  
          if(root.right != null){  
        	  SearchCountofCasesByDate(root.right, date);  
          }  
        }
        return RDNoListByDate;
	}
	
    /**
     * Experiment 5: Search count of accidents  in a particular city
     * @param root root node of the tree
     * @param city city to be searched
     * @return array list of accident occured in that city
     */
	public  ArrayList<String> SearchCountofCasesByCities(Node root, String city)
	{
		//Check whether tree is empty  
        if(root == null){  
          System.out.println("Tree is empty");  
        }  
        else{  
          //If value is found in the given binary tree then, set the flag to true  
          if(root.data.getCity().equals(city)){ 
        	  RDNoListByCity.add(root.data.getRD_NO());
          }  
          //Search in left subtree  
          if(root.left != null){  
        	  SearchCountofCasesByCities(root.left, city);  
          }  
          //Search in right subtree  
          if(root.right != null){  
        	  SearchCountofCasesByCities(root.right, city);  
          }  
        }
        return RDNoListByCity;
	}
	
	/**
	 * Insert into Binary tree from Excel data
	 * @return root of the tree after insertion
	 */
	public Node InsertIntoBinaryTreeLL() {
		String csvFilePath = "src/TrafficCrashesChicagoData.csv";
		BufferedReader lineReader;
		
		Node root = null;
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
	            String sex=data[5];
	            String age=data[6];
	            String city=data[7];
	            String zipcode = data[8];
	            TrafficAccident t = new TrafficAccident(person_id,person_type,rd_no,vehicle_id,crash_date,sex,age,city,zipcode);
	            head = btLL.push(head,t);
	                        
	        }
	        root = btLL.convertListToBinaryTree(head);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}
		return root;
	}
	
}
