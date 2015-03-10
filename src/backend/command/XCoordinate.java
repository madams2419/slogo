package backend.command;

import backend.*;

public class XCoordinate extends TurtleQuery {

	public XCoordinate(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute(Turtle turtle) {
		return turtle.getLocation().getX();
	}

}
