package backend.command;

import java.util.Map;

import backend.*;

public abstract class ModelCommand extends Command {

	private Model model;

	public ModelCommand(StringPair stringPair, int numParams, Command parent, Model model) {
		super(stringPair, numParams, parent);
		this.model = model;
	}

	protected Map<String, Variable> userVariables() {
		return model.getUserVariables();
	}

	protected Map<String, UserInstructionContainer> userInstructions() {
		return model.getUserFunctions();
	}

	protected Grid grid() {
		return model.getGrid();
	}

}
