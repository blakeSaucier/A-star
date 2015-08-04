package sfu.cmpt307.input;

import java.util.ArrayList;
import java.util.List;

import sfu.cmpt307.graph.Edge;
import sfu.cmpt307.graph.Graph;
import sfu.cmpt307.graph.Vertex;

public class AdjacencyOperation extends Operation {

	private int ID;
	private List<Integer> adjacencyList;
	
	public AdjacencyOperation(Operator operator) {
		super(operator);
		this.adjacencyList = new ArrayList<Integer>();
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public void addAdjacency(int ID) {
		this.adjacencyList.add(ID);
	}
	
	public static Operation makeAdjacencyOperation(int ID, List<Integer> adjacentIDs) {
		AdjacencyOperation operation = new AdjacencyOperation(Operator.EDGE);
		operation.setID(ID);
		for(Integer id: adjacentIDs) {
			operation.addAdjacency(id);
		}
		return operation;
	}
	
	@Override
	public void run(Graph graph, Logger logger) {
		Vertex v1 = graph.findVertexByID(getID());
		logger.logResult(v1.toString() + " Adjacencies: ");
		for (Integer adjacentID: adjacencyList) {
			Vertex adjacentVertex = graph.findVertexByID(adjacentID);
			Edge connectingEdge = Edge.makeEdge(v1, adjacentVertex);
			graph.addEdge(connectingEdge);
			logger.logResult(connectingEdge.toString());
		}
	};
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(operator.getLexeme() + " ");
		builder.append(ID + " -> ");
		for (Integer id: adjacencyList) {
			builder.append(id + " ");
		}
		return builder.toString();
	}
}
