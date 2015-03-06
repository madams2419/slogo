package backend.command;

import backend.*;

public abstract class TurtleQuery extends TurtleCommand {

	public TurtleQuery(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, 0, parent, turtle);
	}

}
