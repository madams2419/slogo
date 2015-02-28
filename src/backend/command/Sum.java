package backend.command;

import backend.StringPair;


public class Sum extends BinaryMathOperation {

	public Sum(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 + expr2;
	}

}





