package AirportDataAnalysisGraphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * GraphUsingAdjListsExperiments.java Class to execute experiments on Graphs built using Adjacency List
 * @author nsrao
 */
public class GraphAdjListsExperiments {
	
	/**
	 * Creating an instance of graph
	 */
	GraphUsingAdjLists g= new GraphUsingAdjLists();
	
	/**
	 * Experiment 1 : Checking if two airports are connected
	 * @param a1 source airport id
	 * @param a2 destination airport id
	 * @return True Or false
	 */
	public boolean isConnected (String a1, String a2)
	{
		return g.areAdjacent(a1,a2);
	}
	
	
	/**
	 * Experiment 2 : Getting Total No of Airports that are connected from this airport 
	 * @param a1 source airport id
	 * @return ArrayList of Airport id
	 */
	public ArrayList<String> getNoOfAirportsConnectedFrom (String a1)
	{
		return g.outDegree(a1);
	}
	
	/**
	 * Experiment 3 : Getting Total No of Airports that are connected To this airport 
	 * @param a1 source airport id
	 * @return ArrayList of Airport id
	 */
	public ArrayList<String> getNoOfAirportsConnectedTo (String a1)
	{
		return g.inDegree(a1);
	}
	
	
	/**
	 * Experiment 4 : Getting Total No of flights that flew from source airport to all other airport from 2008-2009
	 * @param a1 source airport id
	 * @return count of flights
	 */
	public int getTotaNoOfFlightsFlyingFrom(String a1)
	{
		ArrayList<TravelDetails> edges= new ArrayList<TravelDetails>();
		var wrapper = new Object () {int count=0;};
		edges = g.outgoingEdges(a1);
		edges.forEach(x -> { wrapper.count+=x.num_flights;
		});
		return wrapper.count;
	}
	
	/**
	 * Experiment 5 : Getting Total No of flights that flew to this destination airport from all other airport from 2008-2009
	 * @param a1 destination airport id
	 * @return count of flights
	 */
	public int getTotaNoOfFlightsFlyingTo(String a1)
	{
		ArrayList<TravelDetails> edges= new ArrayList<TravelDetails>();
		var wrapper = new Object () {int count=0;};
		edges = g.incomingEdges(a1);
		edges.forEach(x -> { wrapper.count+=x.num_flights;
		});
		return wrapper.count;
	}
	
	
	/**
	 * Experiment 6 : Getting Total No of Passengers that flew to this destination airport from all other airport from 2008-2009
	 * @param a1 destination airport id
	 * @return count of passengers
	 */
	public int getTotaNoOfPassengersFlyingTo(String a1)
	{
		ArrayList<TravelDetails> edges= new ArrayList<TravelDetails>();
		var wrapper = new Object () {int count=0;};
		edges = g.incomingEdges(a1);
		edges.forEach(x -> { wrapper.count+=x.num_passenger;
		});
		return wrapper.count;
	}
	
	/**
	 * Experiment 7 : Getting Total No of passengers that flew from source airport to all other airport from 2008-2009
	 * @param a1 source airport id
	 * @return count of flights
	 */
	public int getTotaNoOfPassengersFlyingFrom(String a1)
	{
		ArrayList<TravelDetails> edges= new ArrayList<TravelDetails>();
		var wrapper = new Object () {int count=0;};
		edges = g.outgoingEdges(a1);
		edges.forEach(x -> { wrapper.count+=x.num_passenger;
		});
		return wrapper.count;
	}
	
	
	
	/**
	 * Insert the airports data into the graph built by adjacency list.
	 */
	public void insertIntoGraphs ()
	{
		String csvFilePath = "./src/Airports2.csv";
		BufferedReader lineReader;
		try {
			lineReader = new BufferedReader(new FileReader(csvFilePath));
			String lineText = null;
	        lineReader.readLine(); // skip header line
	        while ((lineText = lineReader.readLine()) != null) {
	            String[] data = lineText.split(",");
	            String org_airport_id = data[0];
	            String dest_airport_id = data[1];
	            int passengers = Integer.parseInt(data[6]);
	            int seats=Integer.parseInt(data[7]);;
	            int flights=Integer.parseInt(data[8]);;
	            int distance=Integer.parseInt(data[9]);;
	            String date = data[10];
	            TravelDetails t = new TravelDetails (distance,passengers,seats,flights,date);
	            g.addEdge(org_airport_id, dest_airport_id, t); 
	        }
	        System.out.println("done insertion");
		  
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.err.println(e);
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println(e);
		}
	}
	
	

public static void main(String[] args)
{  
	GraphAdjListsExperiments gExp = new GraphAdjListsExperiments();
	gExp.insertIntoGraphs();
	System.out.print(gExp.getTotaNoOfPassengersFlyingFrom("RDM"));
 
}
}
