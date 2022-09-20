package TrafficCrashAnalysisChicago;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * BinarySearchAVLExperiments.java - Run all the 5 Experiments in balanced Binary search tree(AVL tree)
 * @author nsrao
 *
 */
public class BinarySearchAVLExperiments {
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
	 * Instantiation of BinarySearchAVLTreeLL
	 */
	public BinarySearchAVLTreeLL bst = new BinarySearchAVLTreeLL();
	
	/**
	 * Experiment 1: Search Accident History of Vehicle using Vehicle ID
	 * @param root root node of the tree
	 * @param vid  Vehicle ID to be searched
	 * @return arraylist containing accident info of that vehicle
	 */
	
	public ArrayList<TrafficAccident> SearchAccidentHistoryVehicleID(Node root,String vid)
	{
		
		if(root != null)
		{
			//System.out.println(Integer.parseInt(root.data.getVehicleId()) == Integer.parseInt(vid));
			if(Integer.parseInt(root.data.getVehicleId()) == Integer.parseInt(vid))
			{
				AccidentList.add(root.data);
				root.duplicateEntries.forEach(ele -> AccidentList.add(ele));
				
			}
			else if(Integer.parseInt(root.data.getVehicleId()) > Integer.parseInt(vid))
			{
				SearchAccidentHistoryVehicleID(root.left,vid);
			}
			else
			{
				SearchAccidentHistoryVehicleID(root.right,vid);
			}
				
		}
		return AccidentList;
		
	}

	/**
	 * Experiment 2 : Search Victims by Person ID
	 * @param node root node of the tree
	 * @param pid  person id to be searched
	 * @return arraylist containing accident info of that person
	 */
	public ArrayList<TrafficAccident> SearchVictimsByPersonId( Node node, String pid)
    {
        if (node == null)
            return personInfoList;
     
        if (node.data.getPersonID().equals(pid))
        {
        	personInfoList.add(node.data);
        	node.duplicateEntries.forEach(ele -> personInfoList.add(ele));
        	//return true;
        }
        else if(node.data.getPersonID().compareTo(pid) > 0)
        	SearchVictimsByPersonId(node.left, pid);
        else
        	SearchVictimsByPersonId(node.right, pid); 
        return personInfoList;
    }
    
	/**
	 * Experiment 3: Search Victims by RD Number
	 * @param node  root node of the tree
	 * @param rdNO  rdNo to be searched
	 * @return arraylist containing victim info of that rdNo
	 */
	public ArrayList<TrafficAccident> SearchVictimsByRdNo( Node node, String rdNO)
    {
        if (node == null)
            return VictimList;
     
        if (node.data.getRD_NO().equals(rdNO))
        {
        	VictimList.add(node.data);
        	node.duplicateEntries.forEach(ele -> VictimList.add(ele));
        }
        else if(node.data.getRD_NO().compareTo(rdNO) > 0)
        	SearchVictimsByRdNo(node.left, rdNO);
        else
        	SearchVictimsByRdNo(node.right, rdNO); 
        return VictimList;
           
    }
    
    
    /**
     * Experiment 4: Search count of accidents on particular date
     * @param root  root node of the tree
     * @param date  search the accident on particular date
     * @return  arraylist of accidents that occurred on that date
     */
    public ArrayList<String> SearchCountofCasesByDate(Node root, String date)
	{
		//Check whether tree is empty  
        if(root == null){  
          System.out.println("Tree is empty");  
        }  
        else{  
          //If value is found in the given binary tree then, set the flag to true  
          if(root.data.getCrashDate().equals(date)){ 
        	  RDNoListByDate.add(root.data.getRD_NO());
        	  root.duplicateEntries.forEach(x-> RDNoListByDate.add(x.getRD_NO()));
          }  
          else if(root.data.getCrashDate().compareTo(date) > 0)
        	  SearchCountofCasesByDate(root.left, date);
          else
        	  SearchCountofCasesByDate(root.right, date); 
        }
        return RDNoListByDate;
	}
	
    /**
     * Experiment 5: Search count of accidents  in a particular city
     * @param root root node of the tree
     * @param city  search the accidents that occurred in this city
     * @return arraylist of accidents that occurred in the city
     */
	public ArrayList<String> SearchCountofCasesByCities(Node root, String city)
	{
		//Check whether tree is empty  
        if(root == null){  
          System.out.println("Tree is empty");  
        }  
        else{  
          //If value is found in the given binary tree then, set the flag to true  
          if(root.data.getCity().equals(city)){ 
        	  
        	  RDNoListByCity.add(root.data.getRD_NO());
        	  root.duplicateEntries.forEach(x-> RDNoListByCity.add(x.getRD_NO()));
        	  
          }  
          //Search in left subtree  
          else if(root.data.getCity().compareTo(city) > 0){  
        	  SearchCountofCasesByCities(root.left, city);  
          }  
          else{  
        	  SearchCountofCasesByCities(root.right, city);  
          }  
        }
        return RDNoListByCity;
	}
	
	/**
	 * root node of tree inserted based on city
	 */
	public static Node rootCity = null;
	
	/**
	 * root node of tree inserted based on date
	 */
	public static Node rootDate = null;
	
	/**
	 * root node of tree inserted based on vehicle id
	 */
	public static Node rootVehicleID = null;
	
	/**
	 * root node of tree inserted based on person id
	 */
	public static Node rootPId = null;
	
	/**
	 * root node of tree inserted based on rd_no
	 */
	public static Node rootRdNo = null;
	
	/**
	 * Insert into AVL tree from Excel data based on experiments (i.e sorted tree nodes based on the 5 experiments)
	 */
	public void InsertIntoTree() {
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
	            String sex=data[5];
	            String age=data[6];
	            String city=data[7];
	            String zipcode = data[8];
	            TrafficAccident t = new TrafficAccident(person_id,person_type,rd_no,vehicle_id,crash_date,sex,age,city,zipcode);
	            rootVehicleID = bst.insertByVehicleId(rootVehicleID,t);		
	            rootCity = bst.insertByCity(rootCity, t);
	            rootDate = bst.insertByDate(rootDate,t);
	            rootPId =  bst.insertByPersonId(rootPId, t);
	            rootRdNo =  bst.insertByRDNo(rootRdNo, t);
	        };
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
