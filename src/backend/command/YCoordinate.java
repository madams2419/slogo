package backend.command;

import backend.*;

public class YCoordinate extends TurtleQuery {

	public YCoordinate(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, parent, turtle);
	}

	public Double execute() {
		return turtle.getLocation().getY();
	}

}
