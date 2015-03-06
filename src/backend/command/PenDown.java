package backend.command;

import backend.StringPair;
import backend.Turtle;

public class PenDown extends TurtleCommand {

	public PenDown(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, 0, parent, turtle);
	}

	public Double execute() {
		return turtle.setPenDown();
	}

}


