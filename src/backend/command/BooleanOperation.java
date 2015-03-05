package backend.command;

import backend.StringPair;

public abstract class BooleanOperation extends BinaryMathOperation{

	public BooleanOperation(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}
}
