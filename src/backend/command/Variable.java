package backend.command;

import java.util.HashMap;
import backend.StringPair;

public class Variable extends Command {

	HashMap<String, Double> userVariables;

	public Variable(StringPair stringPair, HashMap<String, Double> userVariables, Command parent) {
		super(stringPair, 0, parent);
		this.userVariables = userVariables;
	}

	public Double execute() {
		return userVariables.get(getTypedString());
	}

}
