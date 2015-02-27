package backend.command;

import backend.Turtle;

public class Right extends TurtleCommand {

	public Right(Turtle turtle) {
		super("RIGHT", 1, turtle);
	}

	public Double execute() {
		Double degrees = getParamValue(0);
		turtle.rotateRight(degrees.doubleValue());
		return degrees;
	}

}


