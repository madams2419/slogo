// This entire file is part of my masterpiece.
// Michael Adams

package backend;

import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;

public class FenceBoundaryHandler extends BoundaryHandler {

	public FenceBoundaryHandler(int width, int height) {
		super(width, height);
	}

	public List<Movement> getOOBMovements(Movement move) {
		List<Movement> moveList = new ArrayList<>();
		Point boundPnt = getBoundaryIntersection(move);
		Movement bndryMove = new Movement(move.getStart(), boundPnt);
		moveList.add(bndryMove);
		return moveList;
	}

}









