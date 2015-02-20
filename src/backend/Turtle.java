package backend;

import java.lang.Math;
import java.awt.*;

public class Turtle {

  private Image image;
  private Point location;
  private Heading heading;
  private Color penColor;

  public Turtle(Image image, Point location, Heading heading, Color penColor) {
    this.image = image;
    this.location = location;
    this.heading = heading;
    this.penColor = penColor;
  }

  protected void move(int magnitude) {
    int newX = (int) Math.cos(heading.getAngleRads()) * magnitude;
    int newY = (int) Math.sin(heading.getAngleRads()) * magnitude;
    location = new Point(newX, newY);
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
}
