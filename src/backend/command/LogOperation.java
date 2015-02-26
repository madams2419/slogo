package backend.command;


public class LogOperation extends UnaryMathOperation {

	public LogOperation() {
		super("LOG");
	}

	public Double operate(Double expr) {
		return Math.log(expr);
	}

}
