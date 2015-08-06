package sfu.cmpt307.application;

import java.io.FileNotFoundException;
import sfu.cmpt307.graph.Graph;
import sfu.cmpt307.input.FrontEnd;

public class Start {

	public static void main(String[] args) throws FileNotFoundException {
		Graph graph = FrontEnd.makeGraph();
		Tests.run(graph);
	}
}
