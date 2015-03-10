package backend.command;

import backend.*;

public class SetTowards extends PointTurtleCommand {

	public SetTowards(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute(Turtle turtle) {
		return turtle.faceTowards(point());
	}

}


