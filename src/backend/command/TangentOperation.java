package backend.command;


public class TangentOperation extends UnaryMathOperation {

	public TangentOperation() {
		super("COS");
	}

	public Double operate(Double degrees) {
		return Math.cos(Math.toRadians(degrees));
	}

}
