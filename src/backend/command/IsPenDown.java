package backend.command;

import backend.*;

public class IsPenDown extends TurtleQuery {

	public IsPenDown(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, parent, turtle);
	}

	public Double execute() {
		return turtle.penStatus();
	}

}
