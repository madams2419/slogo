package backend.command;

import backend.*;

public class GetShape extends TurtleQuery {

	public GetShape(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute(Turtle t) {
		int imageMap = imageMap().getKey(t.getImageName());
		return new Double(imageMap);
	}

}
