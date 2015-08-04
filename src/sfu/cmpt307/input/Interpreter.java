package sfu.cmpt307.input;

import sfu.cmpt307.graph.Graph;

public class Interpreter {

	private InputScanner scanner;
	private Logger logger;

	public Interpreter(InputScanner scanner) {
		this.scanner = scanner;
		this.logger = new Logger();
	}

	public static Graph makeAndRunInterpreter(InputScanner scanner) {
		Interpreter interpreter = new Interpreter(scanner);
		return interpreter.run();
	}

	public Graph run() {
		Graph graph = new Graph();
		for (Operation operation: scanner.getOperations()) {
			operation.run(graph);
		}
		logger.writeLogToFile();
		return graph;
	}
}