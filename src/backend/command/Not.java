package backend.command;

import backend.StringPair;

public class Not extends UnaryBooleanOperation{

	public Not(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double expr) {
		if(expr.intValue()==0){
			return (double) 1;
		}
		return (double) 0;
	}

}
