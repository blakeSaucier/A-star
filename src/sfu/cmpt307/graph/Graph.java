package sfu.cmpt307.graph;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	
	private List<Vertex> vertices;
	private List<Edge> edges;
	
	public Graph() {
		vertices = new ArrayList<Vertex>();
		edges = new ArrayList<Edge>();
	}
	
	public Graph(List<Vertex> vertices, List<Edge> edges) {
		this.vertices = vertices;
		this.edges = edges;
	}
	
	public List<Vertex> getVertices() {
		return this.vertices;
	}
	
	public List<Edge> getEdges() {
		return this.edges;
	}
	
	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
	}
	
	public void addEdge(Edge edge) {
		edges.add(edge);
	}
	
	public Vertex findVertexByID(int ID) {
		// naive linear approach
		for (Vertex v: vertices) {
			if (v.getId() == ID) {
				return v;
			}
		}
		throw new IllegalArgumentException("Vertex does not exist in graph");
	}
}
