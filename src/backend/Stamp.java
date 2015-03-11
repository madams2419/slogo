package backend;

import java.awt.Point;

public class Stamp implements DrawableImage {
	
	private String imagePath;
	private Point location;
	
	public Stamp(String imagePath, Point location) {
		this.imagePath = imagePath;
		this.location = location;
	}
	
	public Stamp(DrawableImage dImage) {
		this(dImage.getImagePath(), dImage.getLocation());
	}
	
	public String getImagePath() {
		return imagePath;
	}
	
	public Point getLocation() {
		return location;
	}

}
