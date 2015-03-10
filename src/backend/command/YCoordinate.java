package backend.command;

import backend.*;

public class YCoordinate extends TurtleQuery {

	public YCoordinate(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double turtleOperation(Turtle turtle) {
		return turtle.getLocation().getY();
	}

}
