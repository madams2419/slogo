package backend.command;

import backend.StringPair;

public class ArcTangent extends UnaryMathOperation {

	public ArcTangent(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double degrees) {
		return Math.atan(Math.toRadians(degrees));
	}

}
