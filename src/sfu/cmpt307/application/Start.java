package sfu.cmpt307.application;

import java.io.FileNotFoundException;

import sfu.cmpt307.algorithms.Dijkstra;
import sfu.cmpt307.graph.Graph;
import sfu.cmpt307.graph.Vertex;
import sfu.cmpt307.input.FrontEnd;

public class Start {

	public static void main(String[] args) throws FileNotFoundException {
		Graph graph = FrontEnd.makeGraph();
		Vertex start = graph.getVertices().get(0);
		Vertex end = graph.getVertices().get(9);
		Dijkstra dijkstra = new Dijkstra(graph);
		Double distance = dijkstra.execute(start, end);
		System.out.println("Distance is : " + distance);
	}
}
