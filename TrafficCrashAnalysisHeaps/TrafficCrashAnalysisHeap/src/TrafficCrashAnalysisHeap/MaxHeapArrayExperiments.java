package TrafficCrashAnalysisHeap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * MaxHeapArrayExperiments.java - Run all the three experiments in Max Heap using arrays
 * @author nsrao
 *
 */
public class MaxHeapArrayExperiments {
	
	/**
	 * Instantiating a max heap data structure created using array
	 */
	public MaxHeapArray maxHeap = new MaxHeapArray();
	
	/**
	 * Experiment 1 - Getting the top N cities based on accident count using Heaps
	 * @param num Number of cities to be displayed
	 * @return Array list containing top N cities based on the accident count
	 */
	
	public ArrayList<Node> topAccidentByCity(int num)
	{
		ArrayList<Node> ret = new ArrayList<Node>();
		for (int i=0;i<num;i++)	
		{
			Node temp = maxHeap.extractMax();
			ret.add(temp);
		}
		return ret;
	}
	
	/**
	 * Experiment 2 - Getting the top N  Groups of people based on age who were in accident using Heaps
	 * @param num Number of groups
	 * @return Array list containing top N Age groups of people
	 */
	public ArrayList<Node> topAccidentByAgeGroup(int num)
	{
		ArrayList<Node> ret = new ArrayList<Node>();
		for (int i=0;i<num;i++)	
		{
			Node temp = maxHeap.extractMax();
			ret.add(temp);
		}
		return ret;
	}
	
	/**
	 * Experiment 3 - Getting the top N days of the week when accidents occur using Heaps
	 * @param num Number of Days
	 * @return Array list containing top N days of week accidents occur.
	 */
	public ArrayList<Node> topAccidentByDay(int num)
	{
		ArrayList<Node> ret = new ArrayList<Node>();
		for (int i=0;i<num;i++)	
		{
			Node temp = maxHeap.extractMax();
			ret.add(temp);
		}
		return ret;
	}
	
	/**
	 * Get the data from the excel and create a heap node of TrafficAccident Type
	 */
	public void insertByCity()
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
   	            String sex=data[5];
   	            String age=data[6];
   	            String city=data[7];
   	            String zipcode = data[8];
   	            TrafficAccident t = new TrafficAccident(person_id,person_type,rd_no,vehicle_id,crash_date,sex,age,city,zipcode);
   	            maxHeap.insertByCity(t);
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
	
	/**
	 * Get the data from the excel and create a heap node using  Age group.
	 */
	public void insertByAgeGroup()
    {
        
    	String csvFilePath = "src/TrafficCrashesChicagoData.csv";
   		BufferedReader lineReader;
   		String ageGroup = null;
   		try {
   			lineReader = new BufferedReader(new FileReader(csvFilePath));
   			String lineText = null;
   	        lineReader.readLine(); // skip header line
   	        while ((lineText = lineReader.readLine()) != null) {
   	            String[] data = lineText.split(",");
   	            int age=Integer.parseInt(data[6]);
   	            switch ((0<= age && age<18) ? 0 : 
   	            		(18<= age && age<25) ? 1 :
   	            		(25<= age && age<40) ? 2 :
   	            		(40<= age && age<65) ? 3 :
   	            		(65<= age&& age<=100) ? 4 : 5)
	   	         {
	   	        	case 0 : ageGroup = "0-18";
	   	        					break;
	   	        	case 1 : ageGroup = "18-25";
						break;
	   	        	case 2 : ageGroup = "25-40";
						break;
	   	        	case 3 : ageGroup = "40-65";
						break;
	   	        	case 4 : ageGroup = "65-100";
						break;
	   	        	case 5 : ageGroup = "100 >";
						break;
	   	         }
   	            maxHeap.insertByAge(ageGroup);
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
	
	/**
	 * Get the data from the excel and create a heap node using  Traffic Accident Data and day 
	 */
	
	 public void InsertByDay()
	    {
	    	Date date;
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
		            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy"); 
		            date= sdf.parse(crash_date);  
		            //specifies the pattern to print  
			        sdf.applyPattern("EEEE");  
			        String str = sdf.format(date);  
		            TrafficAccident t = new TrafficAccident(person_id,person_type,rd_no,vehicle_id,crash_date,sex,age,city,zipcode);
		            maxHeap.insertByDay(t,str);
		        }
		        	        
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(e);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(e);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
}
