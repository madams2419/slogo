package backend.command;

import java.util.HashMap;

import backend.StringPair;

public class MakeUserInstruction extends Command {

	HashMap<String, Double> userVariables;
	HashMap<String, Command> userInstructions;

	public MakeUserInstruction(StringPair stringPair, HashMap<String, Command> userInstructions, HashMap<String, Double> userVariables, Command parent) {
		super(stringPair, 3, parent);
		this.userInstructions = userInstructions;
		this.userVariables = userVariables;
	}

	public Double execute() {
		String instName = getParam(0).getValue();
		CommandList paramNames = (CommandList) getParam(1);
		CommandList commandList = (CommandList) getParam(2);
		StringPair newSP = new StringPair("Command", instName);

		InstructionDefinition newInstDef = new InstructionDefinition(newSP, paramNames, commandList, userVariables, null);

		// add instruction definition to model list
		userInstructions.put(instName, newInstDef);

		return 1.0;
	}

}
