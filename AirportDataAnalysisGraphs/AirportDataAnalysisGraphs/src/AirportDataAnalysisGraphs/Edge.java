package AirportDataAnalysisGraphs;

import java.util.ArrayList;

/**
 * @author Pawan
 * Edge: represents the connection between two vertices
 * @param <T> Weight type
 * @param <V> Information type
 */

public class Edge<T, V> {
    /**
     * Initial point
     */
    private final int tailIndex;

    /**
     * End point
     */
    private final int headIndex;

    /**
     * For un-weighted graph it is boolean true or false
     * For the weighted graph, it is the weight.
     */
    private Object weight;
    
    /**
     * Array of weights 
     */
    public ArrayList<Object> weights=new ArrayList<>();

    /**
     * info Indicates the information carried by the edge
     */
    private T info;
    
    /**
     * Parameterized constructor
     * @param tailIndex
     * @param headIndex
     * @param weight
     * @param info
     */
    public Edge(int tailIndex, int headIndex, Object weight, T info) {
        this.tailIndex = tailIndex;
        this.headIndex = headIndex;
        this.weight = weight;
        this.info = info;
        this.weights.add(weight);
    }

    /**
     * gets the tail index of the edge
     * @return the tail index
     */
    public int getTailIndex() {
        return tailIndex;
    }

    /**
     * gets the head index of the edge
     * @return the head index
     */
    public int getHeadIndex() {
        return headIndex;
    }


    /**
     * gets the tail index of the edge
     * @return the tail index
     */
    @SuppressWarnings("unchecked")
    public T getWeight() {
        return (T) weight;
    }

    /**
     * sets the weight for an edge
     * @param weight of the edge
     */
    public void setWeight(Object weight) {
        this.weight = weight;
    }

    /**
     * returns edge info
     * @return edge info
     */
    public T getInfo() {
        return info;
    }

    /**
     * sets info for the edge
     * @param info information for the edge
     */
    public void setInfo(T info) {
        this.info = info;
    }
}