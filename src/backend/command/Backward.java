package backend.command;

import backend.Turtle;

public class Backward extends TurtleCommand {

	public Backward(Turtle turtle) {
		super("BACK", 1, turtle);
	}

	public Double execute() {
		Double pixels = params[0].execute();
		turtle.move(-pixels.intValue());
		return pixels;
	}

}


