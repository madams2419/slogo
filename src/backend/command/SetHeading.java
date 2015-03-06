package backend.command;

import backend.*;

public class SetHeading extends TurtleCommand {

	public SetHeading(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 1, parent, model);
	}

	public Double execute() {
		Double degrees = getParamValue(0);
		turtle().setHeading(degrees.doubleValue());
		return degrees;
	}

}


