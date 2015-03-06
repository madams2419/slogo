package backend.command;

import java.awt.Point;

import backend.Model;
import backend.StringPair;
import backend.Turtle;

public class ClearScreen extends TurtleCommand {

	public ClearScreen(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 0, parent, model);
	}

	public Double execute() {
		double distanceMoved = turtle().moveToPoint(new Point(0, 0));
		turtle().clearLines();
		return distanceMoved;
	}

}


