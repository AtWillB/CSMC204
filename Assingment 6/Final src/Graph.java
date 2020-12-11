import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;


public class Graph implements GraphInterface<Town, Road>{
	private HashMap<Town, ArrayList<Road>> adjMap;
	private ArrayList<Town> closed, open;
	
	public Graph() {
		adjMap = new HashMap<>();
		closed = new ArrayList<Town>();
		open = new ArrayList<Town>();
	}
	
	
	 /**
     * Returns an edge connecting source vertex to target vertex if such
     * vertices and such edge exist in this graph. Otherwise returns
     * null. If any of the specified vertices is null
     * returns null
     *
     * In undirected graphs, the returned edge may have its source and target
     * vertices in the opposite order.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return an edge connecting source vertex to target vertex.
     */
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		Road answerEdge = null;
		
		if (adjMap.containsKey(sourceVertex) == false || adjMap.containsKey(destinationVertex) == false) {
			return null;
		}
		else if (sourceVertex == null || destinationVertex == null) {
			return null;
		}
		else {
			ArrayList<Road> sourceList = adjMap.get(sourceVertex);
			for(Road r : sourceList) {
				if(r.getDestination().equals(destinationVertex)) {
					answerEdge = r; 
				}
			}
		}
		
		return answerEdge;
		
	}
	
	/**
     * Creates a new edge in this graph, going from the source vertex to the
     * target vertex, and returns the created edge. 
     * 
     * The source and target vertices must already be contained in this
     * graph. If they are not found in graph IllegalArgumentException is
     * thrown.
     *
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description for edge
     *
     * @return The newly created edge if added to the graph, otherwise null.
     *
     * @throws IllegalArgumentException if source or target vertices are not
     * found in the graph.
     * @throws NullPointerException if any of the specified vertices is null.
     */
	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if(sourceVertex == null || destinationVertex == null) {
			throw new NullPointerException();
		}
		
		Road newRoad1 = new Road(sourceVertex, destinationVertex, weight, description);
		Road newRoad2 = new Road(destinationVertex, sourceVertex, weight, description);
		ArrayList<Road> sourceList, destinationList;
		
		if(adjMap.get(sourceVertex) == null) {
			 sourceList = new ArrayList<Road>();
			 sourceList.add(newRoad1);
		}
		else {
			sourceList = adjMap.get(sourceVertex);
			sourceList.add(newRoad1);
		}
		
		if(adjMap.get(destinationVertex) == null) {
			destinationList = new ArrayList<Road>();
			destinationList.add(newRoad2);
		}
		else {
			destinationList = adjMap.get(destinationVertex);
			destinationList.add(newRoad2);
		}
		
		
	
		if(adjMap.keySet().contains(sourceVertex) && adjMap.keySet().contains(destinationVertex)) {
			adjMap.put(sourceVertex, sourceList);
			adjMap.put(destinationVertex, destinationList);
		}
		else if(adjMap.containsKey(sourceVertex) == false || adjMap.containsKey(destinationVertex) == false) {
			throw new IllegalArgumentException();
		}
		
		return newRoad1;
	}

	 /**
     * Adds the specified vertex to this graph if not already present. More
     * formally, adds the specified vertex, v, to this graph if
     * this graph contains no vertex u such that
     * u.equals(v). If this graph already contains such vertex, the call
     * leaves this graph unchanged and returns false. In combination
     * with the restriction on constructors, this ensures that graphs never
     * contain duplicate vertices.
     *
     * @param v vertex to be added to this graph.
     *
     * @return true if this graph did not already contain the specified
     * vertex.
     *
     * @throws NullPointerException if the specified vertex is null.
     */
	@Override
	public boolean addVertex(Town v) {
		if (v == null) {
			throw new NullPointerException();
		}
		
		boolean addedVertex = true;
		if(!adjMap.keySet().contains(v)) {
			adjMap.put(v, null) ;
		}
		else {
			addedVertex = false;
		}
		return addedVertex;
	}

	 /**
     * Returns true if and only if this graph contains an edge going
     * from the source vertex to the target vertex. In undirected graphs the
     * same result is obtained when source and target are inverted. If any of
     * the specified vertices does not exist in the graph, or if is
     * null, returns false.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     *
     * @return true if this graph contains the specified edge.
     */
	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		boolean containsEdge = false;
		
		if (adjMap.containsKey(sourceVertex) == false || adjMap.containsKey(destinationVertex) == false) {
			return containsEdge;
		}
		else if (sourceVertex == null || destinationVertex == null) {
			return containsEdge;
		}
		else {
			ArrayList<Road> sourceList = adjMap.get(sourceVertex);
			for(Road r : sourceList) {
				if(r.getDestination().equals(destinationVertex)) {
					containsEdge = true; 
				}
			}
		}
		
		return containsEdge;
	}
	
	/**
     * Returns true if this graph contains the specified vertex. More
     * formally, returns true if and only if this graph contains a
     * vertex u such that u.equals(v). If the
     * specified vertex is null returns false.
     *
     * @param v vertex whose presence in this graph is to be tested.
     *
     * @return true if this graph contains the specified vertex.
     */
	@Override
	public boolean containsVertex(Town v) {
		boolean containsVertex;
		
		if (adjMap.containsKey(v)) {
			containsVertex = true; 
		}
		else  {
			containsVertex = false;
		}
		return containsVertex;
	}

	/**
     * Returns a set of the edges contained in this graph. The set is backed by
     * the graph, so changes to the graph are reflected in the set. If the graph
     * is modified while an iteration over the set is in progress, the results
     * of the iteration are undefined.
     * @return a set of the edges contained in this graph.
     */
	@Override
	public Set<Road> edgeSet() {
		Set<Road> roadSet = new HashSet<>();
		Collection<ArrayList<Road>> aLCollectionRoad =  adjMap.values();
		
		aLCollectionRoad.removeIf(n -> (n == null));
		
		ArrayList<Road> aLRoadSet = new ArrayList<Road>(); 
		
		
		for (ArrayList<Road> arrayListRoad : aLCollectionRoad) {
			for (Road road : arrayListRoad ) {
				if (!aLRoadSet.contains(road)) {
					aLRoadSet.add(road);
				}
			}
		}
		
		roadSet.addAll(aLRoadSet);
		return roadSet;
	}
	/**
     * Returns a set of all edges touching the specified vertex (also
     * referred to as adjacent vertices). If no edges are
     * touching the specified vertex returns an empty set.
     *
     * @param vertex the vertex for which a set of touching edges is to be
     * returned.
     *
     * @return a set of all edges touching the specified vertex.
     *
     * @throws IllegalArgumentException if vertex is not found in the graph.
     * @throws NullPointerException if vertex is null.
     */
	@Override
	public Set<Road> edgesOf(Town vertex) {
		if (this.containsVertex(vertex) == false) {
			throw new IllegalArgumentException();
		}
		if (vertex == null) {
			throw new NullPointerException();
		}
		
		
		Set<Road> edgesOf = new HashSet<>();
		ArrayList<Road> listOfEdges = adjMap.get(vertex);
		
		for (Road r : listOfEdges) {
			edgesOf.add(r);
		}
		return edgesOf;
	}

	/**
     * Removes an edge going from source vertex to target vertex, if such
     * vertices and such edge exist in this graph. 
     * 
     * If weight >- 1 it must be checked
     * If description != null, it must be checked 
     * 
     * Returns the edge if removed
     * or null otherwise.
     *
     * @param sourceVertex source vertex of the edge.
     * @param destinationVertex target vertex of the edge.
     * @param weight weight of the edge
     * @param description description of the edge
     *
     * @return The removed edge, or null if no edge removed.
     */
	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (!this.containsEdge(sourceVertex, destinationVertex)) {
			return null;
		}
		if (!(weight >= 0)) {
			return null;
		}
		if (description == null) {
			return null;
		}
		
		ArrayList<Road> toBeEdited = adjMap.get(sourceVertex);
		ArrayList<Road> copyToBeEdited = new ArrayList<Road>(); 
		copyToBeEdited.addAll(toBeEdited); // This has to be copied to aviod ConcurrentModificationExcepiont							
		Road removedEdge = null;            //This error occurs when a Collection is being edited in an iterator,
		                                    // which is used in a for each loop
		for(Road r : toBeEdited) {
			if (r.getName() == description) {
				copyToBeEdited.remove(r);
				removedEdge = r;
			}
		}
		
		adjMap.put(sourceVertex, copyToBeEdited); //Must be done twice since an undirected adjacency list
		toBeEdited = adjMap.get(destinationVertex); // includes an edge in both the source and destination vertex
		copyToBeEdited.addAll(toBeEdited);
		removedEdge = null;
		
		for(Road r : toBeEdited) {
			if (r.getName() == description) {
				copyToBeEdited.remove(r);
				removedEdge = r;
			}
		}
		
		adjMap.put(destinationVertex, copyToBeEdited);
		return removedEdge;
	}
	/**
	* Removes the specified vertex from this graph including all its touching
    * edges if present. More formally, if the graph contains a vertex 
    * u such that u.equals(v), the call removes all edges
    * that touch u and then removes u itself. If no
    * such u is found, the call leaves the graph unchanged.
    * Returns true if the graph contained the specified vertex. (The
    * graph will not contain the specified vertex once the call returns).
    *
    * If the specified vertex is null returns false.
    *
    * @param v vertex to be removed from this graph, if present.
    *
    * @return true if the graph contained the specified vertex;
    * false otherwise.
    */
	@Override
	public boolean removeVertex(Town v) {
		if (v == null) {
			return false;
		}
		
		ArrayList<Road> roadList = adjMap.get(v);
		for (Road r : roadList) {
			this.removeEdge(r.getSource(), r.getDestination(), r.getWeight(), r.getName());
		}
		
		adjMap.remove(v, adjMap.get(v));
		return true;
	}

	/**
     * Returns a set of the vertices contained in this graph. The set is backed
     * by the graph, so changes to the graph are reflected in the set. If the
     * graph is modified while an iteration over the set is in progress, the
     * results of the iteration are undefined.
     *
     *
     * @return a set view of the vertices contained in this graph.
     */
	@Override
	public Set<Town> vertexSet() {
		return adjMap.keySet();
	}

	 /**
     * Find the shortest path from the sourceVertex to the destinationVertex
     * call the dijkstraShortestPath with the sourceVertex
     * @param sourceVertex starting vertex
     * @param destinationVertex ending vertex
     * @return An arraylist of Strings that describe the path from sourceVertex
     * to destinationVertex
     * They will be in the format: startVertex "via" Edge "to" endVertex weight
	 * As an example: if finding path from Vertex_1 to Vertex_10, the ArrayList<String>
	 * would be in the following format(this is a hypothetical solution):
	 * Vertex_1 via Edge_2 to Vertex_3 4 (first string in ArrayList)
	 * Vertex_3 via Edge_5 to Vertex_8 2 (second string in ArrayList)
	 * Vertex_8 via Edge_9 to Vertex_10 2 (third string in ArrayList)
     */
	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		if (containsEdge(sourceVertex, destinationVertex) == false) {
			ArrayList<String> noPath = new ArrayList<String>();
			noPath.clear();
			return noPath;
		}
		
		ArrayList<Town> shortestPathReverse = new ArrayList<Town>();
		
		ArrayList<String> writtenAnswer = new ArrayList<String>();
		
		dijkstraShortestPath(sourceVertex);
		for (Town t1: closed) {
			if(t1.equals(destinationVertex)) {
				shortestPathReverse.add(t1);
				
			}
		}
		
		Town current = shortestPathReverse.get(0);
		while(current.getPred() != sourceVertex) {
			current = current.getPred();
			shortestPathReverse.add(current);
		}
		
		Town[] shortestPathPropper = new Town[shortestPathReverse.size()+1];
		
		shortestPathPropper[0] = sourceVertex;
		for (int i =0; i < shortestPathReverse.size(); i++) {
			shortestPathPropper[shortestPathReverse.size()-i] = shortestPathReverse.get(i);
		}
		
		String message = "";
		for (int i =0; i < shortestPathPropper.length; i++) {
			if (i != shortestPathPropper.length-1) {
				message = shortestPathPropper[i].getName() + " via " + getEdge(shortestPathPropper[i], shortestPathPropper[i+1]).getName() + 
				" to " + shortestPathPropper[i+1].getName() + " " + getEdge(shortestPathPropper[i], shortestPathPropper[i+1]).getWeight() + " mi";
				writtenAnswer.add(message);
				message = "";
			}
		}
 		
		return writtenAnswer;
	}
	
	/**
    * Dijkstra's Shortest Path Method.  Internal structures are built which
    * hold the ability to retrieve the path, shortest distance from the
    * sourceVertex to all the other vertices in the graph, etc.
    * @param sourceVertex the vertex to find shortest path from
    * 
    */
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		   this.closed.add(sourceVertex);
		   this.open.addAll(this.vertexSet());
		   this.open.remove(sourceVertex);
		   sourceVertex.setWeight(0);
		   
		   
		   while(!open.isEmpty()) {
			   int minWt = Integer.MAX_VALUE;
			   Town minAdjTown = null;
			   
			   for (Town vertex : closed) {
				   
				   for (Town adjVertex: getAdjVerticesInSet(vertex, open)) {
					   int wt = getWtToSource(adjVertex, vertex, sourceVertex);
					   if (wt < minWt) {
						   minWt = wt;
						   minAdjTown = adjVertex;
						 adjVertex.setPred(vertex);
					   }
				   }
				   
			   }
			   if (minAdjTown != null) {
				   minAdjTown.setWeight(minWt);
				   open.remove(minAdjTown);
				   closed.add(minAdjTown);
			   }
			   
		   }
		   
		   
		
	}
	
	public int getWtToSource(Town adjVertex, Town vertex, Town sourceVertex) {
		int wtToSource = 0;
		wtToSource = getEdge(vertex, adjVertex).getWeight();
		if (!vertex.equals(sourceVertex)) {
			Town current = vertex;
			Town previous;
			while (!current.getPred().equals(sourceVertex)) {
				previous = current;
				current = current.getPred();
				wtToSource += getEdge(current, previous).getWeight();
		}
	}
		return wtToSource;
	}
	
	public ArrayList<Town> getAdjVerticesInSet(Town vertex, ArrayList<Town> open) {
		ArrayList <Town> adjVerticesInSet = new ArrayList<Town>();
		 Set<Road> edgeSet = this.edgesOf(vertex);
			
		for (Town t : open) {
			for (Road r: edgeSet) {
				if (r.getDestination() == t) {
					adjVerticesInSet.add(t);
				}
			}
		}
		
		return adjVerticesInSet;
		
	}
	
	
	
	

}
