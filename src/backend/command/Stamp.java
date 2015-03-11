package backend.command;

import backend.Model;
import backend.StringPair;
import backend.Turtle;

public class Stamp extends GetShape {

	public Stamp(StringPair stringPair, Command parent, Model model) {
		super(stringPair, parent, model);
	}

	public Double execute(Turtle turtle) {
		turtle.stamp();
		return super.execute(turtle);
	}

}


