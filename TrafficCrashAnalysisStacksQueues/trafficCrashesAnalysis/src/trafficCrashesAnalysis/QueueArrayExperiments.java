package trafficCrashesAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * QueueArrayExperiments.java - Run all the 5 Experiments using Custom Queue Using Array
 * @author nsrao
 */

public class QueueArrayExperiments {

	public static ArrayQueue TrafficDataQueueArray = new ArrayQueue(400000);
	
	/**
	 * Experiment 1.1: Search Accident History of Vehicle using Vehicle ID Vehicle ID
	 * @param vehicleID
	 */
	
	public static void SearchAccidentHistoryVehicleIDQueueArray( String vehicleID)
	{
		int i=0;
		TrafficAccident X;
		long startTime = System.nanoTime();
		
		
		while (i<TrafficDataQueueArray.size())
		{
			X=TrafficDataQueueArray.getQueue()[i];
			if(X.getVehicleId().equals(vehicleID))
			{
				X.printInfo();
			}
			i++;
		}
		long endTime = System.nanoTime();

		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
	}
	
	/**
	 * Experiment 1.2: Binary Search Accident History of Vehicle using Vehicle ID
	 * @param vehicleId
	 */
	
	public static void BinarySearchAccidentHistoryVehicleIDQueueArray(String vehicleId)
    {
    	long startTime = System.nanoTime();
    	TrafficDataQueueArray.TrafficAccidentSort();
		int index = TrafficDataQueueArray.binarySearchByVehicleId(vehicleId,new TrafficAccidentVehicleIdComparator());
		TrafficDataQueueArray.get(index).printInfo();
		long endTime = System.nanoTime(); // get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime; System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
	
	/**
	 * Experiment 2 : Search Victims by Person ID
	 * @param pid
	 */
	
	public static void SearchVictimsByPersonIdQueueArray( String pid)
	{
		int i=0;
		TrafficAccident X;
		long startTime = System.nanoTime();
		
		
		while (i<TrafficDataQueueArray.size())
		{
			X=TrafficDataQueueArray.getQueue()[i];
			if(X.getPersonID().equals(pid))
			{
				X.printInfo();
			}
			i++;
		}
		long endTime = System.nanoTime();

		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
	}
	
	/**
	 * Experiment 3: Search Victims by RD Number
	 * @param rdNO
	 */
	
	public static void SearchVictimsByRdNoQueueArray( String rdNO)
	{
		int i=0;
		TrafficAccident X;
		long startTime = System.nanoTime();
		
		
		while (i<TrafficDataQueueArray.size())
		{
			X=TrafficDataQueueArray.getQueue()[i];
			if(X.getRD_NO().equals(rdNO))
			{
				X.printInfo();
			}
			i++;
		}
		long endTime = System.nanoTime();

		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
	}
	
	/**
	 * Experiment 4: Search count of accidents on particular date
	 * @param date
	 */
	
	public static void SearchCountofCasesByDateQueueArray(String date)
	{
		int i=0;
		TrafficAccident X;
		long startTime = System.nanoTime();
		ArrayList<String> AccidentList = new ArrayList<String>();
		
		while(i<TrafficDataQueueArray.size())
		{
			X=TrafficDataQueueArray.getQueue()[i];
			if(X.getCrashDate().equals(date))
			{
				AccidentList.add(X.getRD_NO());
			}
			i++;
		}
		
		ArrayList uniqueRdNo = (ArrayList) AccidentList.stream().distinct().collect(Collectors.toList());
		System.out.println("Count of cases on this day is:"+uniqueRdNo.size());
		System.out.print("The cases are:");
		uniqueRdNo.forEach(ele -> System.out.print(ele+"\t"));
		long endTime = System.nanoTime();
		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;

		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
	}
	
	/**
	 * Experiment 5: Sort top N cities based on no of accidents occurred
	 * @param N
	 */
	
	public static void TopNCitiesWithAccidentsQueueArray(int N)
	{
		
		ArrayList<String> RDArr=new ArrayList<String>();
		ArrayList<CasesByCities> topCasesByCity = new ArrayList<CasesByCities>();
		TrafficAccident[] ta = TrafficDataQueueArray.TrafficAccidentSortCity();
		int i=0;
		String city;
		city = ta[0].getCity();
		while(i<TrafficDataQueueArray.size())
		{
			if(city.equals(ta[i].getCity()))
			{
				RDArr.add(ta[i].getRD_NO());
			}
			else {
				ArrayList uniqueList = (ArrayList) RDArr.stream().distinct().collect(Collectors.toList());
				CasesByCities obj = new CasesByCities(city,uniqueList,uniqueList.size());
				topCasesByCity.add(obj);
				RDArr.clear();
				city = ta[i].getCity();
				RDArr.add(ta[i].getRD_NO());
			}
			i++;
		}
		Comparator<CasesByCities> c = new Comparator<CasesByCities>() {
		      public int compare(CasesByCities u1, CasesByCities u2) {
		        return u2.getCount()- u1.getCount();
		      }
		};
		Collections.sort(topCasesByCity,c);
		
		for(int x=0;x<N;x++)
		{
			topCasesByCity.get(x).printinfo();
		}
		
	}
	
	/**
	 * Insert into Queue array from Excel Data
	 */
	
	public static void InsertIntoQueueArray() {
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
	            TrafficDataQueueArray.queueEnqueue(t);				
	        }          
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
