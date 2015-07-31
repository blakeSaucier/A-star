package sfu.cmpt307.graph;


public class Edge {
	
	private Double weight;
	private Vertex v1;
	private Vertex v2;
	
	public Edge(Double weight, Vertex v1, Vertex v2) {
		this.weight = weight;
		this.v1 = v1;
		this.v2 = v2;
		registerAdjacencies();
	}
	
	private void registerAdjacencies() {
		v1.registerAdjacency(v2);
		v2.registerAdjacency(v1);
	}
	
	public void deregisterAdjacencies() {
		v1.deregisterAdjacency(v2);
		v2.deregisterAdjacency(v1);
	}
	
	public Double getWeight() {
		return this.weight;
	}
	
	public Vertex getV1() {
		return this.v1;
	}
	
	public Vertex getV2() {
		return this.v2;
	}

	public static Edge makeEdge(Vertex v1, Vertex v2) {
		Edge result = new Edge(euclideanDistance(v1, v2), v1, v2);
		return result;
	}
	
	private static Double euclideanDistance(Vertex v1, Vertex v2) {
		Double xDiff = v1.getX() - v2.getX();
		Double yDiff = v1.getY() - v2.getY();
		return Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
	}
	
	@Override
	public String toString() {
		return v1 + " <-- " + weight + " --> " + v2;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Edge arg = (Edge) obj;
		return ( (arg.getV1().equals(this.v1) && arg.getV2().equals(this.v2)) ||
				( arg.getV1().equals(this.v2) && arg.getV2().equals(this.v1)));
	}
}

