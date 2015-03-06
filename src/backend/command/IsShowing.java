package backend.command;

import backend.*;

public class IsShowing extends TurtleQuery {

	public IsShowing(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, parent, turtle);
	}

	public Double execute() {
		return turtle.isShowing();
	}

}
