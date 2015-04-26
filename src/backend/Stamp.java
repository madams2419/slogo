package backend;

import java.awt.Point;

public class Stamp implements DrawableImage {
	
	private String imagePath;
	private Point location;
	private double orientation;
	
	public Stamp(String imagePath, Point location, double orientation) {
		this.imagePath = imagePath;
		this.location = location;
		this.orientation = orientation;
	}
	
	public Stamp(DrawableImage dImage) {
		this(dImage.getImagePath(), dImage.getLocation(), dImage.getOrientation());
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public Point getLocation() {
		return location;
	}
	
	public double getOrientation() {
		return orientation;
	}

}
