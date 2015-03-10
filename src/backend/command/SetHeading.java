package backend.command;

import backend.*;

public class SetHeading extends DegreesTurtleCommand {

	public SetHeading(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute(Turtle turtle) {
		return turtle.setHeading(degrees());
	}

}


