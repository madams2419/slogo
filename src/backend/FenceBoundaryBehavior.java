package backend;

import java.awt.Point;

public class FenceBoundaryBehavior extends BoundaryBehavior {

  public FenceBoundaryBehavior(int height, int width) {
    super(height, width);
  }

  @Override
  public Path attemptPath(Path p, Turtle t) {
    if (isInBounds(p.myEnd)) {
      return p;
    }
    return new Path(p.myStart, calculateBoundaryIntersection(p));
  }

  private Point calculateBoundaryIntersection(Path path) {
    double distanceToXBoundary = (getWidth() / 2) - Math.abs(path.myStart.x);
    double distanceToYBoundary = (getHeight() / 2) - Math.abs(path.myStart.y);

    double scaledX = distanceToYBoundary * (1 / path.getSlope());
    double scaledY = distanceToXBoundary * path.getSlope();
    int correctedX; int correctedY;
    
    if (Math.abs(scaledY) <= (getHeight() / 2) && Math.abs(path.myEnd.y) > (getHeight() / 2)) {
      
      if (path.dX() < 0) {
        correctedX = -(getWidth() / 2);
      } else {
        correctedX = (getWidth() / 2);
      }
      if (path.dY() < 0) {
        correctedY = path.myStart.y - (int) scaledY;
      } else {
        correctedY = path.myStart.y + (int) scaledY;
      }
      return new Point(correctedX, correctedY);
      
    } else if (Math.abs(scaledX) <= (getWidth() / 2) && Math.abs(path.myEnd.x) > (getWidth() / 2)) {
      if (path.dX() < 0) {
        correctedX = -path.myStart.x - (int) scaledX;
      } else {
        correctedX = path.myStart.y + (int) scaledX;
      }
      if (path.dY() < 0) {
        correctedY = -(getHeight() / 2);
      } else {
        correctedY = (getHeight() / 2);
      }

      return new Point(correctedX, correctedY);
    } else {
      return path.myEnd;
    }

  }

}
