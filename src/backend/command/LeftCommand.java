package backend.command;

import backend.Turtle;

public class LeftCommand extends TurtleCommand {

	public LeftCommand(Turtle turtle) {
		super("LEFT", 1, turtle);
	}

	public Double execute() {
		Double degrees = getParamValue(0);
		turtle.rotateLeft(degrees.doubleValue());
		return degrees;
	}

}


