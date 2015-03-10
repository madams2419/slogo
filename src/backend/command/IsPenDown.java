package backend.command;

import backend.*;

public class IsPenDown extends TurtleQuery {

	public IsPenDown(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute(Turtle turtle) {
		return turtle.isPenDown();
	}

}
