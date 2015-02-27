package backend.command;


public class Cosine extends UnaryMathOperation {

	public Cosine() {
		super("COS");
	}

	public Double operate(Double degrees) {
		return Math.cos(Math.toRadians(degrees));
	}

}
