package backend.command;

import backend.StringPair;


public class NaturalLog extends UnaryMathOperation {
	
	public NaturalLog(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double expr) {
		return Math.log(expr);
	}

}
