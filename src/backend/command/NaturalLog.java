package backend.command;


public class NaturalLog extends UnaryMathOperation {

	public NaturalLog() {
		super("LOG");
	}

	public Double operate(Double expr) {
		return Math.log(expr);
	}

}
