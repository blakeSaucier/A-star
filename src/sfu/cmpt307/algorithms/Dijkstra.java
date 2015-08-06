package sfu.cmpt307.algorithms;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import sfu.cmpt307.graph.Graph;
import sfu.cmpt307.graph.Vertex;

public class Dijkstra {

	private Graph graph;
	private Map<Vertex, Double> distances;
	private Set<Vertex> unDecided;
	
	// Dijkstra's running statistics
	private int verticesVisited;

	public Dijkstra(Graph graph) {
		this.graph = graph;
	}
	
	public Result execute(Vertex start, Vertex end) {
		distances = new HashMap<Vertex, Double>();
		unDecided = new HashSet<Vertex>();
		verticesVisited = 0;
		initializeDistances();
		distances.put(start, 0.0);
		while (unDecided.size() > 0) {
			Vertex nextMinimum = smallestUndecided();
			if (nextMinimum.equals(end)) { 
				return new Result(verticesVisited, distances.get(nextMinimum));
			}
			exploreAdjacent(nextMinimum);
		}
		return new Result(verticesVisited, distances.get(end));
	}
	
	private void initializeDistances() {
		for(Vertex vertex: graph.getVertices()) {
			distances.put(vertex, Double.MAX_VALUE);
			unDecided.add(vertex);
		}
	}
	
	private void exploreAdjacent(Vertex vertex) {
		Double currentDistance = distances.get(vertex);
		for (Vertex adjacent: vertex.getAdjacencies()) {
			verticesVisited++;
			Double edgeCost = graph.getEdge(vertex, adjacent).getWeight();
			Double distanceToAdjacent = distances.get(adjacent);
			if ((edgeCost + currentDistance) < distanceToAdjacent ) {
				distances.put(adjacent, edgeCost + currentDistance);
			}
		}
	}
	
	private Vertex smallestUndecided() {
		Vertex minimumDistanceVertex = null;
		Double min = Double.MAX_VALUE;
		for (Vertex v: unDecided) {
			Double distance = distances.get(v);
			if (distance < min) {
				minimumDistanceVertex = v;
				min = distance;
			}
		}
		unDecided.remove(minimumDistanceVertex);
		return minimumDistanceVertex;
	}
	
	// Static convenience method for creating and running Dijkstra
	public static Result makeAndRun(Graph graph, Vertex start, Vertex end) {
		Dijkstra dijkstra = new Dijkstra(graph);
		Result result = dijkstra.execute(start, end);
		System.out.print("*Dijkstra*" + System.lineSeparator() + "Distance: ");
		System.out.format("%.2f", result.distance);
		System.out.println(" m"); 
		System.out.println("Vertices visited: " + result.verticesVisited + System.lineSeparator());
		return result;
	}
}
