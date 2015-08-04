package sfu.cmpt307.input;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputScanner {
	
	private static final String INPUT_FILENAME = "input.txt";
	
	private BufferedReader reader;
	private List<Operation> operations;
	
	public InputScanner() throws FileNotFoundException {
		reader = new BufferedReader(new FileReader(INPUT_FILENAME));
		operations = new ArrayList<Operation>();
	}
	
	public static InputScanner scan() throws FileNotFoundException {
		InputScanner scanner = new InputScanner();
		scanner.readFile();
		return scanner;
	}
	
	public List<Operation> getOperations() {
		return this.operations;
	}
	
	private void readFile() {
		try {
			String line = reader.readLine();
			while(!isBlank(line)) {
				readVertexLine(line);
				line = reader.readLine();
			}
			
			line = reader.readLine();
			while(isBlank(line)) {
				line = reader.readLine();
			}
			
			while (line != null) {
				readEdgeLine(line);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean isBlank(String line) {
		return line.trim().equals("");
	}
	
	private void readVertexLine(String line)  {
		List<String> stringInput = new ArrayList<String>(Arrays.asList(line.split("\\s+:\\s|,\\s+")));
		createVertexOperation(stringInput);
	}
	
	private void readEdgeLine(String line) {
		List<String> stringInput = new ArrayList<String>(Arrays.asList(line.split("\\s+:\\s+|,\\s+|,")));
		createEdgeOperation(stringInput);
	}
	
	private void createVertexOperation(List<String> textInput) {
		int vertexID = Integer.parseInt(textInput.get(0));
		Double xCoord = Double.parseDouble(textInput.get(1));
		Double yCoord = Double.parseDouble(textInput.get(2));
		Operation op = CreateVertexOperation.make(vertexID, xCoord, yCoord);
		operations.add(op);
	}
	
	private void createEdgeOperation(List<String> textInput) {
		int vertexID = Integer.parseInt(textInput.get(0));
		List<Integer> adjacentIDs = new ArrayList<Integer>();
		for (int i = 1; i < textInput.size(); i++) {
			adjacentIDs.add(Integer.parseInt(textInput.get(i)));
		}
		Operation op = AdjacencyOperation.makeAdjacencyOperation(vertexID, adjacentIDs);
		operations.add(op);
	}
}
