package backend.command;

import java.awt.Point;

import backend.StringPair;
import backend.Turtle;

public class Home extends TurtleCommand {

	public Home(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, 0, parent, turtle);
	}

	public Double execute() {
		return turtle.moveToPoint(new Point(0, 0));
	}

}


