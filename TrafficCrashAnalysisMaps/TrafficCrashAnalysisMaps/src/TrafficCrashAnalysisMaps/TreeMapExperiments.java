package TrafficCrashAnalysisMaps;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;


/**
 * TreeMapExperiments.java Run all the Five Experiments using Tree Map data structure from Collection
 * @author nsrao
 */
public class TreeMapExperiments  extends TrafficAccident{
	
	/**
     * Treemap containing Vehicle ID as key and the corresponding Traffic accident as values
     */
	TreeMap<String, ArrayList<TrafficAccident>> tmVid = new TreeMap<String, ArrayList<TrafficAccident>>();
	
	/**
     * Treemap containing RD_Number ID as key and the corresponding Traffic accident as values
     */
	TreeMap<String, ArrayList<TrafficAccident>> tmRdNo = new TreeMap<String, ArrayList<TrafficAccident>>();
	
	/**
     * Treemap containing Person ID as key and the corresponding Traffic accident as values
     */
	TreeMap<String, ArrayList<TrafficAccident>> tmPid = new TreeMap<String, ArrayList<TrafficAccident>>();
	
	/**
     * Treemap containing City as key and the corresponding Traffic accident as values
     */
	TreeMap<String, ArrayList<TrafficAccident>> tmCity = new TreeMap<String, ArrayList<TrafficAccident>>();
	
	/**
     * Treemap containing CrashDate(MM-YY) as key and the corresponding Traffic accident as values
     */
	TreeMap<String, ArrayList<TrafficAccident>> tmDate = new TreeMap<String, ArrayList<TrafficAccident>>();
	
	/**
	 * Experiment 1: Search Accident History of Vehicle using Vehicle ID
	 * @param vehicleID vehicle ID to be searched
	 * @return  List of Traffic Accident related to this Vehicle ID
	 */
	public ArrayList<TrafficAccident> SearchAccidentHistoryVehicleID( String VehicleId) 
	{	
	      return tmVid.get(VehicleId);	    
	}
	
	/**
	 * Experiment 2: Search Victims by RD Number
	 * @param rdNO RD_Number of the accident 
	 * @return List of Victims involved in the accident 
	 */
	
	public ArrayList<TrafficAccident> SearchVictimsByRdNo( String rdNO)
	{
	      return tmRdNo.get(rdNO);
	}
	
	/**
	 * Experiment 3 : Search Victims by Person ID
	 * @param pid person ID of the victim
	 * @return list of traffic accident in which the person id is involved
	 */
	
	public ArrayList<TrafficAccident> SearchVictimsByPersonId (String pid)
	{
        return tmPid.get(pid);
	}
	 
	/**
	 * Experiment 4 : Analyze accident count in each month from 2013-2019
	 * @param Month Month to be analyzed
	 * @return Tree Map with keys as MM-YY (where YY will range between 2013 - 2019)
	 */
	public TreeMap<String, Integer> SearchMonthWiseAccidentCount (String Month)
	{
		  TreeMap<String,Integer> tm = new TreeMap<>();
	      int startYear = 2014;
	      for (int i=0;i<6;i++)
	      {
	    	  String mon = Month +"-" + startYear;
	    	  if(tmDate.get(mon)!=null)
	    	  {
	    		  tm.putIfAbsent(mon,tmDate.get(mon).size()); 
	    	  }
	    	  startYear++;
	      }
	      return tm;
	}
	
	/**
	 * Experiment 4 : Get Count of accidents occurring in each city
	 * @param cityName city of which accident count is needed
	 * @return array list containing details of all the accidents occuring in that city.
	 */
	public ArrayList<TrafficAccident> SearchAccidentCountPerCity (String cityName)
	{
		return tmCity.get(cityName);
	}
	
	/**
	 * Insert into Hash Maps according the experiments with respective key value pairs
	 */
	public void insertIntoTreeMap()
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
	            String[] str = crash_date.split("-");
	            String key_date = str[1]+"-"+str[2];
	            String sex=data[5];
	            String age=data[6];
	            String city=data[7];
	            String zipcode = data[8];
	            TrafficAccident t = new TrafficAccident(person_id,person_type,rd_no,vehicle_id,crash_date,sex,age,city,zipcode);
	            
	            // vehicle id wise insertion
	            if (tmVid.containsKey(vehicle_id))
	            {
	            	tmVid.get(vehicle_id).add(t);
	            }
	            else
	            {
	            	tmVid.computeIfAbsent(vehicle_id,m -> new ArrayList<TrafficAccident>()).add(t);
	            }
	            
	            // person id wise insertion
	            if (tmPid.containsKey(person_id))
	            {
	            	tmPid.get(person_id).add(t);
	            }
	            else
	            {
	            	tmPid.computeIfAbsent(person_id,m -> new ArrayList<TrafficAccident>()).add(t);
	            }
	            
	            // date wise insertion
	            if (tmDate.containsKey(key_date))
	            {
	            	tmDate.get(key_date).add(t);
	            }
	            else
	            {
	            	tmDate.computeIfAbsent(key_date,m -> new ArrayList<TrafficAccident>()).add(t);
	            }
	            
	            // city wise insertion
	            if (tmCity.containsKey(city))
	            {
	            	tmCity.get(city).add(t);
	            }
	            else
	            {
	            	tmCity.computeIfAbsent(city,m -> new ArrayList<TrafficAccident>()).add(t);
	            }
	            
	            // rd no wise insertion
	            if (tmRdNo.containsKey(rd_no))
	            {
	            	tmRdNo.get(rd_no).add(t);
	            }
	            else
	            {
	            	tmRdNo.computeIfAbsent(rd_no,m -> new ArrayList<TrafficAccident>()).add(t);
	            }
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
