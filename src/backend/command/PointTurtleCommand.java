package backend.command;

import java.awt.Point;

import backend.Model;
import backend.StringPair;

public abstract class PointTurtleCommand extends ActiveTurtleCommand {
	
	private static final int NUM_PARAMS = 2;
	
	public PointTurtleCommand(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}
	
	protected Point point() {
		int xCoord = executeParam(0).intValue();
		int yCoord = executeParam(1).intValue();
		return new Point(xCoord, yCoord);
	}

}
