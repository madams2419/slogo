package backend.command;

public class UserInstructionContainer {

	private CommandList varNames;
	private CommandList commands;

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
