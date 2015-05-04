package backend.command;

import backend.FenceBoundaryBehavior;
import backend.Model;
import backend.StringPair;

public class Fence extends ModelCommand {

  public Fence(StringPair stringPair, Command parent, Model model) {
    super(stringPair, 0, parent, model);
  }

  public Double execute() {
    grid().setBoundaryBehavior(
        new FenceBoundaryBehavior(grid().getDimension().width, grid().getDimension().height));
    return 3.0;
  }

}