package backend.command;

import java.awt.Color;

import backend.*;

public class SetPenColor extends ActiveTurtleCommand {

	private final static int NUM_PARAMS = 1;
	private final static int COLOR_PARAM = 0;

	public SetPenColor(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute(Turtle t) {
		Color newPenColor = paramToColor(COLOR_PARAM);
		t.getPen().setColor(newPenColor);
		return getParamReturnVal(COLOR_PARAM);
	}

}
