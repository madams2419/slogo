package backend.command;

import backend.*;

public class PenDown extends ActiveTurtleCommand {

	public PenDown(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 0, parent, model);
	}

	public Double execute(Turtle turtle) {
		return turtle.setPenDown();
	}

}


