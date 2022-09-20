package TrafficCrashAnalysisHeap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * MinHeapPQExperiments.java - Run all the three experiments in Min Heap using Priority Queue
 * @author nsrao
 */
public class MinHeapPQExperiments {
	
	/**
	 * Heap data structure for storing city wise accident count
	 */
	PriorityQueue<Node> countHeapCity =  new PriorityQueue<Node>(); 
	
	/**
	 * Heap data structure for storing Age Group wise accident count
	 */
	PriorityQueue<Node> countHeapAgeGroup = new PriorityQueue<Node>();
	
	/**
	 * Heap data structure for storing Day wise accident count
	 */
	PriorityQueue<Node> countHeapDay = new PriorityQueue<Node>();
	
	/**
	 * Heap data structure to store Traffic Accident Data
	 */
	PriorityQueue<TrafficAccident> minHeapCity = new PriorityQueue<TrafficAccident>(10,new Comparator<TrafficAccident>() {
		@Override
		public int compare(TrafficAccident o1, TrafficAccident o2) {
			//return Integer.parseInt(o2.getVehicleId()) - Integer.parseInt(o1.getVehicleId());
			return o2.getCity().compareTo(o1.getCity());
		}
		
	}); 
	
	/**
	 * Heap data structure to store Node having day of the week
	 */
	PriorityQueue<Node> HeapDay = new PriorityQueue<Node>(10,new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			return o1.day.compareTo(o2.day);
		}
		
	});
	
	/**
	 * Heap data structure to store Node Data with Age
	 */
	PriorityQueue<Node> minHeapAge = new PriorityQueue<Node>(10, new Comparator<Node>() {

		@Override
		public int compare(Node o1, Node o2) {
			// TODO Auto-generated method stub
			
			return o1.ageGroup.compareTo(o2.ageGroup);
		}
		
	});
	
	/**
	 * Function to aggregate common cities into a single node and increment accident count
	 * @param minHeap Heap data structure with duplicate data
	 * @return Priority Queue with city wise accident count
	 */
	public static PriorityQueue<Node> dealWithDupsCity(PriorityQueue<TrafficAccident> minHeap)
	{
		PriorityQueue<Node> countHeap = new PriorityQueue<Node>(10, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.acc_count-o2.acc_count;
			}
			
		});
		
		TrafficAccident var,prev=null;
		prev = minHeap.poll();
		Node temp=new Node(prev)	;
		
		while (minHeap.size() != 0) {
		    var = minHeap.poll();
		    if(!prev.getCity().equals(var.getCity()))
		    {
		    	countHeap.add(temp);
		    	temp = new Node(var);
		    	
		    }
		    else {
		    	temp.acc_count++;
		    }
		    prev = var;
		}
		return countHeap;
	}
	
	/**
	 * Function to aggregate common days into a single node and increment accident count
	 * @param minHeap Heap data structure with duplicate data
	 * @return Priority Queue with day wise accident count
	 */
	public static PriorityQueue<Node> dealWithDupDays(PriorityQueue<Node> minHeap)
	{
		PriorityQueue<Node> countHeap = new PriorityQueue<Node>(10,new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.acc_count - o2.acc_count;
			}
			
		});
		
		Node var,prev=null;
		
		prev = minHeap.poll();
		
		Node temp=new Node(prev.data,prev.day);
		while (minHeap.size() != 0) {
		    var = minHeap.poll();
		    if(!prev.day.equals(var.day))
		    {
		    	countHeap.add(temp);
		    	temp = new Node(var.data,var.day);
		    	
		    }
		    else {
		    	temp.acc_count++;
		    }
		    prev = var;
		}
		return countHeap;
	}
	
	/**
	 * Function to aggregate common age groups into a single node and increment accident count
	 * @param minHeap Heap data structure with duplicate data
	 * @return Priority Queue with age groups wise accident count
	 */
	public static PriorityQueue<Node> dealWithDupAge(PriorityQueue<Node> minHeap)
	{
		PriorityQueue<Node> countHeap = new PriorityQueue<Node>(10,new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o1.acc_count - o2.acc_count;
			}
			
		});
		
		Node var,prev=null;
		
		prev = minHeap.poll();
		
		Node temp=prev;
		while (minHeap.size() != 0) {
		    var = minHeap.poll();
		    if(!prev.ageGroup.equals(var.ageGroup))
		    {
		    	countHeap.add(temp);
		    	temp = new Node(var.ageGroup);
		    	
		    }
		    else {
		    	temp.acc_count++;
		    }
		    prev = var;
		}
		countHeap.add(temp);
		return countHeap;
	}
	
	/**
	 * Get the data from the excel and create a heap node using  Age group.
	 */
	public PriorityQueue<Node> insertByAgeGroup()
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
   	            minHeapAge.add(new Node(ageGroup));
   	        }
   	     countHeapAgeGroup = dealWithDupAge(minHeapAge);
   	        
   		} catch (FileNotFoundException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   			System.err.println(e);
   		} catch (IOException e) {
   			// TODO Auto-generated catch block
   			e.printStackTrace();
   			System.err.println(e);
   		}
		return minHeapAge;
   	}
	
	/**
	 * Get the data from the excel and create a heap node of TrafficAccident Type
	 */	
	public void insertByCity()
	{
		Date date;
		String csvFilePath = "src/TrafficCrashesChicagoData.csv";
		BufferedReader lineReader;
		int i=0;
		Calendar cal = Calendar.getInstance();  
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
	            minHeapCity.add(t);
	        }
	        countHeapCity = dealWithDupsCity(minHeapCity);
	                
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
	public void insertByDay() throws ParseException
	{
		Date date;
		String csvFilePath = "src/TrafficCrashesChicagoData.csv";
		BufferedReader lineReader;
		int i=0;
		Calendar cal = Calendar.getInstance();  
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
	            HeapDay.add(new Node(t,str));
	        }
	        countHeapDay = dealWithDupDays(HeapDay);
	                
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
	 * Experiment 1 - Getting the least N cities based on accident count using Heaps
	 * @param num Number of cities
	 * @return Array list containing least N cities based on the accident count
	 */
	public ArrayList<Node> leastAccidentByCity(int num)
	{
		ArrayList<Node> ret = new ArrayList<Node>();
		int idx = 0;
		Node var3;
		while(idx<num) {
			var3 = countHeapCity.poll();
			if(var3!=null)
			{
				ret.add(new Node(var3.data));
				idx++;
			}
			else
				break;
			    
		}
		return ret;
	}
	
	/**
	 * Experiment 2 - Getting the least N  Groups of people based on age who were in accident using Heaps
	 * @param num Number of groups
	 * @return Array list containing least N Age groups of people
	 */
	public ArrayList<Node> leastAccidentByAgeGroup(int num)
	{
		ArrayList<Node> ret = new ArrayList<Node>();
		int idx = 0;
		Node var2;
		while(idx<num) {
			var2 = countHeapAgeGroup.poll();
			if(var2!=null)
			{
				ret.add(new Node(var2.ageGroup));
				idx++;
			}
			else
				break;
			    
		}
		return ret;
	}
	
	/**
	 * Experiment 3 - Getting the least N days of the week when accidents occur using Heaps
	 * @param num Number of Days
	 * @return Array list containing least N days of week accidents occur.
	 */
	public ArrayList<Node> leastAccidentByDay(int num) throws ParseException
	{
		ArrayList<Node> ret = new ArrayList<Node>();
		int idx = 0;
		Node var1;
		while(idx<num) {
			var1 = countHeapDay.poll();
			if(var1!=null)
			{
				ret.add(new Node(var1.data,var1.day));
				idx++;
			}
			else
				break;
			    
		}

		return ret;
	}
}
