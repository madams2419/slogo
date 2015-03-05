package backend.command;

import backend.StringPair;

public class Equal extends BinaryBooleanOperation {

	public Equal(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}


	public Double operate(Double expr1, Double expr2) {
		if(expr1.equals(expr2)){
			return (double)1;
		}
		return (double)0;
	}

}
