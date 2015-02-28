package backend.command;

import backend.StringPair;


public class Random extends UnaryMathOperation {

	public Random(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double expr) {
		return Math.random() * expr;
	}

}
