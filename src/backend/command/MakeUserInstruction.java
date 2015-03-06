package backend.command;

import backend.*;

public class MakeUserInstruction extends ModelCommand {

	private static int NUM_PARAMS = 3;

	public MakeUserInstruction(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	@Override
	public void setParam(Command newParam) {
		super.setParam(newParam);

		if(params.size() == NUM_PARAMS) {
			addToInstrList();
		}
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
		userInstructions().put(instName, newUIC);
	}

}
