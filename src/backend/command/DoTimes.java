package backend.command;

import java.util.HashMap;

import backend.StringPair;

public class DoTimes extends For {


	public DoTimes(StringPair stringPair, HashMap<String, Double> userVariables, Command parent) {
		super(stringPair, userVariables, parent);
	}

	public Double execute() {
		int limit = getParam(0).getParamValue(1).intValue();
		String countVar = getParam(0).getParam(0).getValue();

		return forLoop(1, limit, 1, countVar);
	}


}
