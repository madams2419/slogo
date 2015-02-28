package backend.command;

import backend.StringPair;


public class Sine extends UnaryMathOperation {

	public Sine(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double degrees) {
		return Math.sin(Math.toRadians(degrees));
	}

}
