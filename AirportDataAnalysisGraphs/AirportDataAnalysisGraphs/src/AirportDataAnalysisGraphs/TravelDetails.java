package AirportDataAnalysisGraphs;

/**
 * TravelDetails.java This class stores the information about the edge connecting two airports
 * @author nsrao
 *
 */
public class TravelDetails {
	/**
	 * Distance between two airports
	 */
	int distance;
	/**
	 * No of passengers that commuted between two airports
	 */
	int num_passenger;
	
	/**
	 * No of seats available in the flights
	 */
	int seating_capacity;
	
	/**
	 * Total number of flights that exist between these two airports
	 */
	int num_flights;
	
	/**
	 * Date of travel
	 */
	String date;
	
	
	/**
	 * Parameterized constructor to create a edge
	 * @param d distance
	 * @param p total number of passengers
	 * @param s total number of seats
	 * @param f no of flights
	 * @param da date
	 */
	public TravelDetails(int d, int p, int s, int f, String da)
	{
		distance = d;
		num_passenger = p;
		seating_capacity = s;
		num_flights = f;
		date = da;
	}
	
}
