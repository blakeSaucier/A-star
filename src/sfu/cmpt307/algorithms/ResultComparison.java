package sfu.cmpt307.algorithms;

public class ResultComparison {

	public Result dijkstraResult;
	public Result aStarResult;
	
	public ResultComparison(Result dijkstraResult, Result aStarResult) {
		this.dijkstraResult = dijkstraResult;
		this.aStarResult = aStarResult;
	}
	
	public float AStarMultiplesFaster() {
		if (aStarResult.verticesVisited == 0) {
			return 0f;
		}
		return dijkstraResult.verticesVisited / aStarResult.verticesVisited;
	}
	
	public float AStarFractionOfDijkstra() {
		if (dijkstraResult.verticesVisited == 0) {
			return 0f;
		}
		return aStarResult.verticesVisited / dijkstraResult.verticesVisited;
	}
}
