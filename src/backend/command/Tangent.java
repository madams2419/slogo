package backend.command;


public class Tangent extends UnaryMathOperation {

	public Tangent() {
		super("COS");
	}

	public Double operate(Double degrees) {
		return Math.cos(Math.toRadians(degrees));
	}

}
