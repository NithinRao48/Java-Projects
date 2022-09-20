package TrafficCrashAnalysisChicago;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * BinaryTreeArrayExperiments.java - Run all the 5 Experiments in Binary  tree constructed using array
 * @author nsrao
 */
public class BinaryTreeArrayExperiments {
	
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
	 * Binary tree using array instantiation
	 */
	public  BinaryTreeArray btArray = new BinaryTreeArray();
	
	/**
	 * Experiment 1: Search Accident History of Vehicle using Vehicle ID
	 * @param root root  node of the tree
	 * @param vid vehicleID to be searched
	 * @return Arraylist of traffic accident of that vehicle
	 */
	public ArrayList<TrafficAccident> SearchAccidentHistoryVehicleID(Node root, String vid)
	{
		
		//Check whether tree is empty  
        if(root == null){  
          System.out.println("Tree is empty");  
        }  
        else{  
          //If value is found in the given binary tree then, set the flag to true  
          if(root.data.getVehicleId().equals(vid)){ 
        	  AccidentList.add(root.data);
          }  
          //Search in left subtree  
          if(root.left != null){  
        	  SearchAccidentHistoryVehicleID(root.left, vid);  
          }  
          //Search in right subtree  
          if(root.right != null){  
        	  SearchAccidentHistoryVehicleID(root.right, vid);  
          }  
        }
        return AccidentList;
	}
	
	/**
	 * Experiment 2 : Search Victims by Person ID
	 * @param root  root node of the tree
	 * @param pid personID to be searched
	 * @return ArrayList of accidents in which this person is involved 
	 */
	public ArrayList<TrafficAccident> SearchVictimsByPersonId(Node root, String pid)
	{
		if(root!=null)
		{
			if(root.data.getPersonID().equals(pid))
			{ 
				personInfoList.add(root.data);
		    }
			
			//Search in left subtree  
	        if(root.left != null){  
	          SearchVictimsByPersonId(root.left, pid);  
	        }  
	        //Search in right subtree  
	        if(root.right != null){  
	          SearchVictimsByPersonId(root.right, pid);  
	        }  
		}
		return personInfoList;
    }
	
	/**
	 * Experiment 3: Search Victims by RD Number
	 * @param root  root node of the tree
	 * @param rdNO  rdNO to be searched
	 * @return 	Array list of victim information involved in an accident
	 */
	public ArrayList<TrafficAccident> SearchVictimsByRdNo(Node root, String rdNO)
	{
		
		//Check whether tree is empty  
        if(root == null){  
          System.out.println("Tree is empty");  
        }  
        else{  
          //If value is found in the given binary tree then, set the flag to true  
          if(root.data.getRD_NO().equals(rdNO)){ 
        	  VictimList.add(root.data);
          }  
          //Search in left subtree  
          if(root.left != null){  
        	  SearchVictimsByRdNo(root.left, rdNO);  
          }  
          //Search in right subtree  
          if(root.right != null){  
        	  SearchVictimsByRdNo(root.right, rdNO);  
          }  
        }
        return VictimList;
	}
	
	/**
	 * Experiment 4: Search count of accidents on particular date
	 * @param root 	root node of the tree
	 * @param date 	date to be searched
	 * @return Arraylist of accidents occurring in that date
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
	 * @param root	root node of the tree
	 * @param city	city to be searched
	 * @return Array list of accidents occuring in that city
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
	 * Insert into Binary tree using array from Excel data
	 * @return root node of the tree
	 */
	public Node InsertIntoBinaryTreeArray() {
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
	            btArray.add(t);
	        }
	        btArray.root = btArray.insert(btArray.root, 0);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(e);
		}
		return btArray.root;
	}


	
	
	
	
	/*
	public static void main( String[] args)
    {
    	String csvFilePath = "C:/Users/nsrao/Downloads/TrafficDataJava.csv";
		BufferedReader lineReader;
		ArrayList<TrafficAccident> AccidentList = new ArrayList<TrafficAccident>();
		ArrayList<String> rdNo = new ArrayList<String>();
		int ix=0;
		BinaryTreeArray btArray = new BinaryTreeArray();
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
	            btArray.add(t);
	            //System.out.println(ix++);
	        }
	        btArray.root = btArray.insert(btArray.root, 0);
	        AccidentList =BinaryTreeArrayExperiments.SearchVictimsByRdNo(btArray.root,"JC320676");
	      	AccidentList.forEach(x -> x.printInfo());
	        
	      	rdNo = BinaryTreeArrayExperiments.SearchCountofCasesByCities(btArray.root, "CHICAGO");
	      	rdNo.stream().distinct().forEach(x -> System.out.println(x));
	        
	      	
	      	
	        //BinaryTreeArrayExperiments.SearchVictimsByPersonId(btArray.root,"O401198").data.printInfo();;
	        /*
			// Top N Cities Calculation
			
			btArray.topNCities(btArray.root,5);
			TreeSet<CasesByCities> peopleSet = new TreeSet<>(new Comparator<CasesByCities>() {
			    @Override
			    public int compare(CasesByCities o1, CasesByCities o2) {
			        return o1.rd_arr.compareTo(o2.rd_arr);
			    }
			});
			peopleSet.addAll(cityCount);
			Stream<CasesByCities> peopleSet1 = peopleSet.stream()
			        .distinct()
			        .sorted(new Comparator<CasesByCities>() {
			        	@Override
					    public int compare(CasesByCities o1, CasesByCities o2) {
					        return o1.city.compareTo(o2.city);
					    }
			        });
			peopleSet1.forEach(a -> a.printinfo());
			*/

			// Searching count of cases by Date
			
			//BinaryTreeArrayExperiments.SearchCountofCasesByDateBinaryTree(btArray.root,"02/24/2019");
			/*AccidentList.stream().distinct().forEach(a -> System.out.println(a));
			System.out.println(AccidentList.stream().distinct().count());
			
	        //LinearSearchQueue("567870");
	        //SearchVictimsByDateQueue("02/24/2018");
	        //SearchCountofCasesByDateStack("02/24/2019");
	        //SearchVictimsByRdNoStack("JB164132")  ; 
	         * 
*/
	/*
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
    
    */

}
