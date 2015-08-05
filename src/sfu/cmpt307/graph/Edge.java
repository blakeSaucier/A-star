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
		Edge result = new Edge(distance(v1, v2), v1, v2);
		return result;
	}
		
	// Vertices represent Latitude and Longitude locations
	public static Double haversineDistance(Vertex v1, Vertex v2) {
		double earthRadius = 6371.0 * 1000; // Earth radius in Meters
	    double dLat = Math.toRadians(v2.getY() - v1.getY());
	    double dLng = Math.toRadians(v2.getX() - v1.getX());

	    double sindLat = Math.sin(dLat / 2);
	    double sindLong = Math.sin(dLng / 2);
	    
	    double a = Math.pow(sindLat, 2) + Math.pow(sindLong, 2)
	            * Math.cos(Math.toRadians(v1.getY())) * Math.cos(Math.toRadians(v2.getY()));
	    
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	    double distance = earthRadius * c;
	    
		return distance;
	}
	
	// Distance formula given in course Notes
	public static Double distance(Vertex v1, Vertex v2) {
		Double dlat	=	2	*	Math.PI	*	(v2.getX() - v1.getX())	/	360;	
		Double mlat	=	2	*	Math.PI	*	(v1.getX() + v2.getX())	/	2	/	360;	
		Double dlon	=	2	*	Math.PI	*	(v2.getY() - v1.getY())	/	360;
		return	6371009	* Math.pow(Math.pow((Math.pow(dlat, 2)	+	(Math.cos(mlat)	*	dlon)),	2),	0.5);
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

