package backend.command;

import backend.StringPair;

public abstract class BooleanOperation extends Command{

	public BooleanOperation(StringPair stringPair, int numParams, Command parent) {
		super(stringPair, 2, parent);
	}

}
