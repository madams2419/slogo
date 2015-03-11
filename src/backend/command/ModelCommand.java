package backend.command;

import java.awt.Color;
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

	protected BiMap<Integer, Color> colorMap() {
		return model.getColorMap();
	}

	protected BiMap<Integer, String> imageMap() {
		return model.getImageMap();
	}

	protected Color paramToColor(int paramIndex) {
		int colorIndex = executeParam(paramIndex).intValue();
		return colorMap().getValue(colorIndex);
	}

	protected String paramToImage(int paramIndex) {
		int imageIndex = executeParam(paramIndex).intValue();
		return imageMap().getValue(imageIndex);
	}

}
