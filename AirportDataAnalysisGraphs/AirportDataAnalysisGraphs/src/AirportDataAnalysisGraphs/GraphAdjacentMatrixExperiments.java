package AirportDataAnalysisGraphs;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * GraphAdjacentMatrixExperiments.java represents the set of experiments performed by graphs using adjacency marix
 * @author Pawan
 *
 */
public class GraphAdjacentMatrixExperiments {
	
	AdjacencyMatrixGraph<String, String, TravelDetails> graph = new AdjacencyMatrixGraph<>();
	
	/**
	* Experiment 1 : Checking if two airports are connected
	* @param a1 source airport id
	* @param a2 destination airport id
	* @return True Or false
	*/
	public boolean isConnected (String a1, String a2)
	{
		return graph.areAdjacent(graph.findVertex(a1), graph.findVertex(a2));
	}
	
	/**
	* Experiment 2 : Getting Total No of Airports that are connected from this airport
	* @param a1 source airport id
	* @return ArrayList of Airport id
	*/
	public ArrayList<String> getNoOfAirportsConnectedFrom (String a1)
	{
		return graph.getOutAdjacentVertexes(graph.findVertex(a1)); 
	}
	
	/**
	* Experiment 3 : Getting Total No of Airports that are connected To this airport
	* @param a1 source airport id
	* @return ArrayList of Airport id
	*/
	public ArrayList<String> getNoOfAirportsConnectedTo (String a1)
	{
		return graph.getInAdjacentVertexes(graph.findVertex(a1));
	}
	
	/**
	* Experiment 4 : Getting Total No of flights that flew from source airport to all other airport from 2008-2009
	* @param a1 source airport id
	* @return count of flights
	*/
	public int getTotaNoOfFlightsFlyingFrom(String a1)
	{
		var wrapper = new Object() {
    		int tot_flights=0;
    	};
    	graph.getOutEdges(graph.findVertex(a1)).forEach(x->{
    		x.weights.forEach(ele->{
    			System.out.println("->"+((TravelDetails)ele).num_flights);
    			wrapper.tot_flights+=((TravelDetails)ele).num_flights;
    		});
    	});
    	return wrapper.tot_flights;
	}
	
	/**
	* Experiment 5 : Getting Total No of flights that flew to this destination airport from all other airport from 2008-2009
	* @param a1 destination airport id
	* @return count of flights
	*/
	public int getTotaNoOfFlightsFlyingTo(String a1)
	{
		var wrapper = new Object() {
    		int tot_flights=0;
    	};
    	graph.getInEdges(graph.findVertex(a1)).forEach(x->{
    		x.weights.forEach(ele->{
    			wrapper.tot_flights+=((TravelDetails)ele).num_flights;
    		});
    	});
    	return wrapper.tot_flights;
	}
	
	/**
	* Experiment 6 : Getting Total No of Passengers that flew to this destination airport from all other airport from 2008-2009
	* @param a1 destination airport id
	* @return count of passengers
	*/
	public int getTotaNoOfPassengersFlyingTo(String a1)
	{
		var wrapper = new Object() {
    		int tot_flights=0;
    	};
    	graph.getInEdges(graph.findVertex(a1)).forEach(x->{
    		x.weights.forEach(ele->{
    			wrapper.tot_flights+=((TravelDetails)ele).num_passenger;
    		});
    	});
    	return wrapper.tot_flights;
	}
	
	/**
	* Experiment 7 : Getting Total No of passengers that flew from source airport to all other airport from 2008-2009
	* @param a1 source airport id
	* @return count of flights
	*/
	public int getTotaNoOfPassengersFlyingFrom(String a1)
	{
		var wrapper = new Object() {
    		int tot_flights=0;
    	};
    	graph.getOutEdges(graph.findVertex(a1)).forEach(x->{
    		x.weights.forEach(ele->{
    			wrapper.tot_flights+=((TravelDetails)ele).num_passenger;
    		});
    	});
    	return wrapper.tot_flights;
	}

	/**
	* Insert the airports data into the graph built by adjacency list.
	*/
	public void insertIntoGraph()
	{
		String csvFilePath = "./src/Airports2.csv";
    	BufferedReader lineReader;
    	Map<String, TravelDetails> tm = new HashMap<String,TravelDetails>();
    	

    	try {
	    	lineReader = new BufferedReader(new FileReader(csvFilePath));
	    	String lineText = null;
	    	lineReader.readLine(); // skip header line
	    	int i=0;
	    	while ((lineText = lineReader.readLine()) != null) {
		    	String[] data = lineText.split(",");
		    	String org_airport_id = data[0];
		    	String dest_airport_id = data[1];
		    	int passengers = Integer.parseInt(data[6]);
		    	int seats=Integer.parseInt(data[7]);;
		    	int flights=Integer.parseInt(data[8]);;
		    	int distance=Integer.parseInt(data[9]);;
		    	String date = data[10];

		    	graph.addVertex(org_airport_id);
		    	graph.addVertex(dest_airport_id);
		    	
		    	graph.addEdgeByIndex(graph.findVertex(org_airport_id), graph.findVertex(dest_airport_id),new TravelDetails (distance, passengers, seats, flights,date),null);
	    	}
    	}
    	catch (FileNotFoundException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		System.err.println(e);
    	} catch (IOException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    		System.err.println(e);
    	}
    }
	
    public static void main(String[] args) {
    	GraphAdjacentMatrixExperiments g = new GraphAdjacentMatrixExperiments();
    	g.insertIntoGraph();
    	System.out.println(g.getTotaNoOfPassengersFlyingFrom("RDM"));
    }
}