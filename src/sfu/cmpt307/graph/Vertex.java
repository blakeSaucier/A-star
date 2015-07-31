package sfu.cmpt307.graph;

import java.util.ArrayList;
import java.util.List;

public class Vertex {

	private int ID;
	private List<Vertex> adjacentVertices;
	
	// used for drawing vertices, not needed for Djikstra's
	private Double x;
	private Double y;
	
	public Vertex(int ID) {
		this.ID = ID;
		adjacentVertices = new ArrayList<Vertex>();
	}
	
	public int getId() {
		return this.ID;
	}
	
	public void registerAdjacency(Vertex vertex) {
		this.adjacentVertices.add(vertex);
	}
	
	public void deregisterAdjacency(Vertex vertex) {
		adjacentVertices.remove(vertex);
	}
	
	///////////////////////////////////////////////////
	// X and Y coordinates are for graph visualization
	
	public Double getX() {
		return this.x;
	}
	
	public Double getY() {
		return this.y;
	}
	
	public List<Vertex> getAdjacencies() {
		return this.adjacentVertices;
	}
	
	public void setX(Double x) {
		this.x = x;
	}
	
	public void setY(Double y) {
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "ID: " + ID;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		Vertex arg = (Vertex) obj;
		return arg.ID == this.ID;
	}
}

