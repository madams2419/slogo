package backend;

import java.lang.Math;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static backend.Constants.*;

public class Turtle implements DrawableImage {

	private int id;
	private String imagePath;
	private Point location;
	private Heading heading;
	private Pen pen;
	ArrayList<Stamp> stamps;
	private boolean isVisible;

	public Turtle(int id, String imagePath, Point location, Heading heading, Color penColor, int penWidth) {
		this.id = id;
		this.imagePath = imagePath;
		this.location = location;
		this.heading = heading;
		this.pen = new Pen(penColor, penWidth, true);
		stamps = new ArrayList<>();
		isVisible = true;
	}

	public Turtle(int id) {
		this(id, TURTLE_IMG_PATH, TURTLE_START_POINT, TURTLE_START_HEADING, TURTLE_PEN_COLOR, TURTLE_PEN_WIDTH);
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
		pen.drawLine(location, target);
		return jumpToPoint(target);
	}
	
	public double jumpToPoint(Point target) {
		double distanceMoved = location.distance(target);
		location = target;
		return distanceMoved;		
	}

	public double setHeading(double newAngle) {
		double angleChange = newAngle - heading.getAngle();
		double newAngleMod = newAngle % 360;
		heading = new Heading(newAngleMod);
		return angleChange;
	}

	public double faceTowards(Point target) {
		double deltaX = target.getX() - location.getX();
		double deltaY = target.getY() - location.getY();
		double newHeading = Math.toDegrees(Math.atan2(deltaX, deltaY));

		return setHeading(newHeading);
	}

	public double rotateRight(double degrees) {
		double newHeading = heading.getAngle() - degrees;
		setHeading(newHeading);
		return degrees;
	}

	public double rotateLeft(double degrees) {
		double newHeading = heading.getAngle() + degrees;
		setHeading(newHeading);
		return degrees;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public double stamp() {
		Stamp newStamp = new Stamp(this);
		stamps.add(newStamp);
		//TODO image index lookup
		return 1.0;
	}
	
	public List<Stamp> getStamps() {
		return stamps;
	}

	public double setPenDown() {
		pen.setDown(true);
		return 1.0;
	}

	public double setPenUp() {
		pen.setDown(false);
		return 0.0;
	}

	public double isPenDown() {
		return (pen.isDown()) ? 1.0 : 0.0;
	}

	public double isShowing() {
		return (isVisible) ? 1.0 : 0.0;
	}

	public double show() {
		isVisible = true;
		return 1.0;
	}

	public double hide() {
		isVisible = false;
		return 0.0;
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

	public List<Line> getLines() {
		return pen.getLines();
	}

	public void clearLines() {
		pen.clearLines();
	}

	public int getID() {
		return id;
	}

}
