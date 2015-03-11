package backend.command;

import java.awt.Point;

import backend.Model;
import backend.StringPair;
import backend.Turtle;

public class ClearScreen extends ActiveTurtleCommand {

	public ClearScreen(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 0, parent, model);
	}

	public Double execute(Turtle turtle) {
		turtle.clearLines();
		return turtle.jumpToPoint(new Point(0, 0));
	}

}


