package backend.command;

import backend.*;

public class Backward extends TurtleCommand {

	public Backward(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, 1, parent, turtle);
	}

	public Double execute() {
		Double pixels = params.get(0).execute();
		turtle.move(-pixels.intValue());
		return pixels;
	}

}


