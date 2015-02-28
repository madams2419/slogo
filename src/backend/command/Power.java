package backend.command;

import backend.StringPair;


public class Power extends BinaryMathOperation {

	public Power(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double base, Double exponent) {
		return Math.pow(base, exponent);
	}

}
