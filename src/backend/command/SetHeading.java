package backend.command;

import backend.StringPair;
import backend.Turtle;

public class SetHeading extends TurtleCommand {

	public SetHeading(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, 1, parent, turtle);
	}

	public Double execute() {
		Double degrees = getParamValue(0);
		turtle.setHeading(degrees.doubleValue());
		return degrees;
	}

}


