package backend.command;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import backend.*;

public abstract class TurtleCommand extends ModelCommand {

	public TurtleCommand(StringPair stringPair, int numParams, Command parent, Model model) {
		super(stringPair, numParams, parent, model);
	}

	protected abstract Double turtleOperation(Turtle activeTurtle);

	@Override
	public Double execute() {
		return doForAllActiveTurtles(turtle -> turtleOperation(turtle));
	}

	protected Double doForAllActiveTurtles(Function<Turtle, Double> function) {
		List<Turtle> activeTurtles = activeTurtles();
		Double ret = 0.0;
		for(Turtle turtle : activeTurtles) {
			grid().setActiveTurtle(turtle);
			ret = function.apply(turtle);
		}
		return ret;
	}

	protected List<Turtle> allTurtles() {
		return grid().getAllTurtles();
	}

	protected List<Turtle> activeTurtles() {
		return grid().getActiveTurtles();
	}

}
