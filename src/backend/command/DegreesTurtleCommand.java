package backend.command;

import backend.Model;
import backend.StringPair;

public abstract class DegreesTurtleCommand extends ActiveTurtleCommand {
	
	private static final int NUM_PARAMS = 1;
	
	public DegreesTurtleCommand(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}
	
	protected Double degrees() {
		return executeParam(0);
	}

}

