package backend.command;

import java.util.ArrayList;
import java.util.List;
import backend.Model;
import backend.StringPair;
import backend.Turtle;

public abstract class SpecifiedTurtleCommand extends TurtleCommand {

	public SpecifiedTurtleCommand(StringPair stringPair, int numParams, Command parent, Model model) {
		super(stringPair, numParams, parent, model);
	}
	
	protected List<Turtle> specifiedTurtles() {
		List<Turtle> turtles = new ArrayList<>();
		List<Double> ids = paramTurtleIds();
		for(Double id : ids) {
			turtles.add(grid().getTurtleById(id.intValue()));
		}
		return turtles;
	}

	private List<Double> paramTurtleIds() {
		return ((CommandList)params.get(0)).executeList();
	}

}
