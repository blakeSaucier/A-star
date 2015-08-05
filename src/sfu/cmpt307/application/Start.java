package sfu.cmpt307.application;

import java.io.FileNotFoundException;
import java.util.Random;

import sfu.cmpt307.algorithms.Astar;
import sfu.cmpt307.algorithms.Dijkstra;
import sfu.cmpt307.graph.Graph;
import sfu.cmpt307.graph.Vertex;
import sfu.cmpt307.input.FrontEnd;

public class Start {

	public static void main(String[] args) throws FileNotFoundException {
		Graph graph = FrontEnd.makeGraph();
		Random rand = new Random();
		
		for (int i = 0; i < 20; i++) {
			Vertex start = graph.getVertices().get(rand.nextInt(999));
			Vertex end = graph.getVertices().get(rand.nextInt(999));
			
			Dijkstra.makeAndRun(graph, start, end);
			Astar.makeAndRun(graph, start, end);
			
			//PriorityQueue<Vertex> queue = new PriorityQueue<Vertex>();
			
			System.out.println(" ------" + System.lineSeparator());
		}
	}
}
