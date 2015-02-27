package backend.command;


public class Minus extends UnaryMathOperation {

	public Minus() {
		super("MINUS");
	}

	public Double operate(Double expr) {
		return -expr;
	}

}
