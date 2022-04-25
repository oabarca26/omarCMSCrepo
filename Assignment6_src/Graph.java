/**
 * @author Omar Abarca
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Graph implements GraphInterface<Town, Road>{

	Set<Town> town = new HashSet<Town>();
	Set<Road> road = new HashSet<Road>();
	Map<Town, Town> townMap = new HashMap<Town, Town>();
	Map<Town, Integer> pathWeight = new HashMap<Town, Integer>();
	
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		for(Road roads: road) {
			if (roads.contains(sourceVertex) && roads.contains(destinationVertex))
				return roads;
		}
		
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		if (sourceVertex == null || destinationVertex == null)
			throw new NullPointerException();

		if (!town.contains(sourceVertex) || !town.contains(destinationVertex))
			throw new IllegalArgumentException();
		
		Road edge = new Road(sourceVertex, destinationVertex, weight, description);
		
		try {
			road.add(edge);
		} catch (Exception e) {
			return null;
		}
		
		return edge;
	}

	@Override
	public boolean addVertex(Town v) {  
        if (v == null) 
            throw new NullPointerException();
        
        if (!town.contains(v)) {
            town.add(v);
            return true;
        }
        
        return false;
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		for(Road roads: road) {
			if (roads.contains(sourceVertex) && roads.contains(destinationVertex))
				return true;
		}
		
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
		for(Town towns: town) {
			if (towns.equals(v))
				return true;
		}
		
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
		return road;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> edges = new HashSet<>();
		
        for (Road roads : road) {
            if (roads.contains(vertex)) 
                edges.add(roads);
        }
        
        return edges;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		for (Road roads: road)
			if (roads.contains(sourceVertex) && roads.contains(destinationVertex) && roads.getWeight() 
					== weight && roads.getName().equals(description)) {
				road.remove(roads);
				return roads;
			}
		
		return null;
	}

	@Override
	public boolean removeVertex(Town v) {
		return town.remove(v);
	}

	@Override
	public Set<Town> vertexSet() {
		return town;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {
		ArrayList<String> shortestPath = new ArrayList<String>();
		boolean bool = false;

		for(Road roads: road) 
			if(roads.contains(destinationVertex))
				bool = true;
		
		if(!bool) 
			return shortestPath;
		
		dijkstraShortestPath(sourceVertex);

		while(!sourceVertex.equals(destinationVertex)) {
		for(Road roads: road) 
			if(roads.contains(destinationVertex) && roads.contains(townMap.get(destinationVertex)))
				shortestPath.add(0, townMap.get(destinationVertex).getName() + " via " + roads.getName() + 
						" to " + destinationVertex.getName() + " " + roads.getWeight() + " mi");
		
		destinationVertex = townMap.get(destinationVertex);
		}
		return shortestPath;	
	}

	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		HashSet<Town> dijkstra = new HashSet<>();
		
		for(Town townNode: town) 
			dijkstra.add(townNode);

		for(Town towns: town) 
			pathWeight.put(towns, Integer.MAX_VALUE);

		while(!dijkstra.isEmpty()) {
			int minWeight = 100;
			for(Town towns: pathWeight.keySet()) {	
				if(minWeight >  pathWeight.get(towns) && dijkstra.contains(towns)) {
					minWeight = pathWeight.get(towns);
					sourceVertex = towns;
				}
			}
			
			for(Road roadNode: road) {
				if(roadNode.contains(sourceVertex)) {
					if(!roadNode.getDestination().equals(sourceVertex) && dijkstra.contains(roadNode.getDestination())) {
						if(pathWeight.get(sourceVertex) + roadNode.getWeight() < pathWeight.get(roadNode.getDestination())) {
							townMap.put(roadNode.getDestination(), sourceVertex);
							pathWeight.put(roadNode.getDestination(), roadNode.getWeight() + pathWeight.get(sourceVertex));
						}
					}
				}
			}
			for(Road roadNode: road) {
			if(roadNode.contains(sourceVertex)) {
				if(!roadNode.getSource().equals(sourceVertex) && dijkstra.contains(roadNode.getSource()))
					if(pathWeight.get(sourceVertex) + roadNode.getWeight() < pathWeight.get(roadNode.getSource())) {
						townMap.put(roadNode.getSource(), sourceVertex);
						pathWeight.put(roadNode.getSource(), roadNode.getWeight() + pathWeight.get(sourceVertex));
					}
				}
			}
			
			dijkstra.remove(sourceVertex);
		}
	}

}
