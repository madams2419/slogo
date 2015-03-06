package backend.command;

import backend.*;

public class XCoordinate extends TurtleQuery {

	public XCoordinate(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, parent, turtle);
	}

	public Double execute() {
		return turtle.getLocation().getX();
	}

}
