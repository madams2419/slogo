package backend.command;

import backend.*;

public class Home extends ActiveTurtleCommand {
	
	private final static int NUM_PARAMS = 0;

	public Home(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute(Turtle turtle) {
		return turtle.moveToPoint(Constants.TURTLE_START_POINT);
	}

}


