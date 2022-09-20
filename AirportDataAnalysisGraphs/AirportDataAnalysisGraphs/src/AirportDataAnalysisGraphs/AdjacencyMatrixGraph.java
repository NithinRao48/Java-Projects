package AirportDataAnalysisGraphs;

import java.util.*;

/**
 * AdjacencyMatrixGraph.java Implementing graphs using adjacency matrix with its operations
 * @author Pawan
 *
 * @param <E> vertex of graph
 * @param <T> weight of graph
 * @param <V> edge of graph
 */
public class AdjacencyMatrixGraph<E, T, V> {
    /**
     * adjacency matrix 
     */
    private List<List<Edge<T, V>>> adjacencyMatrix = null;
    /**
     * Vertex vector
     */
    private List<E> vertexes = null;
    /**
     * Current vertex number
     */
    private int vertexNum;
    /**
     * Current edge number
     */
    private int edgeNum;
    
    /**
     * Parameterised constructor for type of graph initialisation
     * @param typeOfGraph type of graph if directed or undirected.
     */
    public AdjacencyMatrixGraph() {
        vertexes = new ArrayList<>();
        this.adjacencyMatrix = createAdjacentMatrix(null, 0);
    }


    /**
     * number of increasing edges
     *
     * @param tailIndex Starting point of a edge
     * @param headIndex End point of a edge
     */
    private void growEdgeNum(int tailIndex, int headIndex) {
        ValidateIndex(tailIndex);
        ValidateIndex(headIndex);
        if (adjacencyMatrix.get(tailIndex).get(headIndex) == null)
            ++edgeNum;
    }

    /**
     * The adjacency matrix is generated using the list of parameters.
     *
     * @param edges list of edges
     * @param order  number of vertices
     * @param graphKind type of graph
     * @return adjacency matrix 
     */
    private List<List<Edge<T, V>>> createAdjacentMatrix(List<Edge<T, V>> edges, int order) 
    {     
        List<List<Edge<T, V>>> adjacencyMatrix = new ArrayList<>();
        for (int i = 0; i < order; i++) {
            List<Edge<T, V>> vector = new ArrayList<>();
            for (int j = 0; j < order; j++)
                vector.add(null);
            adjacencyMatrix.add(vector);
        }
        
        if (edges != null) {
        	edges.forEach(edge -> {
                int tailIndex = edge.getTailIndex();
                int headIndex = edge.getHeadIndex();
                growEdgeNum(tailIndex, headIndex);
                adjacencyMatrix.get(tailIndex).set(headIndex, edge);
            });
        }
        return adjacencyMatrix;
    }

    /**
     * Validate vertex index
     * Throw runtime exception out of bounds
     *
     * @param index Vertex index value
     */
    private void ValidateIndex(int index) {
        if (index < 0 || index > vertexNum - 1)
            throw new IndexOutOfBoundsException("Vertex subscript must<" + (vertexNum - 1) + "also>=0!");
    }

    /**
     * Gets the index of a vertex
     *
     * @param vertex vertex of graph
     * @return Index value of vertex
     */
    
    public int findVertex(E vertex) {
        return vertexes.indexOf(vertex);
    }

    /**
     * Adds a vertex to the list of vertices
     * @param vertex
     * @return true on successful insertion, false if not inserted
     */
    public boolean addVertex(E vertex) {
    	var wrapper = new Object(){ boolean flag=false; };
    	
    	vertexes.forEach(ele-> {
    		if(ele.equals(vertex)) {
    			wrapper.flag=true;
    		}
    	});
    	if(wrapper.flag!=true)
    	{
    		vertexes.add(vertex);
    		List<Edge<T, V>> vector = new ArrayList<>();
            //Cycle old VertexNum times
            adjacencyMatrix.forEach(edges -> {
                edges.add(null);
                //Reuse loops to reduce time complexity
                vector.add(null);
            });
            vector.add(null);
            adjacencyMatrix.add(vector);
            ++vertexNum;
            return true;
    	}
		return false;
        
    }
    
