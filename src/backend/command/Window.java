package backend.command;

import backend.Model;
import backend.StringPair;
import backend.WindowBoundaryBehavior;

public class Window extends ModelCommand {

  public Window(StringPair stringPair, Command parent, Model model) {
    super(stringPair, 0, parent, model);
  }

  public Double execute() {
    grid().setBoundaryBehavior(
        new WindowBoundaryBehavior(grid().getDimension().width, grid().getDimension().height));
    return 2.0;
  }
}
