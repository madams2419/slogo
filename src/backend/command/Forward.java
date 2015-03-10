package backend.command;

import java.util.List;

import backend.*;

public class Forward extends TurtleCommand {

	private static final int NUM_PARAMS = 1;

	public Forward(StringPair stringPair, Command parent, Model model) {
		super(stringPair, NUM_PARAMS, parent, model);
	}

	//public Double execute() {
		//List<Turtle> activeTurtles = activeTurtles();
		//Double ret = 0.0;
		//for(Turtle turtle : activeTurtles) {
			//grid().setActiveTurtle(turtle);
			//ret = turtle.move(distance());
		//}
		//grid().setActiveTurtles(activeTurtles);
		//return ret;
	//}

	//public Double execute(Turtle target) {
		//return target.move(distance(target));
	//}

	//public Double execute() {
		//return doForAllActiveTurtles(turtle -> turtle.move(distance()));
	//}

	protected Double turtleOperation(Turtle turtle) {
		Double distance = distance();
		System.out.printf("Move forward %f pixels\n", distance);
		return turtle.move(distance);
	}

	private Double distance() {
		return params.get(0).execute();
	}

}


