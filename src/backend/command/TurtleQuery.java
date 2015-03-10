package backend.command;

import backend.*;

public abstract class TurtleQuery extends ActiveTurtleCommand {
	
	private final static int NUM_PARAMS = 0;

	public TurtleQuery(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

}
