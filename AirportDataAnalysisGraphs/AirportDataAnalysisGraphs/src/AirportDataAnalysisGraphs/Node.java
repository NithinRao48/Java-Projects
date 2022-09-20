package AirportDataAnalysisGraphs;

/**
 * Node.java Represents each Node of the graph having source and destination airport id and the edge connecting them
 * @author nsrao
 */
public class Node  {
	/**
	 * Source airport id
	 */
	public String source = null;
	
	/**
	 * Destination airpot id
	 */
	public String dest = null;
	
	/**
	 * Edge details between the two airports
	 */
	public TravelDetails edge = null;
	
    

	/**
	 * Parameterized constructor to create a node
	 * @param v1 source airport
	 * @param v2 destination airport
	 * @param edge Travel Details between airport
	 */
    public Node(String v1, String v2, TravelDetails edge) {
    	this.source = v1;
        this.dest = v2;
        this.edge = edge;
	}   
}