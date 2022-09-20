package TrafficCrashAnalysisMaps;

import java.util.ArrayList;

/**
 * HashMapExperiments.java Run all the Five Experiments using Hash Map data structure from HashMap.java class
 * @author nsrao
 */
public class HashMapExperiments {
	
	/**
	 * Experiment 1: Search Accident History of Vehicle using Vehicle ID
	 * @param hashMap Hashmap containing key as vehicle ID and values as list of traffic accidents
	 * @param vid vehicle id to be searched 
	 * @return List of Traffic Accident related to this Vehicle ID
	 */
	public  ArrayList<TrafficAccident> SearchAccidentHistoryVehicleID(HashMap hashMap,String vid)
	{
		ArrayList<TrafficAccident> ta = hashMap.hashMapVId.get(vid);
		return ta;
	}
	
	/**
	 * Experiment 2: Search Victims by RD Number
	 * @param hashMap Hashmap containing key as RD Number and values as list of traffic accidents
	 * @param rdNO RD_Number of the accident 
	 * @return List of Traffic Accident related to this RD Number
	 */
	
	public ArrayList<TrafficAccident> searchByRdNo(HashMap hashMap,String rdNO)
	{
		ArrayList<TrafficAccident> ta = hashMap.hashMapRdNo.get(rdNO);
		return ta;
	}
	
	/**
	 * Experiment 3 : Search Victims by Person ID
	 * @param hashMap Hashmap containing key as personID and values as list of traffic accidents
	 * @param pid person ID of the victim
	 * @return List of Traffic Accident related to this person ID
	 */
	public ArrayList<TrafficAccident> searchByPersonId(HashMap hashMap,String pid)
	{
		ArrayList<TrafficAccident> ta = hashMap.hashMapPId.get(pid);
		return ta;
	}
	
	/**
	 * Experiment 4 : Analyze accident count in each month from 2013-2019
	 * @param hashMap Hashmap containing key as crashDate and values as list of traffic accidents
	 * @param Month Month to be analyzed
	 * @return List of Traffic Accident related to this month and year
	 */
	public ArrayList<Node<String,TrafficAccident>> CountByDate(HashMap hashMap,String Month)
	{
		ArrayList<Node<String,TrafficAccident>>  ta = new ArrayList<>();
		int startYear = 2014;
		for (int i=0;i<6;i++)
		{
			String mon = Month +"-" + startYear;
			ta.add(hashMap.hashMapmmYY.getLong(mon));
			startYear++;
		}
		return ta;
	}
	
	
	/**
	 * Experiment 4 : Get Count of accidents occurring in each city
	 * @param hashMap Hashmap containing key as city name and values as list of traffic accidents
	 * @param city city of which accident count is needed
	 * @return Node containing City name and Corresponding TrafficAccident
	 */
	
	public Node<String,TrafficAccident> CountByCity(HashMap hashMap,String city)
	{
		Node<String,TrafficAccident> node = hashMap.hashMapCity.getLong(city);
		return node;
	}
	
	
}
