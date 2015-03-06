package backend.command;

import java.util.HashMap;

import backend.*;

public class MakeVariable extends Command {

	HashMap<String, Variable> userVariables;

	public MakeVariable(StringPair sp, HashMap<String, Variable> userVariables, Command parent) {
		super(sp, 2, parent);
		this.userVariables = userVariables;
	}

	public Double execute() {
		String name = params.get(0).getTypedString();
		Double value = params.get(1).execute();
		Variable newVar = new Variable(name, value);

		// add variable to model list
		userVariables.put(name, newVar);

		return value;
	}

}


