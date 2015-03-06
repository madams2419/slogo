package backend.command;

import java.util.HashMap;
import backend.*;

public class VariableRetriever extends Command {

	HashMap<String, Variable> userVariables;

	public VariableRetriever(StringPair stringPair, HashMap<String, Variable> userVariables, Command parent) {
		super(stringPair, 0, parent);
		this.userVariables = userVariables;
	}

	public Double execute() {
		return userVariables.get(getTypedString()).getValue();
	}

}
