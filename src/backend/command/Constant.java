package backend.command;

import backend.StringPair;

public class Constant extends Command {

	private double value;

	public Constant(StringPair stringPair, Command parent) {
		super(stringPair, 0, parent);
		value = Double.parseDouble(stringPair.getValue());
	}

	public Double execute() {
		return value;
	}

}
