package backend.command;

import backend.Turtle;

public class SetHeadingCommand extends TurtleCommand {

	public SetHeadingCommand(Turtle turtle) {
		super("SETHEADING", 1, turtle);
	}

	public Double execute() {
		Double degrees = getParamValue(0);
		turtle.setHeading(degrees.doubleValue());
		return degrees;
	}

}


