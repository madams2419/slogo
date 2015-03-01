package backend.command;

import java.util.HashMap;

import backend.StringPair;

public class UserInstruction extends Command {

	HashMap<String, Double> userVariables;
	HashMap<String, UserInstructionContainer> userInstructions;

	public UserInstruction(StringPair stringPair, HashMap<String, UserInstructionContainer> userInstructions, HashMap<String, Double> userVariables, Command parent) {
		super(stringPair, 2, parent);
		this.userInstructions = userInstructions;
		this.userVariables = userVariables;
	}

	public Double execute() {
		String instrName = getTypedString();

		//TODO error checking here in case command is not defined
		UserInstructionContainer uic = userInstructions.get(instrName);

		CommandList varNames = uic.getVarNames();
		CommandList varValues = (CommandList) getParam(0);
		genVariables(varNames, varValues);

		CommandList commands = uic.getCommands();

		return commands.execute();
	}

	private void genVariables(CommandList varNames, CommandList varValues) {
		for(int i = 0; i < varNames.size(); i++) {
			String varName = varNames.getParam(i).getTypedString();
			Double varValue = varValues.getParam(i).execute();
			userVariables.put(varName, varValue);
		}
	}

}


