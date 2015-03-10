package backend.command;

import java.util.ArrayList;
import java.util.List;

import backend.*;

public class Ask extends SpecifiedTurtleCommand {

	private final static int NUM_PARAMS = 2;

	public Ask(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		List<Turtle> oldActiveTurtles = activeTurtles();
		List<Turtle> askTargetTurtles = specifiedTurtles();
		grid().setActiveTurtles(askTargetTurtles);
		Double ret = paramCommandList().execute();
		grid().setActiveTurtles(oldActiveTurtles);
		return ret;
	}

	private Command paramCommandList() {
		return params.get(1);
	}

}
