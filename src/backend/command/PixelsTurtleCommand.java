package backend.command;

import backend.Model;
import backend.StringPair;

public abstract class PixelsTurtleCommand extends ActiveTurtleCommand {
	
	private static final int NUM_PARAMS = 1;
	
	public PixelsTurtleCommand(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}
	
	protected Double pixels() {
		return executeParam(0);
	}

}

