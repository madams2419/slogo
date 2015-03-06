package backend.command;

import backend.*;

public class VariableRetriever extends ModelCommand {

	private static final int NUM_PARAMS = 0;

	public VariableRetriever(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		return userVariables().get(getTypedString()).getValue();
	}

}
