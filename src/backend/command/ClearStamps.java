package backend.command;

import java.awt.Point;

import backend.Model;
import backend.StringPair;
import backend.Turtle;

public class ClearStamps extends TurtleCommand {

	private static final int NUM_PARAMS = 0;

	public ClearStamps(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		boolean stampsCleared = false;
		for(Turtle turtle : allTurtles()) {
			if(turtle.clearStamps()) stampsCleared = true;
		}
		return (stampsCleared) ? 1.0 : 0.0;
	}

}


