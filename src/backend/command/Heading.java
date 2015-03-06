package backend.command;

import backend.*;

public class Heading extends TurtleQuery {

	public Heading(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, parent, turtle);
	}

	public Double execute() {
		return turtle.getHeading().getAngle();
	}

}
