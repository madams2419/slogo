package backend.command;

import java.util.HashMap;

import backend.*;

public class MakeVariable extends ModelCommand {
	
	private static final int NUM_PARAMS = 2;

	public MakeVariable(StringPair sp, Command parent, Model model) {
		super(sp, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		String name = params.get(0).getTypedString();
		Double value = params.get(1).execute();
		Variable newVar = new Variable(name, value);

		// add variable to model list
		userVariables().put(name, newVar);

		return value;
	}

}


