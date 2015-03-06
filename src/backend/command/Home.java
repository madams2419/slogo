package backend.command;

import java.awt.Point;

import backend.*;

public class Home extends TurtleCommand {

	public Home(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 0, parent, model);
	}

	public Double execute() {
		return turtle().moveToPoint(new Point(0, 0));
	}

}


