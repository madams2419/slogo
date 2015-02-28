package backend.command;

import backend.StringPair;
import backend.Turtle;

public class Right extends TurtleCommand {

	public Right(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, 1, parent, turtle);
	}

	public Double execute() {
		Double degrees = getParamValue(0);
		turtle.rotateRight(degrees.doubleValue());
		return degrees;
	}

}


