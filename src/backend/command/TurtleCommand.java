package backend.command;

import backend.Turtle;

public abstract class TurtleCommand extends Command {

	protected Turtle turtle;

	public TurtleCommand(String name, int numParams, Turtle turtle) {
		super(name, numParams);
		this.turtle = turtle;
	}

}
