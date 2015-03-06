package backend.command;

import backend.*;

public class Repeat extends For {

	public Repeat(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute() {
		int limit = getParamValue(0).intValue();
		return forLoop(1, limit, 1, ":repcount");
	}

}
