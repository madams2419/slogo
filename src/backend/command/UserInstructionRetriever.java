package backend.command;

import java.util.ArrayList;
import backend.*;

public class UserInstructionRetriever extends ModelCommand {
	
	private static final int NUM_PARAMS = 0;

	public UserInstructionRetriever(StringPair stringPair, Command parent, Model model) throws NullPointerException{
		super(stringPair, NUM_PARAMS, parent, model);

		if(parent == null || !parent.getProperty().equals("MakeUserInstruction")) {
			if(uic() == null) {
				throw new NullPointerException("Command not Found");
			} else {
				numParams = getNumParams();
			}
		}
	}

	private UserInstructionContainer uic() {
		return userInstructions().get(getTypedString());
	}

	private int getNumParams() {
		return uic().getVarNames().size();
	}

	public Double execute() {
		CommandList varNames = uic().getVarNames();
		ArrayList<Command> varValues = params;
		genVariables(varNames, varValues);

		CommandList commands = uic().getCommands();

		return commands.execute();
	}

	private void genVariables(CommandList varNames, ArrayList<Command> varValues) {
		for(int i = 0; i < varNames.size(); i++) {
			String varName = varNames.getParam(i).getTypedString();
			Double varValue = varValues.get(i).execute();
			Variable newVar = new Variable(varName, varValue);
			userVariables().put(varName, newVar);
		}
	}

}


