package backend.command;

import backend.Turtle;

public class Forward extends TurtleCommand {

	public Forward(Turtle turtle) {
		super("FORWARD", 1, turtle);
	}

	public Double execute() {
		Double pixels = params[0].execute();
		turtle.move(pixels.intValue());
		return pixels;
	}

}


