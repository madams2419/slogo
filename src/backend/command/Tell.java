package backend.command;

import backend.*;

public class Tell extends TurtleCommand {

	private final static int NUM_PARAMS = 1;

	public Tell(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		List<Double> turtleIDs = newActiveTurtleIds();
		grid().setActiveTurtles(newActiveTurtleIds());
	}

	public List<Double> newActiveTurtleIds() {
		return params.get(0).executeList();
	}

}
