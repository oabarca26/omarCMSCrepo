/**
 * @author Omar Abarca
 */
import java.util.ArrayList;
import java.util.Collections;

public class TownGraphManager implements TownGraphManagerInterface{

    private Graph graph = new Graph();
    
	@Override
	public boolean addRoad(String town1, String town2, int weight, String roadName) {
		try {
			graph.addEdge(new Town(town1), new Town(town2), weight, roadName);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		return graph.getEdge(new Town(town1), new Town(town2)).getName();
	}

	@Override
	public boolean addTown(String v) {
		return graph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
		Town town = null;
		 for (Town t : graph.vertexSet()) {
	            if (t.getName().equals(name)) {
	                town = t;
	            }
	        }
	        return town;
	}

	@Override
	public boolean containsTown(String v) {
		return graph.containsVertex(new Town(v));
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		return graph.containsEdge(new Town(town1), new Town(town2));
	}

	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> allRoads = new ArrayList<>();

		for (Road roads: graph.edgeSet())
			allRoads.add(roads.getName());
		
		Collections.sort(allRoads);
		return allRoads;
	}

	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		int weight = 0;

		for (Road roads: graph.edgeSet()) {
			if (roads.getName().equals(getRoad(town1, town2)))
				weight = roads.getWeight();
		}
		
		return graph.removeEdge(new Town(town1), new Town(town2), weight, road) != null;
	}

	@Override
	public boolean deleteTown(String v) {
		return graph.removeVertex(getTown(v));
	}

	@Override
	public ArrayList<String> allTowns() {
		ArrayList<String> allTowns = new ArrayList<>();

		for (Town towns: graph.vertexSet())
			allTowns.add(towns.getName());
		
		Collections.sort(allTowns);
		return allTowns;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		return graph.shortestPath(new Town(town1), new Town(town2));
	}

}
