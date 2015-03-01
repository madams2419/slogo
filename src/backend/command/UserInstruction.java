package backend.command;

import java.util.ArrayList;
import java.util.HashMap;

import backend.Model;
import backend.StringPair;

public class UserInstruction extends Command {

	HashMap<String, InstructionDefinition> userCommands;

	public UserInstruction(StringPair sp, HashMap<String, InstructionDefinition> userCommands, Command parent) {
		super(sp, 2, parent);
		this.userCommands = userCommands;
	}

	public Double execute() {
		return userCommands.get(getValue()).execute((CommandList) getParam(0));
	}

}


