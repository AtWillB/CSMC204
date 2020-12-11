import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface{
	Graph graph = new Graph();

	/**
	 * Adds a road with 2 towns and a road name
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName name of road
	 * @return true if the road was added successfully
	 */
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		Boolean addRoad = false;
		Road road = graph.addEdge(getTown(town1), getTown(town2), weight, roadName);
		
		if (road != null) {
		addRoad = true;
		}
		return addRoad;
	}

	/**
	 * Returns the name of the road that both towns are connected through
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return name of road if town 1 and town2 are in the same road, returns null if not
	 */
	@Override
	public String getRoad(String town1, String town2) {
		return graph.getEdge(getTown(town1), getTown(town2)).getName();
		
	}

	/**
	 * Adds a town to the graph
	 * @param v the town's name  (lastname, firstname)
	 * @return true if the town was successfully added, false if not
	 */
	@Override
	public boolean addTown(String v) {
		Boolean addTown = false;
		Town town = new Town(v);
		addTown = graph.addVertex(town);
		
		return addTown;
	}

	/**
	 * Gets a town with a given name
	 * @param name the town's name 
	 * @return the Town specified by the name, or null if town does not exist
	 */
	@Override
	public Town getTown(String name) {
		Set<Town> townSet = graph.vertexSet();
		Town townGot = null;
		
		for (Town t : townSet) {
			if  (t.toString().equals(name)) {
				townGot = t;
			}
		}
		
		return townGot;
	}

	/**
	 * Determines if a town is already in the graph
	 * @param v the town's name 
	 * @return true if the town is in the graph, false if not
	 */
	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(getTown(v));
	}

	/**
	 * Determines if a road is in the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return true if the road is in the graph, false if not
	 */
	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(getTown(town1), getTown(town2));
	}

	/**
	 * Creates an arraylist of all road titles in sorted order by road name
	 * @return an arraylist of all road titles in sorted order by road name
	 */
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> allRoads = new ArrayList<String>();
		Set<Road> roadSet = graph.edgeSet();
		
		for (Road r : roadSet) {
			allRoads.add(r.getName());
		}
		Collections.sort(allRoads);
		
		return allRoads;
	}

	/**
	 * Deletes a road from the graph
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @param roadName the road name
	 * @return true if the road was successfully deleted, false if not
	 */
	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		Road toBeDeleted = graph.getEdge(getTown(town1), getTown(town2));
		graph.removeEdge(toBeDeleted.getSource(), toBeDeleted.getSource(), toBeDeleted.getWeight(), toBeDeleted.getName());
		graph.removeEdge(toBeDeleted.getDestination(), toBeDeleted.getSource(), toBeDeleted.getWeight(), toBeDeleted.getName());
		Boolean deleteRoadConnection = containsRoadConnection(town1, town2);
		
		if (deleteRoadConnection == true) {
			deleteRoadConnection = false;
		}
		else {
			deleteRoadConnection = true;
		}
		return deleteRoadConnection;
	}

	/**
	 * Deletes a town from the graph
	 * @param v name of town (lastname, firstname)
	 * @return true if the town was successfully deleted, false if not
	 */
	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(getTown(v));
	}

	/**
	 * Creates an arraylist of all towns in alphabetical order (last name, first name)
	 * @return an arraylist of all towns in alphabetical order (last name, first name)
	 */
	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> allTowns = new ArrayList<String>();
		Set<Town> townSet = graph.vertexSet();
		
		for (Town t : townSet) {
			allTowns.add(t.getName());
		}
		Collections.sort(allTowns);
		
		return allTowns;
	}

	/**
	 * Returns the shortest path from town 1 to town 2
	 * @param town1 name of town 1 (lastname, firstname)
	 * @param town2 name of town 2 (lastname, firstname)
	 * @return an Arraylist of roads connecting the two towns together, null if the
	 * towns have no path to connect them.
	 */
	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(getTown(town1), getTown(town2));
	}

}
