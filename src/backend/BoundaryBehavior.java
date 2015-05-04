package backend;

import java.awt.Point;

public abstract class BoundaryBehavior {

  private int myHeight;
  private int myWidth;

  public BoundaryBehavior(int height, int width) {
    myHeight = height;
    myWidth = width;
  }

  public boolean isInBounds(Point target) {
    return (Math.abs(target.x) <= myHeight / 2 && Math.abs(target.y) <= myWidth / 2);
  }

  public abstract Path attemptPath(Path p, Turtle t);
  
  public int getHeight() {
    return myHeight;
  }

  public int getWidth() {
    return myWidth;
  }

  public void setWidth(int width) {
    myWidth = width;

  }

  public void setHeight(int height) {
    myHeight = height;
  }

}
