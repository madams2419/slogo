package backend.command;

import backend.StringPair;


public class Tangent extends UnaryMathOperation {

	public Tangent(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double degrees) {
		return Math.cos(Math.toRadians(degrees));
	}

}
