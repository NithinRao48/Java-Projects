package trafficCrashesAnalysis;

import java.io.*;
import java.util.stream.*;
import java.util.*;

/**
 * StackLinkedListExperiments.java - Run all the 5 Experiments using Stack from Collection Class Java
 * @author nsrao
 */
public class StackLinkedListExperiments {
	
	public static Stack <TrafficAccident> TrafficDataStack = new Stack<TrafficAccident> ();
	
	/**
	 * Experiment 1.1: Search Accident History of Vehicle using Vehicle ID Vehicle ID
	 * @param vehicleID
	 * @return
	 */
	public static ArrayList<TrafficAccident> SearchAccidentHistoryVehicleIDStack( String vehicleID)
	{
		ArrayList<TrafficAccident> ta = new ArrayList<TrafficAccident>();
		long startTime = System.nanoTime();
		TrafficDataStack.forEach(ele ->{
			if(ele.getVehicleId().equals(vehicleID))
			{
				ta.add(ele);
				ele.printInfo();
			}
		});
		long endTime = System.nanoTime();

		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
		return ta;
	}
	
	/**
	 * Experiment 1.2: Binary Search Accident History of Vehicle using Vehicle ID
	 * @param vehicleId
	 */
	
	public static void BinarySearchAccidentHistoryVehicleIDStack(String vehicleId)
    {
		System.out.println(TrafficDataStack.size());
    	long startTime = System.nanoTime();
    	Comparator<TrafficAccident> c = new Comparator<TrafficAccident>() {
		      public int compare(TrafficAccident u1, TrafficAccident u2) {
		        return u1.getVehicleId().compareTo(u2.getVehicleId());
		      }
		};
		 Collections.sort(TrafficDataStack,c);
		 int index = Collections.binarySearch(TrafficDataStack,new TrafficAccident(null,null,null,vehicleId,null,null,null,null,null), c);
		 //System.out.println("Search idx:\t"+index);
		 // Output: 1
		 TrafficDataStack.get(index).printInfo();
		 long endTime = System.nanoTime(); // get the difference between the two nano time valuess
		 long timeElapsed = endTime - startTime; System.out.println("Execution time in nanoseconds: " + timeElapsed);
		 System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
	
	/**
	 * Experiment 2 : Search Victims by Person ID
	 * @param pid
	 */
	
	public static ArrayList<TrafficAccident> SearchVictimsByPersonIdStack(String pid)
	{
		ArrayList<TrafficAccident> ta=new ArrayList<TrafficAccident>();
		long startTime = System.nanoTime();
		TrafficDataStack.forEach(ele ->{
			if(ele.getPersonID().equals(pid))
			{
				ta.add(ele);
			}
		});
		long endTime = System.nanoTime();

		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
		return ta;
	}
	
	/**
	 * Experiment 3: Search Victims by RD Number
	 * @param rdNO
	 */
	
	public static ArrayList<TrafficAccident> SearchVictimsByRdNoStack( String rdNO)
	{
		ArrayList<TrafficAccident> ta=new ArrayList<TrafficAccident>();
		long startTime = System.nanoTime();
		TrafficDataStack.forEach(ele ->{
			if(ele.getRD_NO().equals(rdNO))
			{
				ta.add(ele);
			}
		});
		long endTime = System.nanoTime();

		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
		return ta;
	}
	
	/**
	 * Experiment 4: Search count of accidents on particular date
	 * @param date
	 */
	
	public static ArrayList SearchCountofCasesByDateStack(String date)
	{
		long startTime = System.nanoTime();
		ArrayList<String> AccidentList = new ArrayList<String>();
		TrafficDataStack.forEach(ele ->{
			if(ele.getCrashDate().equals(date))
			{
				AccidentList.add(ele.getRD_NO());
			}
		});

		ArrayList uniqueRdNo = (ArrayList) AccidentList.stream().distinct().collect(Collectors.toList());
		System.out.println("Count of cases on this day is:"+uniqueRdNo.size());
		System.out.print("The cases are:");
		uniqueRdNo.forEach(ele -> System.out.print(ele+"\t"));
		long endTime = System.nanoTime();
		// get the difference between the two nano time values
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
		return uniqueRdNo;
	}
	
	/**
	 * Experiment 5: Sort top N cities based on no of accidents occurred
	 * @param N
	 */
	
	public static ArrayList<CasesByCities> TopNCitiesWithAccidentsStack(int N)
	{
		ArrayList<CasesByCities> topN=new ArrayList<CasesByCities>();
		ArrayList<String> RDArr=new ArrayList<String>();
		ArrayList<CasesByCities> topCasesByCity = new ArrayList<CasesByCities>();
		Collections.sort(TrafficDataStack,new TrafficAccidentComparator());
		String city;
		System.out.println("Size:"+TrafficDataStack.size());
		ListIterator<TrafficAccident> it = TrafficDataStack.listIterator();
		TrafficAccident e2db;
		city = TrafficDataStack.get(0).getCity();
		System.out.println(city);
		while(it.hasNext())
		{
			e2db = it.next();
			if(e2db.getCity().equals(city)) {
				RDArr.add(e2db.getRD_NO());
			}
			else {
				ArrayList uniqueList = (ArrayList) RDArr.stream().distinct().collect(Collectors.toList());
				CasesByCities obj = new CasesByCities(city,RDArr,uniqueList.size());
				topCasesByCity.add(obj);
				RDArr.clear();
				city = e2db.getCity();
				RDArr.add(e2db.getRD_NO());
			}
		}
		Comparator<CasesByCities> c = new Comparator<CasesByCities>() {
		      public int compare(CasesByCities u1, CasesByCities u2) {
		        return u2.getCount()- u1.getCount();
		      }
		};
		Collections.sort(topCasesByCity,c);
		
		for(int x=0;x<N;x++)
		{
			topN.add(topCasesByCity.get(x));
		}
		return topN;
	}
	
	/**
	 * Insert into Stack  from Excel Data
	 */
	
	public static void InsertIntoStackMain()
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
				TrafficDataStack.push(t);
			}
			System.out.println("Size:"+TrafficDataStack.size());
			//LinearSearchStack("567870");
			//SearchVictimsByDateStack("02/24/2018");
			//SearchCountofCasesByDateStack("02/24/2019");
			//SearchVictimsByRdNoStack("JB164132") ;
			} catch (FileNotFoundException e) {
				// 	TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(e);
			} catch (IOException e) {
				// 	TODO Auto-generated catch block
				e.printStackTrace();
				System.err.println(e);
			}
		//
	}
	


}
