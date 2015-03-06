package backend.command;

import backend.*;

public class IsShowing extends TurtleQuery {

	public IsShowing(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute() {
		return turtle().isShowing();
	}

}
