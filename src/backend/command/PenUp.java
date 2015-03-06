package backend.command;

import backend.StringPair;
import backend.Turtle;

public class PenUp extends TurtleCommand {

	public PenUp(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, 0, parent, turtle);
	}

	public Double execute() {
		return turtle.setPenUp();
	}

}


