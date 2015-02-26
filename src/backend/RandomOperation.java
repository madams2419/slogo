package backend;

public class MinusOperation extends UnaryMathOperation {

	public MinusOperation() {
		super("MINUS");
	}

	public Double operate(Double expr) {
		return -expr;
	}

}