   /**
    * Add edge between 2 vertex indices
    * @param index1 index of first vertex
    * @param index2 index of second vertex
    * @return edge between two vertices.
    */
    
    public Edge<T, V> addEdgeByIndex(int index1, int index2) {
        return addEdgeByIndex(index1, index2, null, null);
    }

    /**
     *  Add edge between 2 vertex indices
     * @param index1 index of first vertex
     * @param index2 index of second vertex
     * @param weight weight of the edge
     * @param info information about the edge
     * @return edge between 2 vertices.
     */
    
    public Edge<T, V> addEdgeByIndex(int index1, int index2, V weight, T info) {
        growEdgeNum(index1, index2);
        Edge<T, V> edge,ret;

        edge = new Edge<>(index1, index2, weight, info);

        if(adjacencyMatrix.get(index1).get(index2)==null)
    		ret = adjacencyMatrix.get(index1).set(index2,edge);
    	else
    	{
    		ret = adjacencyMatrix.get(index1).get(index2);
    		adjacencyMatrix.get(index1).get(index2).weights.add(weight);
    	}
    		
        return ret;
    }

    /**
     * checks if there is a edge between two vertices.
     * @param index1 index of vertex 1
     * @param index2 index of vertex 2
     * @return true if edge exists else false.
     */
    public boolean hasEdge(int index1, int index2) {
        return getEdge(index1, index2) != null;
    }

    /**
     * Retrieves edge details between 2 vertices. 
     * @param index1 index of vertex 1
     * @param index2 index of vertex 2
     * @return edge details
     */
    public Edge<T, V> getEdge(int index1, int index2) {
        ValidateIndex(index1);
        ValidateIndex(index2);
        return adjacencyMatrix.get(index1).get(index2);
    }

    /**
     * Retrieves incoming edges to the vertex
     * @param index index of the vertex
     * @return set of edges that are connected to the given vertex.
     */
    public Set<Edge<T, V>> getInEdges(int index) {
        ValidateIndex(index);
        Set<Edge<T, V>> edges = new HashSet<>();
        adjacencyMatrix.forEach(vector -> {
            Edge<T, V> edge = vector.get(index);
            if (edge != null)
                edges.add(edge);
        });
        return edges;
    }

    /**
     * Retrieves outgoing edges from the vertex
     * @param index index of the vertex
     * @return set of edge going from the vertex.
     */
    public Set<Edge<T, V>> getOutEdges(int index) {
        ValidateIndex(index);
        Set<Edge<T, V>> edges = new HashSet<>();
        adjacencyMatrix.get(index).forEach(edge -> {
            if (edge != null)
                edges.add(edge);
        });
        return edges;
    }


    /**
     * Gives in-degree of the vertex.
     * @param index index of the vertex
     * @return returns the integer value representing the in-degree
     */
    public int getInDegree(int index) {
        ValidateIndex(index);
        return (int) adjacencyMatrix.stream().filter(vector -> vector.get(index) != null).count();
    }

    /**
     * Gives out-degree of the vertex.
     * @param index index of the vertex
     * @return returns the integer value representing the out-degree.
     */
    public int getOutDegree(int index) {
        ValidateIndex(index);
        return (int) adjacencyMatrix.get(index).stream().filter(Objects::nonNull).count();
    }

    /**
     * Gives degree of the vertex.
     * @param index index of the vertex
     * @return returns the integer value representing the degree.
     */
    public int getDegree(int index) {
        int degree = getOutDegree(index);
        degree += (int) adjacencyMatrix.stream().filter(vector -> vector.get(index) != null).count();
        if (hasEdge(index, index))
            return degree - 1;
        return degree;
    }

    /**
     * checks if graph is empty or not.
     * @return true if empty else false.
     */
    public boolean isEmptyGraph() {
        return vertexNum == 0;
    }
    
