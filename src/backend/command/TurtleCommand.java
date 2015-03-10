package backend.command;

import java.util.List;
import backend.*;

public abstract class TurtleCommand extends ModelCommand {

	public TurtleCommand(StringPair stringPair, int numParams, Command parent, Model model) {
		super(stringPair, numParams, parent, model);
	}

	protected List<Turtle> allTurtles() {
		return grid().getAllTurtles();
	}

	protected List<Turtle> activeTurtles() {
		return grid().getActiveTurtles();
	}

}
