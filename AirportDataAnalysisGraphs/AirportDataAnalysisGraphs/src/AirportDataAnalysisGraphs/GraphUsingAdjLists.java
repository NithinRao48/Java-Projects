package AirportDataAnalysisGraphs;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * GraphUsingAdjLists.java Implementing Graph using adjacency List with all the necessary operations
 * @author nsrao
 */
public class GraphUsingAdjLists{
	/**
	 * HashMap to store the Graph Connections
	 */
	Map < String, List<Node>>  G = null;

	/**
	 * Constructor to create a new HashMap
	 */
	public GraphUsingAdjLists()
	{
		G = new HashMap<>();
	}
	
	/**
	 * Function to add each edge to its respective vertices in the graph
	 * @param v1 source airport ID
	 * @param v2 destination airport id
	 * @param edge edge with information about the connection between source and dest airport
	 */
	public void addEdge (String v1, String v2, TravelDetails edge) {
		if ( !G.containsKey(v1)) {
			G.put(v1, new LinkedList<>());
		}
		G.get(v1).add(new Node(v1,v2,edge));
	}
	
	
	/**
	 * Function to check if there two vertices are neighbors
	 * @param a1 source vertex
	 * @param a2 destination vertex
	 * @return true/false 
	 */
	public boolean areAdjacent ( String a1, String a2)
	{
		var wrapper = new Object () {
			boolean i=false;
		};
		G.get(a1).forEach(x -> {
			
			if (x.source.equals(a1) && x.dest.equals(a2)) 
			{
				wrapper.i=true;
			};
			
		});
		return wrapper.i;
		
	}
	
	/**
	 * Function to show all the vertices that are connected from this vertex
	 * @param a1 source vertex
	 * @return ArrayList of vertices
	 */
	public ArrayList<String> outDegree ( String a1)
	{
		var wrapper = new Object () {
			ArrayList<String> airports = new ArrayList<String>();
		};
		G.get(a1).forEach(x -> wrapper.airports.add(x.dest));
		//wrapper.airports.stream().distinct().forEach(x -> System.out.println(x));
		return wrapper.airports;
		
	}
	
	/**
	 * Function to show all the vertices that are connected to this vertex
	 * @param a1 destination vertex
	 * @return ArrayList of vertices
	 */
	public ArrayList<String> inDegree (String a1)
	{
		var wrapper = new Object () {
			ArrayList<String> airports = new ArrayList<String>();
		};
		for (String k : G.keySet()) {
			G.get(k).forEach(x -> {
				if (x.dest.equals(a1))
				{
					wrapper.airports.add(x.source);
				}
			});
		}
		// wrapper.airports.stream().distinct().forEach(x -> System.out.println(x));
		return wrapper.airports;
	}
	
	/**
	 * Function to return all the outgoing edges information from the source vertex
	 * @param a1 source vertex
	 * @return ArrayList<Edges> outgoing from the source vertex
	 */
	public ArrayList<TravelDetails> outgoingEdges (String a1)
	{
		var wrapper = new Object() {ArrayList<TravelDetails> edges = new ArrayList<TravelDetails>();};
		G.get(a1).forEach(x -> {
			wrapper.edges.add( x.edge);
		});
		return wrapper.edges;
	}
	
	/**
	 * Function to return all the incoming edges information to the source vertex
	 * @param a1 destination vertex
	 * @return ArrayList<Edges> incoming to the source vertex
	 */
	public ArrayList<TravelDetails> incomingEdges (String a1)
	{
		var wrapper = new Object() {ArrayList<TravelDetails> edges = new ArrayList<TravelDetails>();};
		for (String k : G.keySet()) {
			G.get(k).forEach(x -> {
				if (x.dest.equals(a1))
				{
					wrapper.edges.add(x.edge);
				}
			});
		}
		return wrapper.edges;
	}
}
