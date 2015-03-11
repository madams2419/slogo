package backend.command;

import backend.*;

public class SetPenSize extends PixelsTurtleCommand {

	public SetPenSize(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute(Turtle t) {
		Double newSize = pixels();
		t.getPen().setWidth(newSize.intValue());
		return newSize;
	}

}
