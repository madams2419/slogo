// This entire file is part of my masterpiece.
// Michael Adams

package backend;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class WindowBoundaryHandler extends BoundaryHandler {


	public WindowBoundaryHandler(int width, int height) {
		super(width, height);
	}

	public List<Movement> handleOOBMovement(Movement move, Turtle turtle) {
		if(pointInBounds(move.getEnd())) {
			if(!pointInBounds(move.getStart())) {
				turtle.show();
			}
		} else {
			turtle.hide();
		}

		return super.handleOOBMovement(move, turtle);
	}

	public List<Movement> getOOBMovements(Movement move) {
		List<Movement> moveList = new ArrayList<>();
		moveList.add(move);
		return moveList;
	}

}
