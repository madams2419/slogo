package backend.command;

import java.util.HashMap;

import backend.Model;
import backend.StringPair;

public class MakeVariable extends Command {

	HashMap<String, Double> userVariables;

	public MakeVariable(StringPair sp, HashMap<String, Double> userVariables, Command parent) {
		super(sp, 2, parent);
		this.userVariables = userVariables;
	}

	public Double execute() {
		Double value = params.get(1).execute();

		// add variable to model list
		userVariables.put(params.get(0).getTypedString(), value);

		return value;
	}

}


