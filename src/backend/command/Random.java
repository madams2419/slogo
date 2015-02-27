package backend.command;


public class Random extends UnaryMathOperation {

	public Random() {
		super("RANDOM");
	}

	public Double operate(Double expr) {
		return Math.random() * expr;
	}

}
