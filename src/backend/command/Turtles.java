package backend.command;

import backend.*;

public class Turtles extends TurtleCommand {

	private final static int NUM_PARAMS = 0;

	public Turtles(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		return new Double(turtles().size());
	}

}
