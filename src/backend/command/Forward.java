package backend.command;

import backend.*;

public class Forward extends PixelsTurtleCommand {

	public Forward(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	protected Double execute(Turtle turtle) {
		return turtle.move(pixels());
	}

}


