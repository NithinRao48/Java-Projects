package trafficCrashesAnalysis;

import java.io.*;
import java.util.stream.*;
import java.util.*;

/**
 * QueueLinkedListExperiments - Run all the 5 Experiments using Queue from Collection Class Java
 * @author nsrao
 */
public class QueueLinkedListExperiments {

public static Queue <TrafficAccident> TrafficDataQueue = new LinkedList<TrafficAccident> ();
	
	/**
	 * Experiment 1: Search Accident History of Vehicle using Vehicle ID Vehicle ID
	 * @param vehicleID
	 * @return
	 */

	public static ArrayList<TrafficAccident> SearchAccidentHistoryVehicleIDQueue( String vehicleID)
	{
		ArrayList<TrafficAccident> ta = new ArrayList<TrafficAccident>();
		long startTime = System.nanoTime();
		Iterator<TrafficAccident> it = TrafficDataQueue.iterator();
		TrafficAccident e2db;
		while(it.hasNext()) {
			e2db = it.next();
			if(e2db.getVehicleId().equals(vehicleID))
			{
				ta.add(e2db);
			}
		}
		long endTime = System.nanoTime();

		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
		System.out.println("Execution time in milliseconds: " + TrafficDataQueue.size());
		return ta;
	}
	
	/**
	 * Experiment 2 : Search Victims by Person ID
	 * @param pid
	 */
	
	public static ArrayList<TrafficAccident> SearchVictimsByPersonIdQueue( String pid)
	{
		ArrayList<TrafficAccident> ta = new ArrayList<TrafficAccident>();
		long startTime = System.nanoTime();
		Iterator<TrafficAccident> it = TrafficDataQueue.iterator();
		TrafficAccident e2db;
		while(it.hasNext()) {
			e2db = it.next();
			if(e2db.getPersonID().equals(pid))
			{
				ta.add(e2db);
			}
		}
		long endTime = System.nanoTime();

		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
		return ta;
	}
	
	/**
	 * Experiment 3: Search count of accidents on particular date
	 * @param date
	 */
	
	
	public static ArrayList SearchCountofCasesByDateQueue(String date)
	{
		
		long startTime = System.nanoTime();
		ArrayList<String> AccidentList = new ArrayList<String>();
		TrafficDataQueue.forEach(ele ->{
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
	 * Experiment 4: Search Victims by RD Number
	 * @param rdNO
	 */
	
	public static ArrayList<TrafficAccident> SearchVictimsByRdNoQueue( String rdNO)
	{
		ArrayList<TrafficAccident> ta=new ArrayList<TrafficAccident>();
		long startTime = System.nanoTime();
		Iterator<TrafficAccident> it = TrafficDataQueue.iterator();
		TrafficAccident e2db;
		while(it.hasNext()) {
			e2db = it.next();
			if(e2db.getRD_NO().equals(rdNO))
			{
				ta.add(e2db);
			}
		}
		long endTime = System.nanoTime();

		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
		return ta;
	}
	
	
	/**
	 * Experiment 5: Sort top N cities based on no of accidents occurred
	 * @param N
	 */
	
	public static ArrayList<CasesByCities> TopNCitiesWithAccidentsQueue(int N)
	{
		ArrayList<CasesByCities> topN = new ArrayList<CasesByCities>();
		ArrayList<String> RDArr=new ArrayList<String>();
		ArrayList<CasesByCities> topCasesByCity = new ArrayList<CasesByCities>();
		
		
		Collections.sort((List<TrafficAccident>)TrafficDataQueue,new TrafficAccidentComparator());
		
		String city;
		Stream<String> rd_stream;
		TrafficAccident tr;
		
		Iterator<TrafficAccident> it = TrafficDataQueue.iterator();
		TrafficAccident e2db;
		city = TrafficDataQueue.peek().getCity();
		System.out.println(city);
		while(it.hasNext())
		{
			e2db = it.next();
			if(e2db.getCity().equals(city)) {
				RDArr.add(e2db.getRD_NO());
			}
			else {
				ArrayList uniqueList = (ArrayList) RDArr.stream().distinct().collect(Collectors.toList());
				CasesByCities obj = new CasesByCities(city,uniqueList,uniqueList.size());
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
	 * Insert into Queue from Excel Data
	 */
	
	public static void InsertIntoQueueMain() {
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
	            TrafficDataQueue.add(t);

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
