package backend.command;

import backend.*;

public class Heading extends TurtleQuery {

	public Heading(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute(Turtle turtle) {
		return turtle.getHeading().getAngle();
	}

}
