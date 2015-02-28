package backend.command;

import java.util.HashMap;

import backend.StringPair;

public class DoTimes extends Command {

	HashMap<String, Double> userVariables;

	public DoTimes(StringPair stringPair, HashMap<String, Double> userVariables, Command parent) {
		super(stringPair, 2, parent);
		this.userVariables = userVariables;
	}

	public Double execute() {
		int limit = getParam(0).getParamValue(1).intValue();
		String countVar = getParam(0).getParam(0).getValue();

		return doTimes(limit, countVar);
	}

	protected Double doTimes(int limit, String countVar) {
		Double returnVal = 0.0;

		for(int i = 1; i <= limit; i++) {
			// refactor duplicted code
			userVariables.put(countVar, new Double(i));
			returnVal = getParam(1).execute();
		}

		return returnVal;
	}

}
