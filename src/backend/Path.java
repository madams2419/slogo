package backend;

import java.awt.Point;

public class Path {

  public Point myStart;
  public Point myEnd;
  
  public Path(Point start, Point end){
    myStart = start;
    myEnd = end;
  }
  
  public double getSlope(){
    return dY()/dX();
  }

  protected int dX() {
    return myEnd.x - myStart.x;
  }
  protected int dY() {
    return myEnd.y - myStart.y;
  }
}
