package backend.command;

import backend.*;

public class ID extends TurtleCommand {

	private final static int NUM_PARAMS = 0;

	public ID(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		return new Double(activeTurtle().getID());
	}

}
