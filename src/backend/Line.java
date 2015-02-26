package backend;

import java.awt.*;
import java.awt.geom.Line2D;
import javafx.scene.paint.Color;

public class Line extends Line2D.Double {

	private static final long serialVersionUID = 1;
	private Color color;

	public Line(Point start, Point end, Color color) {
		super(start, end);
		this.color = color;
	}

	protected boolean intersects(Line otherLine) {
		return super.intersectsLine(otherLine);
	}

	protected boolean isVisible() {
		return color == null;
	}

	protected Color getColor() {
		return color;
	}

	protected Point getStartPoint() {
		return (Point) super.getP1();
	}

	protected Point getEndPoints() {
		return (Point) super.getP2();
	}

	protected double getLength() {
		double dx = super.getX1() - super.getX2();
		double dy = super.getY1() - super.getY2();
		return Math.sqrt(dx*dx + dy*dy);
	}

}
