package backend;

import java.lang.Math;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Turtle implements DrawableImage {

	private int id;
	private String imagePath;
	private Point location;
	private Heading heading;
	private Pen pen;
	ArrayList<Stamp> stamps;
	private boolean isVisible;

	public Turtle(int id, String imageName, Point location, Heading heading, Color penColor, int penWidth) {
		this.id = id;
		setImageByName(imageName);
		this.location = location;
		this.heading = heading;
		this.pen = new Pen(penColor, penWidth, true);
		stamps = new ArrayList<>();
		isVisible = true;
	}

	public Turtle(int id, BiIndex<Color> colorMap, BiIndex<String> imageMap) {
		this(id, imageMap.getValue(Defaults.TURTLE_IMG_INDEX), Defaults.TURTLE_START_POINT, Defaults.TURTLE_START_HEADING, colorMap.getValue(Defaults.PEN_COLOR_INDEX), Defaults.PEN_WIDTH);
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

	public void setImageByFullPath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setImageByName(String imageName) {
		setImageByFullPath(Defaults.IMAGE_DIRECTORY + imageName);
	}

	public void stamp() {
		Stamp newStamp = new Stamp(this);
		stamps.add(newStamp);
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

	public String getImageName() {
		return imagePath.replace(Defaults.IMAGE_DIRECTORY, "");
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

	public boolean clearLines() {
		return pen.clearLines();
	}

	public boolean clearStamps() {
		boolean stampsCleared = false;
		if(stamps.size() > 0) {
			stampsCleared = true;
			stamps.clear();
		}
		return stampsCleared;
	}

	public int getID() {
		return id;
	}

	public Pen getPen() {
		return pen;
	}

}
