package backend.command;

import java.awt.Point;
import backend.*;

public class SetTowards extends TurtleCommand {

	public SetTowards(StringPair stringPair, Command parent, Model model) {
		super(stringPair, 2, parent, model);
	}

	public Double execute() {
		int x = params.get(0).execute().intValue();
		int y = params.get(1).execute().intValue();
		return turtle().faceTowards(new Point(x,y));
	}

}


