package backend.command;

import backend.Turtle;

public class Forward extends TurtleCommand {

	public Forward(Command parent, Turtle turtle) {
		super("FORWARD", 1, parent, turtle);
	}

	public Double execute() {
		Double pixels = params[0].execute();
		System.out.println("Pixels: " + pixels);
		turtle.move(pixels.intValue());
		return pixels;
	}

}


