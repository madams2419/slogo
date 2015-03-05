package backend.command;

import backend.StringPair;

public abstract class BinaryBooleanOperation extends BinaryMathOperation{

	public BinaryBooleanOperation(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}
}
