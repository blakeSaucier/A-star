package sfu.cmpt307.input;

public class Operation {
	
	protected Operator operator;
	
	public Operation(Operator operator) {
		this.operator = operator;
	}
	
	public Operator getOperator() {
		return this.operator;
	}
}
