package sfu.cmpt307.input;

import java.io.FileNotFoundException;

import sfu.cmpt307.graph.Edge;
import sfu.cmpt307.graph.Graph;
import sfu.cmpt307.graph.Vertex;

public class Interpreter {

	private InputScanner scanner;
	private Logger logger;

	public Interpreter(InputScanner scanner) {
		this.scanner = scanner;
		this.logger = new Logger();
	}

	public static Graph makeAndRunInterpreter(InputScanner scanner)
			throws FileNotFoundException {
		Interpreter interpreter = new Interpreter(scanner);
		return interpreter.run();
	}

	public Graph run() throws FileNotFoundException {
		Graph graph = new Graph();
		for (Operation operation: scanner.getOperations()) {
			if (operation.operator == Operator.VERTEX) {
				CreateVertexOperation op = (CreateVertexOperation)operation;
				Vertex vertex = new Vertex(op.getID());
				vertex.setX(op.getX());
				vertex.setY(op.getY());
				graph.addVertex(vertex);
				
			} else if (operation.operator == Operator.EDGE) {
				AdjacencyOperation op = (AdjacencyOperation)operation;
				Vertex v1 = graph.findVertexByID(op.getID());
				for (Integer adjacentID: op.getAdjacencies()) {
					Vertex adjacentVertex = graph.findVertexByID(adjacentID);
					Edge connectingEdge = Edge.makeEdge(v1, adjacentVertex);
					graph.addEdge(connectingEdge);
				}
			}
		}
		logger.writeLogToFile();
		return graph;
	}
}