package backend;

public class WindowBoundaryBehavior extends BoundaryBehavior {

  public WindowBoundaryBehavior(int height, int width) {
    super(height, width);

  }

  @Override
  public Path attemptPath(Path p, Turtle turtle) {
    if (isInBounds(p.myEnd)) {
      if (!isInBounds(p.myStart)) {
        turtle.show();
      }
    } else {
      turtle.hide();
    }
    return p;
  }

}
