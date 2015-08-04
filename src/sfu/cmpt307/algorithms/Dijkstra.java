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
	
	public Double execute(Vertex start, Vertex end) {
		System.out.println("Running djikstra's");
		distances = new HashMap<Vertex, Double>();
		unDecided = new HashSet<Vertex>();
		verticesVisited = 0;
		initializeDistances();
		distances.put(start, 0.0);
		while (unDecided.size() > 0) {
			Vertex nextMinimum = smallestUndecided();
			if (nextMinimum.equals(end)) {
				return distances.get(nextMinimum);
			}
			exploreAdjacent(nextMinimum);
		}
		return distances.get(end);
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
			Double weight = graph.getEdge(vertex, adjacent).getWeight();
			if ((weight + currentDistance) < distances.get(adjacent) ) {
				distances.put(adjacent, weight + currentDistance);
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
			}
		}
		unDecided.remove(minimumDistanceVertex);
		return minimumDistanceVertex;
	}
}
