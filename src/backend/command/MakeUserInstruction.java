package backend.command;

import java.util.HashMap;

import backend.*;

public class MakeUserInstruction extends Command {

	HashMap<String, Variable> userVariables;
	HashMap<String, UserInstructionContainer> userInstructions;

	//TODO to support recursion, must add self to userInstruction list as soon as params are set

	public MakeUserInstruction(StringPair stringPair, HashMap<String, UserInstructionContainer> userInstructions, HashMap<String, Variable> userVariables, Command parent) {
		super(stringPair, 3, parent);
		this.userInstructions = userInstructions;
		this.userVariables = userVariables;
	}

	@Override
	public void setParam(Command newParam) {
		super.setParam(newParam);

		if(params.size() == 3)
			addToInstrList();

	}

	public Double execute() {
		return 0.0;
	}

	private void addToInstrList() {
		String instName = getParam(0).getTypedString();
		CommandList paramNames = (CommandList) getParam(1);
		CommandList commandList = (CommandList) getParam(2);
		UserInstructionContainer newUIC = new UserInstructionContainer(paramNames, commandList);

		// add instruction definition to model list
		userInstructions.put(instName, newUIC);
	}

}
