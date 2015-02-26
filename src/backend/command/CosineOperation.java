package backend.command;


public class CosineOperation extends UnaryMathOperation {

	public CosineOperation() {
		super("COS");
	}

	public Double operate(Double degrees) {
		return Math.cos(Math.toRadians(degrees));
	}

}
