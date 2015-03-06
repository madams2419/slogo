package backend.command;

import backend.*;

public class Right extends TurtleCommand {

	public Right(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 1, parent, model);
	}

	public Double execute() {
		Double degrees = getParamValue(0);
		turtle().rotateRight(degrees.doubleValue());
		return degrees;
	}

}


