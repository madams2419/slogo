package backend.command;

import backend.*;

public class Heading extends TurtleQuery {

	public Heading(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute() {
		return turtle().getHeading().getAngle();
	}

}
