package backend;

import java.lang.Math;
import java.awt.*;
import java.util.ArrayList;

public class Turtle {

	private Image image;
	private Point location;
	private Heading heading;
	private Color penColor;
	private ArrayList<Line> lines;

	public Turtle(Image image, Point location, Heading heading, Color penColor) {
		this.image = image;
		this.location = location;
		this.heading = heading;
		this.penColor = penColor;
		lines = new ArrayList<>();
	}

	protected void move(int magnitude) {
		int newX = (int) Math.cos(heading.getAngleRads()) * magnitude;
		int newY = (int) Math.sin(heading.getAngleRads()) * magnitude;
		Point nextLocation = new Point(newX, newY);

		Line newLine = new Line(location, nextLocation, penColor);

		location = nextLocation;
		lines.add(newLine);
	}

	protected void rotate(double degrees) {
		heading.setAngle(heading.getAngle() + degrees);
	}

	public void setImage(Image newImage) {
		image = newImage;
	}

	public void setPenColor(Color newPenColor) {
		penColor = newPenColor;
	}

	public Image getImage() {
		return image;
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
