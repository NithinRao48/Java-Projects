package AirportDataAnalysisGraphs;

/**
 * Vertex.java represents the vertex of graph
 * @author Pawan
 *
 * @param <E> type of vertex
 */
public class Vertex<E> {

	/**
	 * Value of vertex
	 */
    private E value;

    /**
     * Parameterized constructor 
     * @param value value of vertex
     */
    public Vertex(E value) {
        this.value = value;
    }
}