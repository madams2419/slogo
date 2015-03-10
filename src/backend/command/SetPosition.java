package backend.command;

import backend.*;

public class SetPosition extends PointTurtleCommand {

	public SetPosition(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute(Turtle turtle) {
		return turtle.moveToPoint(point());
	}

}


