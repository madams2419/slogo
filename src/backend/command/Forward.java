package backend.command;

import backend.StringPair;
import backend.Turtle;

public class Forward extends TurtleCommand {

	public Forward(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, 1, parent, turtle);
	}

	public Double execute() {
		Double pixels = params.get(0).execute();
		turtle.move(pixels.intValue());
		return pixels;
	}

}


