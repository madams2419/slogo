package backend.command;


public class SineOperation extends UnaryMathOperation {

	public SineOperation() {
		super("SIN");
	}

	public Double operate(Double degrees) {
		return Math.sin(Math.toRadians(degrees));
	}

}
