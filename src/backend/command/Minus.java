package backend.command;

import backend.StringPair;


public class Minus extends UnaryMathOperation {

	public Minus(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double expr) {
		return -expr;
	}

}
