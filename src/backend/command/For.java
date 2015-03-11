package backend.command;

import backend.*;

public class For extends ModelCommand {
	
	private static final int NUM_PARAMS = 2;
	
	public For(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		return forLoop(start(), end(), increment(), countVar());
	}

	protected Double forLoop(int start, int end, int increment, String countVar) {
		Double returnVal = 0.0;
		for(int i = start; i <= end; i+=increment) {
			userVariables().put(countVar, new Variable(countVar, i));
			returnVal = getParam(1).execute();
		}
		return returnVal;
	}
	
	protected String countVar() {
		return forVarList().getParam(0, VariableRetriever.class).getTypedString();
	}
	
	protected int start() {
		return forVarList().executeParam(1).intValue();
	}
	
	protected int end() {
		return forVarList().executeParam(2).intValue();
	}
	
	protected int increment() {
		return forVarList().executeParam(3).intValue();
	}
	
	protected CommandList forVarList() {
		return getParam(0, CommandList.class);
	}

}
