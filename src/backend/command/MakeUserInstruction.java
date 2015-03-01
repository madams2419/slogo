package backend.command;

import java.util.HashMap;

import backend.StringPair;

public class MakeUserInstruction extends Command {

	HashMap<String, Double> userVariables;
	HashMap<String, UserInstructionContainer> userInstructions;

	public MakeUserInstruction(StringPair stringPair, HashMap<String, UserInstructionContainer> userInstructions, HashMap<String, Double> userVariables, Command parent) {
		super(stringPair, 3, parent);
		this.userInstructions = userInstructions;
		this.userVariables = userVariables;
	}

	public Double execute() {
		String instName = getParam(0).getTypedString();
		CommandList paramNames = (CommandList) getParam(1);
		CommandList commandList = (CommandList) getParam(2);
		UserInstructionContainer newUIC = new UserInstructionContainer(paramNames, commandList);

		// add instruction definition to model list
		userInstructions.put(instName, newUIC);

		return 1.0;
	}

}
