package backend.command;

import java.awt.Point;
import backend.*;

public class SetPosition extends TurtleCommand {

	public SetPosition(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 2, parent, model);
	}

	public Double execute() {
		return turtle().moveToPoint(getNewPosition());
	}

	private Point getNewPosition() {
		int x = params.get(0).execute().intValue();
		int y = params.get(1).execute().intValue();
		return new Point(x, y);
	}

}


