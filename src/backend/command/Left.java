package backend.command;

import backend.*;

public class Left extends DegreesTurtleCommand {
	
	public Left(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute(Turtle turtle) {
		return turtle.rotateLeft(degrees());
	}

}


