package backend.command;

import java.util.List;

import backend.Model;
import backend.StringPair;
import backend.Turtle;

public abstract class ActiveTurtleCommand extends TurtleCommand {

	public ActiveTurtleCommand(StringPair stringPair, int numParams, Command parent, Model model) {
		super(stringPair, numParams, parent, model);
	}

	protected abstract Double execute(Turtle turtle);

	@Override
	public Double execute() {
		List<Turtle> activeTurtles = activeTurtles();
		Double ret = 0.0;
		for(Turtle turtle : activeTurtles) {
			grid().setActiveTurtle(turtle);
			ret = execute(turtle);
		}
		return ret;
	}

}
