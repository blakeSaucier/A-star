package sfu.cmpt307.input;

import java.util.ArrayList;
import java.util.List;

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
	
	public List<Integer> getAdjacencies() {
		return this.adjacencyList;
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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(operator.getLexeme() + " ");
		builder.append(ID + "-> ");
		for (Integer id: adjacencyList) {
			builder.append(id + " ");
		}
		return builder.toString();
	}
}
