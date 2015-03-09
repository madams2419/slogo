package backend.command;

import backend.*;

public abstract class TurtleCommand extends ModelCommand {

	public TurtleCommand(StringPair stringPair, int numParams, Command parent, Model model) {
		super(stringPair, numParams, parent, model);
	}

	protected Turtle activeTurtle() {
		return grid().getActiveTurtle();
	}

	protected List<Turtle> turtles() {
		return grid().getAllTurtles();
	}

}
