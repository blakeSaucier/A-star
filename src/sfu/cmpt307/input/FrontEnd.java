package sfu.cmpt307.input;

import java.io.FileNotFoundException;
import sfu.cmpt307.graph.Graph;

public class FrontEnd {

	public static Graph makeGraph() throws FileNotFoundException {
		// opens text file 'input.txt' by default
		InputScanner scanner = InputScanner.scan();
		return Interpreter.makeAndRunInterpreter(scanner);
	}
}
