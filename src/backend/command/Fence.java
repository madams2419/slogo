// This entire file is part of my masterpiece.
// Michael Adams

package backend.command;

import backend.Model;
import backend.StringPair;
import backend.FenceBoundaryHandler;

public class Fence extends ModelCommand {

	public Fence(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 0, parent, model);
	}

	public Double execute() {
		grid().setBoundaryHandler(new FenceBoundaryHandler(grid().getWidth(), grid().getHeight()));
		return 3.0;
	}

}
