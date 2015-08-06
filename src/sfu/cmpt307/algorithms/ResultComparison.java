package sfu.cmpt307.algorithms;

public class ResultComparison {

	public Result dijkstraResult;
	public Result aStarResult;
	
	public ResultComparison(Result dijkstraResult, Result aStarResult) {
		this.dijkstraResult = dijkstraResult;
		this.aStarResult = aStarResult;
	}
	
	public float AStarMultiplesFaster() {
		return dijkstraResult.verticesVisited / aStarResult.verticesVisited;
	}
	
	public float AStarFractionOfDijkstra() {
		return aStarResult.verticesVisited / dijkstraResult.verticesVisited;
	}
}
