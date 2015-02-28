package backend.command;

import backend.StringPair;


public abstract class MathOperation extends Command {

	public MathOperation(StringPair stringPair, int numParams, Command parent) {
		super(stringPair, numParams, parent);
	}

}


