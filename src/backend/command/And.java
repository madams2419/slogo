package backend.command;

import backend.StringPair;

public class And extends BinaryBooleanOperation{

	public And(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double expr1, Double expr2) {
		Double product = expr1*expr2;
		if(product == 0){
			return (double) 0;
		}
		return (double) 1;

	}

}
