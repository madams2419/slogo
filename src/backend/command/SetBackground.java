package backend.command;

import backend.*;

public class SetBackground extends ModelCommand {

	private final static int NUM_PARAMS = 1;

	public SetBackground(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		Color newBGColor = colorMap.getValue(colorIndex());
		grid().setBGColor(newBGColor);
	}

	public int colorIndex() {
		return executeParam(0).intValue();
	}

}
