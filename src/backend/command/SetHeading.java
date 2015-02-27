package backend.command;

import backend.Turtle;

public class SetHeading extends TurtleCommand {

	public SetHeading(Turtle turtle) {
		super("SETHEADING", 1, turtle);
	}

	public Double execute() {
		Double degrees = getParamValue(0);
		turtle.setHeading(degrees.doubleValue());
		return degrees;
	}

}


