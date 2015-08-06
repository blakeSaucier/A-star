package sfu.cmpt307.application;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sfu.cmpt307.algorithms.Astar;
import sfu.cmpt307.algorithms.Dijkstra;
import sfu.cmpt307.algorithms.Result;
import sfu.cmpt307.algorithms.ResultComparison;
import sfu.cmpt307.graph.Graph;
import sfu.cmpt307.graph.Vertex;
import sfu.cmpt307.input.FrontEnd;

public class Start {

	public static void main(String[] args) throws FileNotFoundException {
		Graph graph = FrontEnd.makeGraph();
		List<ResultComparison> results = new ArrayList<ResultComparison>();
		Random rand = new Random();
		
		for (int i = 0; i < 20; i++) {
			
			int randomStart = rand.nextInt(graph.getVertices().size() - 1);
			int randomEnd = rand.nextInt(graph.getVertices().size() - 1);
			
			Vertex start = graph.getVertices().get(randomStart);
			Vertex end = graph.getVertices().get(randomEnd);
			
			System.out.println("From Vertex " + start+ " to " + end + System.lineSeparator());
			
			Result dijkstraResult = Dijkstra.makeAndRun(graph, start, end);
			Result aStarResult = Astar.makeAndRun(graph, start, end);
			results.add(new ResultComparison(dijkstraResult, aStarResult));
			System.out.println("------" + System.lineSeparator());
		}
		
		Float accumulatedSpeedup = 0f;
		for (ResultComparison resultComparison: results) {
			accumulatedSpeedup += resultComparison.AStarMultiplesFaster();
		}
		accumulatedSpeedup /= results.size();
		System.out.println("On Average, A-Star is " + accumulatedSpeedup + " times faster than Dijkstra");		
	}
}