    /**
     * Get the adjacent vertex indexes
     * @param index index of the vertex.
     * @return set of adjacent vertices to the vertex.
     */
    public Set<Integer> getAdjacentVertexIndexes(int index) {
        ValidateIndex(index);
        Set<Integer> vertexIndexes = new HashSet<>();
        for (int i = 0; i < this.vertexes.size(); i++) {
            if (index == i)
                continue;
            if (adjacencyMatrix.get(index).get(i) != null)
                vertexIndexes.add(i);
            if (adjacencyMatrix.get(i).get(index) != null)
                vertexIndexes.add(i);
        }
        return vertexIndexes;
    }

    /**
     * get the vertex index of the outgoing edges.
     * @param index of the vertex
     * @return set of indices of the outgoing vertices.
     */
    public Set<Integer> getOutAdjacentVertexIndexes(int index) {
    	ValidateIndex(index);
        Set<Integer> vertexIndexes = new HashSet<>();
        for (int i = 0; i < this.vertexes.size(); i++)
            if (index != i && adjacencyMatrix.get(index).get(i) != null)
                vertexIndexes.add(i);
        return vertexIndexes;
    }
    
    /**
     * get the outgoing adjacent vertices
     * @param index index of the vertex
     * @return list of vertex
     */
    public ArrayList<E> getOutAdjacentVertexes(int index) {
    	ValidateIndex(index);
        ArrayList<E> vertexes = new ArrayList<>();
        for (int i = 0; i < this.vertexes.size(); i++)
            if (index != i && adjacencyMatrix.get(index).get(i) != null)
                vertexes.add(this.vertexes.get(i));
        return vertexes;
    }
    
    /**
     * get the adjacent vertices
     * @param index index of the vertex
     * @return list of vertex
     */
    public ArrayList<E> getAdjacentVertexes(int index) {
        ValidateIndex(index);
        ArrayList<E> vertexes = new ArrayList<>();
        for (int i = 0; i < this.vertexes.size(); i++) {
            if (index == i)
                continue;
            if (adjacencyMatrix.get(index).get(i) != null)
                vertexes.add(this.vertexes.get(i));
            if (adjacencyMatrix.get(i).get(index) != null)
                vertexes.add(this.vertexes.get(i));
        }
        return vertexes;
    }
    
    /**
     * Checks if it is connected via DFS traversal
     * @param visited array of visited flags to each vertex
     * @param v index of vertex
     * @param flag
     */
    private void isConnectedByDFS(int[] visited, int v, int flag) {
        visited[v] = flag;
        getOutAdjacentVertexIndexes(v).forEach(index -> {
            if (visited[index] == 0)
                isConnectedByDFS(visited, index, flag);
        });
    }


    /**
     * checks if 2 vertex are connected
     * @param index1 index of vertex1
     * @param index2 index of vertex 2
     * @return true if connected else false
     */
    
    public boolean areAdjacent(int index1, int index2) {
        //rangeCheck(index1);
        //rangeCheck(index2);
        if (index1 == index2)
            return adjacencyMatrix.get(index1).get(index1) != null;
        int[] visited = new int[vertexNum];
        for (int i = index1, flag = 1; i < vertexNum; i++)
            if (visited[i] == 0) {
                isConnectedByDFS(visited, i, flag);
                flag++;
            }
        return visited[index1] == visited[index2];
    }
    
    /**
     * Gets adjacent incoming edges
     * @param index index of the vertex
     * @return list of incoming vertices
     */
    public ArrayList<E> getInAdjacentVertexes(int index) {
    	ValidateIndex(index);
        ArrayList<E> vertexes = new ArrayList<>();
        for (int i = 0; i < this.vertexes.size(); i++)
            if (index != i && adjacencyMatrix.get(i).get(index) != null)
                vertexes.add(this.vertexes.get(i));
        return vertexes;
    }

    /**
     * gets index of incoming edge vertices
     * @param index index of the vertex
     * @return set of index of incoming vertices
     */
    public Set<Integer> getInAdjacentVertexIndexes(int index) {
    	 ValidateIndex(index);
         Set<Integer> vertexIndexes = new HashSet<>();
         for (int i = 0; i < this.vertexes.size(); i++)
             if (index != i && adjacencyMatrix.get(i).get(index) != null)
                 vertexIndexes.add(i);
         return vertexIndexes;
    }
}
