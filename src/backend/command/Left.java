package backend.command;

import backend.Turtle;

public class Left extends TurtleCommand {

	public Left(Turtle turtle) {
		super("LEFT", 1, turtle);
	}

	public Double execute() {
		Double degrees = getParamValue(0);
		turtle.rotateLeft(degrees.doubleValue());
		return degrees;
	}

}


