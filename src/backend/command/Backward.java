package backend.command;

import backend.*;

public class Backward extends PixelsTurtleCommand {

	public Backward(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	protected Double execute(Turtle turtle) {
		return turtle.move(-pixels());
	}

}


