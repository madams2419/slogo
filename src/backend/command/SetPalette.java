package backend.command;

import java.awt.Color;

import backend.*;

public class SetPalette extends ModelCommand {

	private final static int NUM_PARAMS = 4;
	private final static int INDEX_PARAM = 0;
	private final static int RED_PARAM = 1;
	private final static int GREEN_PARAM = 2;
	private final static int BLUE_PARAM = 3;

	public SetPalette(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute() {
		int index = executeParam(INDEX_PARAM).intValue();
		int red = executeParam(RED_PARAM).intValue();
		int green = executeParam(GREEN_PARAM).intValue();
		int blue = executeParam(BLUE_PARAM).intValue();
		Color newColor = new Color(red, green, blue);
		colorMap().put(index, newColor);
		return new Double(index);
	}

}
