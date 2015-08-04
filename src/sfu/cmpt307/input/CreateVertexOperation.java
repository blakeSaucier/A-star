package sfu.cmpt307.input;

import sfu.cmpt307.graph.Graph;
import sfu.cmpt307.graph.Vertex;

public class CreateVertexOperation extends Operation {

	private int ID;
	private Double xCoord;
	private Double yCoord;
	
	public CreateVertexOperation(Operator operator) {
		super(operator);
	}

	public void setXCoord(Double x) {
		this.xCoord = x;
	}
	
	public void setYCoord(Double y) {
		this.yCoord = y;
	}
	
	public void setVertexID(int ID) {
		this.ID = ID;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public Double getX() {
		return this.xCoord;
	}
	
	public Double getY() {
		return this.yCoord;
	}
	
	public static Operation make(int ID, Double xCoord, Double yCoord) {
		CreateVertexOperation operation = new CreateVertexOperation(Operator.VERTEX);
		operation.setVertexID(ID);
		operation.setXCoord(xCoord);
		operation.setYCoord(yCoord);
		return operation;
	}
	
	@Override
	public void run(Graph graph, Logger logger) {
		Vertex vertex = new Vertex(getID());
		vertex.setX(getX());
		vertex.setY(getY());
		graph.addVertex(vertex);
		logger.logResult(vertex.toString());
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(operator.getLexeme() + " ");
		builder.append(ID + " ");
		builder.append(xCoord + " ");
		builder.append(yCoord);
		return builder.toString();
	}
}
