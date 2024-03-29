package sfu.cmpt307.input;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Logger {

	private static final String FILENAME = "9382.txt";
	private StringBuilder log;

	public Logger() {
		log = new StringBuilder();
	}

	public void logOperation(Operation op) {
		log.append(op + System.lineSeparator());
	}

	public void logResult(String msg) {

		log.append(msg);
		log.append(System.lineSeparator());
	}

	public void print() {
		System.out.println(log.toString());
	}

	public void writeLogToFile() {
		PrintWriter out;
		try {
			out = new PrintWriter(FILENAME);
			out.println(log.toString());
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
