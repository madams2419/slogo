package backend.command;

import backend.*;

public class PenDown extends TurtleCommand {

	public PenDown(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 0, parent, model);
	}

	public Double execute() {
		return turtle().setPenDown();
	}

}


