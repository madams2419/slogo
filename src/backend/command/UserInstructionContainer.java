package backend.command;

public class UserInstructionContainer {

	private CommandList varNames;
	private CommandList commands;

	//TODO refactor this to UserInstruction class (refactor UserInstruction class to UserInstructionExecutor) and provide ToString method to return the entire formatted method
	public UserInstructionContainer(CommandList vars, CommandList coms) {
		varNames = vars;
		commands = coms;
	}

	public CommandList getVarNames() {
		return varNames;
	}

	public CommandList getCommands() {
		return commands;
	}

}
