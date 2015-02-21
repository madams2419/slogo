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
	private ArrayList<Line> lines;

	public Turtle(String imagePath, Point location, Heading heading, Color penColor) {
		this.imagePath = imagePath;
		this.location = location;
		this.heading = heading;
		this.penColor = penColor;
		penDown = false;
		lines = new ArrayList<>();
	}

	protected void move(int magnitude) {
		int newX = (int) Math.cos(heading.getAngleRads()) * magnitude;
		int newY = (int) Math.sin(heading.getAngleRads()) * magnitude;
		Point nextLocation = new Point(newX, newY);

		Line newLine = new Line(location, nextLocation, (penDown) ? penColor : null);

		location = nextLocation;
		lines.add(newLine);
	}

	protected void rotate(double degrees) {
		heading.setAngle(heading.getAngle() + degrees);
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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

}
