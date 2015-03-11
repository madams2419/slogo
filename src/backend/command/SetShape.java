package backend.command;

import backend.*;

public class SetShape extends ActiveTurtleCommand {

	private final static int NUM_PARAMS = 1;
	private final static int SHAPE_PARAM = 0;

	public SetShape(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	public Double execute(Turtle turtle) {
		String newImageName = paramToImage(SHAPE_PARAM);
		turtle.setImageByName(newImageName);
		return getParamReturnVal(SHAPE_PARAM);
	}

}
