package backend.command;

import backend.StringPair;

public class Cosine extends UnaryMathOperation {
	
	public Cosine(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double degrees) {
		return Math.cos(Math.toRadians(degrees));
	}

}
