package backend.command;

import java.util.ArrayList;
import java.util.HashMap;

import backend.*;

public class UserInstructionRetriever extends Command {

	HashMap<String, Variable> userVariables;
	HashMap<String, UserInstructionContainer> userInstructions;
	UserInstructionContainer uic;

	public UserInstructionRetriever(StringPair stringPair, HashMap<String, UserInstructionContainer> userInstructions, HashMap<String, Variable> userVariables, Command parent) {
		super(stringPair, 0, parent);
		this.userInstructions = userInstructions;
		this.userVariables = userVariables;

		if(parent == null || !parent.getProperty().equals("MakeUserInstruction"))
			if((uic = getUIC()) == null)
				System.out.println("Error: No command defintion found."); //TODO proper error handling
			else
				numParams = getNumParams();
	}

	private UserInstructionContainer getUIC() {
		return userInstructions.get(getTypedString());
	}

	private int getNumParams() {
		return uic.getVarNames().size();
	}

	public Double execute() {
		CommandList varNames = uic.getVarNames();
		ArrayList<Command> varValues = params;
		genVariables(varNames, varValues);

		CommandList commands = uic.getCommands();

		return commands.execute();
	}

	private void genVariables(CommandList varNames, ArrayList<Command> varValues) {
		for(int i = 0; i < varNames.size(); i++) {
			String varName = varNames.getParam(i).getTypedString();
			Double varValue = varValues.get(i).execute();
			Variable newVar = new Variable(varName, varValue);
			userVariables.put(varName, newVar);
		}
	}

}


