// This entire file is part of my masterpiece.
// Michael Adams

package backend;

import java.awt.Point;
import java.util.List;
import java.util.ArrayList;
import java.util.function.Supplier;

public abstract class BoundaryHandler {

	private int width;
	private int height;

	public BoundaryHandler(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public List<Movement> handleOOBMovement(Movement move, Turtle turtle) {
		List<Movement> moveList = new ArrayList<>();

		if(pointInBounds(move.getEnd())) {
			moveList.add(move);
			return moveList;
		}

		return getOOBMovements(move);
	}

	public abstract List<Movement> getOOBMovements(Movement move);

	public boolean pointInBounds(Point point) {
		return Math.abs(point.x) <= gridHalfWidth() && Math.abs(point.y) <= gridHalfHeight();
	}

	protected Point getBoundaryIntersection(Movement move) {
		double deltaGX = gridHalfWidth() - Math.abs(move.getStart().x);
		double deltaGY = gridHalfHeight() - Math.abs(move.getStart().y);
		double slope = Math.abs(move.getSlope());

		double yScaled = deltaGX * slope;
		double xScaled = deltaGY * (1 / slope);

		if(Math.abs(yScaled) <= gridHalfHeight() && Math.abs(move.getEnd().y) > gridHalfHeight()) {
			int newX = (move.getDeltaX() < 0) ? -gridHalfWidth() : gridHalfWidth();
			int newY = (move.getDeltaY() < 0) ? move.getStart().y - (int) yScaled : move.getStart().y + (int) yScaled;
			return new Point(newX, newY);
		} else if(Math.abs(xScaled) <= gridHalfWidth() && Math.abs(move.getEnd().x) > gridHalfWidth()) {
			int newX = (move.getDeltaX() < 0) ? move.getStart().x - (int) xScaled : move.getStart().y + (int) xScaled;
			int newY = (move.getDeltaY() < 0) ? -gridHalfHeight() : gridHalfHeight();
			return new Point(newX, newY);
		} else {
			return move.getEnd();
		}
	}

	protected int gridHalfWidth() {
		return width / 2;
	}

	protected int gridHalfHeight() {
		return height / 2;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
