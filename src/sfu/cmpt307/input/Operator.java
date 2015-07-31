package sfu.cmpt307.input;

public enum Operator {

	VERTEX("Node"),
	EDGE("Edge"),
	INVALID_OPERATOR("Invalid");
	
	private String lexeme;
	
	private Operator(String lexeme) {
		this.lexeme = lexeme;
	}
	
	public String getLexeme() {
		return lexeme;
	}
	
	public static Operator forLexeme(String lexeme) {
		for(Operator operator: values()) {
			if(operator.lexeme.equals(lexeme)) {
				return operator;
			}
		}
		return INVALID_OPERATOR;
	}
}
