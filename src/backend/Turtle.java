package backend

import java.util.Math;

public Class Turtle {

  private Image image;
  private Point location;
  private Heading heading;
  private Color penColor;

  public Turle(Image image, Point location, Heading heading, Color penColor) {
    this.image = image;
    this.location = location;
    this.heading = heading;
    this.penColor = penColor;
  }

  protected void move(int magnitude) {
    int newX = Math.cos(heading.getAngleRads()) * magnitude;
    int newY = Math.sin(heading.getAngleRads()) * magnitude;
    location = new Point(newX, newY);
  }

  protected void rotate(double degrees) {
    heading.setAngleDeg(heading.getAngleDeg() + degrees);
  }

  public void setImage(Image newImage) {
    image = newImage;
  }

  public void setPenColor(Color newPenColor) {
    penColor = newPenColor;
  }

  public Point getLocation() {
    return location;
  }

  public Heading getHeading() {
    return heading;
  }
}
