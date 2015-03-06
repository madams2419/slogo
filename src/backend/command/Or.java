package backend.command;

import backend.StringPair;

public class Or extends BinaryBooleanOperation{

	public Or(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double expr1, Double expr2) {
		Double sum = expr1+expr2;
		if(sum == 0){
			return (double) 0;
		}
		return (double) 1;

	}

}
