package backend.command;

import java.util.HashMap;

import backend.StringPair;

public class For extends Command {
	HashMap<String, Double> userVariables;
	
	public For(StringPair stringPair, HashMap<String, Double> userVariables, Command parent) {
		super(stringPair, 2, parent);
		this.userVariables = userVariables;
	}

	public Double execute() {
		int start = getParam(0).getParamValue(1).intValue();
		int end = getParam(0).getParamValue(2).intValue();
		int increment = getParam(0).getParamValue(3).intValue();
		String countVar = getParam(0).getParam(0).getTypedString();

		return forLoop(start, end, increment, countVar);
	}

	protected Double forLoop(int start, int end, int increment, String countVar) {
		Double returnVal = 0.0;

		for(int i = start; i <= end; i+=increment) {
			userVariables.put(countVar, new Double(i));
			returnVal = getParam(1).execute();
		}

		return returnVal;
	}

}
