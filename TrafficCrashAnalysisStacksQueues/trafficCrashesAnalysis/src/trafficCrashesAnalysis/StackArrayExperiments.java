package trafficCrashesAnalysis;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * StackArrayExperiments.java - Run all the 5 Experiments using Custom Stack Using Array
 * @author nsrao
 */
public class StackArrayExperiments {

	public static ArrayStack<TrafficAccident> TrafficDataStackArray = new ArrayStack<TrafficAccident>(400000);
	
	/**
	 * Experiment 1.1: Search Accident History of Vehicle using Vehicle ID Vehicle ID
	 * @param vehicleID
	 */
	public static void SearchAccidentHistoryVehicleIDStackArray( String vehicleID) 
	{	
		long startTime = System.nanoTime();
		int i=0;
		TrafficAccident ta;
		while(i<TrafficDataStackArray.size())
		{
			ta = TrafficDataStackArray.get(i);
			if(ta.getVehicleId().equals(vehicleID))
			{
				ta.printInfo();
				break;
			}
			i++;
		}
		long endTime = System.nanoTime();

		// get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime;
		System.out.println("size:"+TrafficDataStackArray.size());
		System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
	}
	
	/**
	 * Experiment 1.2: Binary Search Accident History of Vehicle using Vehicle ID
	 * @param vehicleId
	 */
	
	public static void BinarySearchAccidentHistoryVehicleIDStackArray(String vehicleId)
    {
    	long startTime = System.nanoTime();
		TrafficDataStackArray.TrafficAccidentSort();
		int index = TrafficDataStackArray.binarySearchByVehicleId(vehicleId,new TrafficAccidentVehicleIdComparator());
		TrafficDataStackArray.get(index).printInfo();
		long endTime = System.nanoTime(); // get the difference between the two nano time valuess
		long timeElapsed = endTime - startTime; System.out.println("Execution time in nanoseconds: " + timeElapsed);
		System.out.println("Execution time in milliseconds: " + timeElapsed / 1000000);
    }
	
	/**
	 * Experiment 2: Search Victims by RD Number
	 * @param rdNO
	 */
	
	public static void SearchVictimsByRdNoStackArray( String rdNO)
	{
		long startTime = System.nanoTime();
		int i=0;
		TrafficAccident ta;
		while(i<TrafficDataStackArray.size())
		{
			ta = TrafficDataStackArray.get(i);
			if(ta.getRD_NO().equals(rdNO))
			{
				ta.printInfo();
				break;
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
	 * Experiment 3 : Search Victims by Person ID
	 * @param pid
	 */
	
	public static void SearchVictimsByPersonIdStackArray( String pid)
	{
		long startTime = System.nanoTime();
		int i=0;
		TrafficAccident ta;
		while(i<TrafficDataStackArray.size())
		{
			ta = TrafficDataStackArray.get(i);
			if(ta.getPersonID().equals(pid))
			{
				ta.printInfo();
				break;
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
	
	public static void SearchCountofCasesByDateStackArray(String date)
	{
		long startTime = System.nanoTime();
		ArrayList<String> AccidentList = new ArrayList<String>();
		int i=0;
		TrafficAccident ta;
		while(i<TrafficDataStackArray.size())
		{
			ta = TrafficDataStackArray.get(i);
			if(ta.getCrashDate().equals(date))
			{
				AccidentList.add(ta.getRD_NO());
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
	
	public static void TopNCitiesWithAccidentsStackArray(int N)
	{
		
		ArrayList<String> RDArr=new ArrayList<String>();
		ArrayList<CasesByCities> topCasesByCity = new ArrayList<CasesByCities>();
		TrafficAccident[] ta = TrafficDataStackArray.TrafficAccidentSortCity();
		int i=0;
		String city;
		city = ta[0].getCity();
		while(i<TrafficDataStackArray.size())
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
	 * Insert into Stack array from Excel Data
	 */
	
	public static void InsertIntoStackArray() {
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
	            TrafficDataStackArray.push(t);				
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
