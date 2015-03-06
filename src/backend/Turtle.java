package backend;

import java.lang.Math;
import java.awt.*;
import java.util.ArrayList;

public class Turtle {

	private String imagePath;
	private Point location;
	private Heading heading;
	private Color penColor;
	private boolean penDown;
	private boolean visible;
	private ArrayList<Line> lines;

	public Turtle(String imagePath, Point location, Heading heading, Color penColor) {
		this.imagePath = imagePath;
		this.location = location;
		this.heading = heading;
		this.penColor = penColor;
		penDown = true;
		visible = true;
		lines = new ArrayList<>();
	}

	public double move(Double magnitude) {
		double deltaX = Math.cos(heading.getAngleRads()) * magnitude;
		double deltaY = Math.sin(heading.getAngleRads()) * magnitude;
		int newX = location.x + (int) Math.round(deltaX);
		int newY = location.y + (int) Math.round(deltaY);
		Point nextLocation = new Point(newX, newY);
		return moveToPoint(nextLocation);
	}

	public double moveToPoint(Point target) {
		System.out.println("Next loc: " + target);
		Line newLine = new Line(location, target, (penDown) ? penColor : null);
		double distanceMoved = location.distance(target);
		location = target;
		lines.add(newLine);
		return distanceMoved;
	}

	public double setHeading(double newAngle) {
		double angleChange = newAngle - heading.getAngle();
		heading.setAngle(newAngle);
		System.out.println("New heading: " + newAngle);
		return angleChange;
	}

	public double faceTowards(Point target) {
		double deltaX = target.getX() - location.getX();
		double deltaY = target.getY() - location.getY();
		double newHeading = Math.toDegrees(Math.atan2(deltaX, deltaY));

		return setHeading(newHeading);
	}

	public void rotateRight(double degrees) {
		double newHeading = heading.getAngle() - degrees;
		setHeading(newHeading);
	}

	public void rotateLeft(double degrees) {
		double newHeading = heading.getAngle() + degrees;
		setHeading(newHeading);
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public double setPenDown() {
		penDown = true;
		return 1.0;
	}

	public double setPenUp() {
		penDown = false;
		return 0.0;
	}

	public double isPenDown() {
		return (penDown) ? 1.0 : 0.0;
	}

	public double isShowing() {
		return (visible) ? 1.0 : 0.0;
	}

	public double show() {
		visible = true;
		return 1.0;
	}

	public double hide() {
		visible = false;
		return 0.0;
	}

	public void setPenColor(Color newPenColor) {
		penColor = newPenColor;
	}

	public String getImagePath() {
		return imagePath;
	}

	public Point getLocation() {
		return location;
	}

	public Heading getHeading() {
		return heading;
	}

	public ArrayList<Line> getLines() {
		return lines;
	}

	public void clearLines() {
		lines.clear();
	}

}
