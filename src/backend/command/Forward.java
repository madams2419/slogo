package backend.command;

import backend.*;

public class Forward extends TurtleCommand {

	private static final int NUM_PARAMS = 1;

	public Forward(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	protected Double execute(Turtle turtle) {
		return turtle.move(paramDistance());
	}

	private Double paramDistance() {
		return params.get(0).execute();
	}

}


