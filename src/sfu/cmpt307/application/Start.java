package sfu.cmpt307.application;

import java.io.FileNotFoundException;

import sfu.cmpt307.algorithms.Astar;
import sfu.cmpt307.algorithms.Dijkstra;
import sfu.cmpt307.algorithms.Result;
import sfu.cmpt307.graph.Graph;
import sfu.cmpt307.graph.Vertex;
import sfu.cmpt307.input.FrontEnd;

public class Start {

	public static void main(String[] args) throws FileNotFoundException {
		Graph graph = FrontEnd.makeGraph();
		Vertex start = graph.getVertices().get(0);
		Vertex end = graph.getVertices().get(900);
		
		Dijkstra dijkstra = new Dijkstra(graph);
		Result result = dijkstra.execute(start, end);
		System.out.println("Dijkstra" + System.lineSeparator() + "Distance is : " + result.distance + " m, visited " + result.verticesVisited + " vertices while running");
		
		//PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
		
		Astar aStar = new Astar(graph);
		Result aStarResult = aStar.execute(start, end);
		System.out.println("A-Star" + System.lineSeparator() +"Distance is : " + aStarResult.distance + " m, visited " + aStarResult.verticesVisited + " vertices while running");

	}
}
