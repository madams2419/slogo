package backend.command;

import backend.*;

public class Left extends TurtleCommand {
	
	public Left(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, 1, parent, turtle);
	}

	public Double execute() {
		Double degrees = getParamValue(0);
		turtle.rotateLeft(degrees.doubleValue());
		return degrees;
	}

}


