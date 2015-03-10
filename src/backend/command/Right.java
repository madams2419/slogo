package backend.command;

import backend.*;

public class Right extends DegreesTurtleCommand {

	public Right(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}
	
	public Double execute(Turtle turtle) {
		return turtle.rotateRight(degrees());
	}

}


