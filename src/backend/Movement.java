package backend;

import java.awt.*;

public class Movement {

	private Point start;
	private Point end;

	public Movement(Point start, Point end) {
		this.start = start;
		this.end= end;
	}

	public Point getStart() {
		return start;
	}

	public Point getEnd() {
		return end;
	}

	public double getDeltaX() {
		return end.x - start.x;
	}

	public double getDeltaY() {
		return end.y - start.y;
	}

	public double getSlope() {
		return getDeltaY() / getDeltaX();
	}

}
