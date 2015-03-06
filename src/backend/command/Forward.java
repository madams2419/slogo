package backend.command;

import backend.*;

public class Forward extends TurtleCommand {
	
	private static final int NUM_PARAMS = 1;

	public Forward(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		Double pixels = params.get(0).execute();
		turtle().move(pixels);
		return pixels;
	}

}


