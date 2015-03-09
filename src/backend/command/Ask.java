package backend.command;

import backend.*;

public class Ask extends TurtleCommand {

	private final static int NUM_PARAMS = 2;

	public Ask(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {

	}

}
