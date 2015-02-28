package backend.command;

import backend.StringPair;

public abstract class BinaryMathOperation extends Command {
	
	public BinaryMathOperation(StringPair stringPair, Command parent) {
		super(stringPair, 2, parent);
	}

	public Double execute() {
		return operate(params.get(0).execute(), params.get(1).execute());
	}

	public abstract Double operate(Double expr1, Double expr2);

}


