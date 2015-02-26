package backend.command;


public class RandomOperation extends UnaryMathOperation {

	public RandomOperation() {
		super("RANDOM");
	}

	public Double operate(Double expr) {
		return Math.random() * expr;
	}

}
