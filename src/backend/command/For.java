package backend.command;

import backend.*;

public class For extends ModelCommand {
	
	private static final int NUM_PARAMS = 2;
	
	public For(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		int start = getParam(0).executeParam(1).intValue();
		int end = getParam(0).executeParam(2).intValue();
		int increment = getParam(0).executeParam(3).intValue();
		String countVar = getParam(0).getParam(0).getTypedString();

		return forLoop(start, end, increment, countVar);
	}

	protected Double forLoop(int start, int end, int increment, String countVar) {
		Double returnVal = 0.0;

		for(int i = start; i <= end; i+=increment) {
			userVariables().put(countVar, new Variable(countVar, i));
			returnVal = getParam(1).execute();
		}

		return returnVal;
	}

}
