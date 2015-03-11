package backend.command;

import backend.*;

public class GetPenColor extends TurtleQuery {

	public GetPenColor(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute(Turtle t) {
		int colorIndex = colorMap().getKey(t.getPen().getColor());
		return new Double(colorIndex);
	}

}
