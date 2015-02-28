package backend.command;

import java.util.HashMap;

import backend.StringPair;

public class Repeat extends Command {

	HashMap<String, Double> userVariables;

	public Repeat(StringPair stringPair, HashMap<String, Double> userVariables, Command parent) {
		super(stringPair, 2, parent);
		this.userVariables = userVariables;
	}

	public Double execute() {
		int numReps = getParamValue(0).intValue();
		Double returnVal = 0.0;

		for(int i = 1; i <= numReps; i++) {
			// refactor duplicted code
			userVariables.put(":repcount", new Double(i));
			returnVal = getParamValue(1);
		}

		return returnVal;
	}

}
