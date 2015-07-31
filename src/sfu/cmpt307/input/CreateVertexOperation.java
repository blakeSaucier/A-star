package sfu.cmpt307.input;

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
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(operator.getLexeme() + " ");
		builder.append(ID + " ");
		builder.append(xCoord + " ");
		builder.append(yCoord);
		return builder.toString();
	}
}
