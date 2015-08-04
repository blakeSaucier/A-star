package sfu.cmpt307.input;

import sfu.cmpt307.graph.Graph;

public class Operation {
	
	protected Operator operator;
	
	public Operation(Operator operator) {
		this.operator = operator;
	}
	
	public Operator getOperator() {
		return this.operator;
	}
	
	public void run(Graph graph, Logger logger) {}
}
