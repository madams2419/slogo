package backend.command;

import backend.*;

public class PenUp extends ActiveTurtleCommand {

	public PenUp(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 0, parent, model);
	}

	public Double execute(Turtle turtle) {
		return turtle.setPenUp();
	}

}


