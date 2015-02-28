package backend.command;

import java.util.HashMap;

import backend.StringPair;

public class Repeat extends For {

	public Repeat(StringPair stringPair, HashMap<String, Double> userVariables, Command parent) {
		super(stringPair, userVariables, parent);
	}

	public Double execute() {
		int limit = getParamValue(0).intValue();
		return forLoop(1, limit, 1, ":repcount");
	}

}
