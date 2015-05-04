// This entire file is part of my masterpiece.
// Michael Adams

package backend.command;

import backend.Model;
import backend.StringPair;
import backend.WindowBoundaryHandler;

public class Window extends ModelCommand {

	public Window(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 0, parent, model);
	}

	public Double execute() {
		grid().setBoundaryHandler(new WindowBoundaryHandler(grid().getWidth(), grid().getHeight()));
		return 2.0;
	}

}
