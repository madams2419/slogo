package backend.command;

import java.util.HashMap;

import backend.StringPair;

public class Repeat extends DoTimes {

	public Repeat(StringPair stringPair, HashMap<String, Double> userVariables, Command parent) {
		super(stringPair, userVariables, parent);
	}

	public Double execute() {
		int limit = getParamValue(0).intValue();
		return doTimes(limit, ":repcount");
	}

}
