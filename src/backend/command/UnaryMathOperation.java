package backend.command;

import backend.StringPair;

public abstract class UnaryMathOperation extends Command {

	public UnaryMathOperation(StringPair stringPair, Command parent) {
		super(stringPair, 1, parent);
	}

	public Double execute() {
		return operate(params.get(0).execute());
	}

	public abstract Double operate(Double expr);

}


