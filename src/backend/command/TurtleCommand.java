package backend.command;

import backend.*;

public abstract class TurtleCommand extends Command {

	protected Turtle turtle;

	public TurtleCommand(StringPair stringPair, int numParams, Command parent, Turtle turtle) {
		super(stringPair, numParams, parent);
		this.turtle = turtle;
	}

}
