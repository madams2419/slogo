package backend.command;

import backend.*;
import java.util.*;

public class Tell extends TurtleCommand {

	private final static int NUM_PARAMS = 1;

	public Tell(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		return grid().setActiveTurtles(newActiveTurtles());
	}

	private List<Turtle> newActiveTurtles() {
		List<Turtle> turtles = new ArrayList<>();
		List<Double> ids = newActiveTurtleIds();
		for(Double id : ids) {
			turtles.add(grid().getTurtleById(id.intValue()));
		}
		return turtles;
	}

	private List<Double> newActiveTurtleIds() {
		return ((CommandList)params.get(0)).executeList();
	}

}
