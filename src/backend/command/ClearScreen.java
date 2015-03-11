package backend.command;

import java.awt.Point;

import backend.Model;
import backend.StringPair;
import backend.Turtle;

public class ClearScreen extends ActiveTurtleCommand {
	 
	private static final int NUM_PARAMS = 0;

	public ClearScreen(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute(Turtle turtle) {
		turtle.clearLines();
		return turtle.jumpToPoint(new Point(0, 0));
	}

}


