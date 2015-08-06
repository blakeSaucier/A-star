package sfu.cmpt307.application;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import sfu.cmpt307.algorithms.Astar;
import sfu.cmpt307.algorithms.Dijkstra;
import sfu.cmpt307.algorithms.Result;
import sfu.cmpt307.algorithms.ResultComparison;
import sfu.cmpt307.graph.Graph;
import sfu.cmpt307.graph.Vertex;

public class Tests {

	public static void run(Graph graph) {
		List<ResultComparison> results = new ArrayList<ResultComparison>();
		Random rand = new Random();
		
		// 20 tests involving randomly selected start/end points
		for (int i = 0; i < 20; i++) {
			int randomStart = rand.nextInt(graph.getVertices().size() - 1);
			int randomEnd = rand.nextInt(graph.getVertices().size() - 1);
			
			Vertex start = graph.getVertices().get(randomStart);
			Vertex end = graph.getVertices().get(randomEnd);
			
			System.out.println("Test Run #" + (i+1) + " : ");
			System.out.println("From Vertex " + start + " to " + end + System.lineSeparator());
			
			Result dijkstraResult = Dijkstra.makeAndRun(graph, start, end);
			Result aStarResult = Astar.makeAndRun(graph, start, end);
			results.add(new ResultComparison(dijkstraResult, aStarResult));
			System.out.println("------" + System.lineSeparator());
		}
		System.out.println("On Average, A-Star is " + averageSpeedup(results) + " times faster than Dijkstra");		
	}
	
	private static float averageSpeedup(List<ResultComparison> results) {
		Float accumulatedSpeedup = 0f;
		for (ResultComparison resultComparison: results) {
			accumulatedSpeedup += resultComparison.AStarMultiplesFaster();
		}
		return accumulatedSpeedup / results.size();
	}
}
