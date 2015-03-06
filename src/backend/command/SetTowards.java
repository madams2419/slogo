package backend.command;

import java.awt.Point;

import backend.StringPair;
import backend.Turtle;

public class SetTowards extends TurtleCommand {

	public SetTowards(StringPair stringPair, Command parent, Turtle turtle) {
		super(stringPair, 2, parent, turtle);
	}

	public Double execute() {
		int x = params.get(0).execute().intValue();
		int y = params.get(1).execute().intValue();
		return turtle.faceTowards(new Point(x,y));
	}

}


