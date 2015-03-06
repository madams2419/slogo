package backend.command;

import backend.*;

public class Backward extends TurtleCommand {

	public Backward(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 1, parent, model);
	}

	public Double execute() {
		Double pixels = params.get(0).execute();
		turtle().move(-pixels);
		return pixels;
	}

}


