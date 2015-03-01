package backend.command;

import java.util.ArrayList;
import java.util.HashMap;

import backend.Model;
import backend.StringPair;
import backend.command.*;

public class InstructionDefinition extends Command {

	HashMap<String, Double> userVariables;
	CommandList paramNames;
	CommandList commandList;

	public InstructionDefinition(StringPair sp, CommandList paramNames, CommandList commandList, HashMap<String, Double> userVariables, Command parent) {
		super(sp, 0, parent);
		this.paramNames = paramNames;
		this.commandList = commandList;
		this.userVariables = userVariables;
	}

	public Double execute() {
		return 0.0;
	}

	public Double execute(CommandList paramValues) {
		genVariables(paramValues.getParams());
		return commandList.execute();
	}

	private void genVariables(ArrayList<Command> paramValues) {
		int count = 0;
		for(Command variable : paramValues) {
			String varName = paramNames.getParam(count).getValue();
			Double varValue = variable.execute();
			userVariables.put(varName, varValue);
			count++;
		}
	}

}


