package backend.command;

import backend.Turtle;

public abstract class TurtleCommand extends Command {

	protected Turtle turtle;

	public TurtleCommand(String name, int numParams, Command parent, Turtle turtle) {
		super(name, numParams, parent);
		this.turtle = turtle;
	}

}
