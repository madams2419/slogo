package backend.command;

import java.awt.Point;

import backend.StringPair;
import backend.Turtle;

public class SetPosition extends TurtleCommand {

	public SetPosition(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, 2, parent, turtle);
	}

	public Double execute() {
		return turtle.moveToPoint(getNewPosition());
	}

	private Point getNewPosition() {
		int x = params.get(0).execute().intValue();
		int y = params.get(1).execute().intValue();
		return new Point(x, y);
	}

}


