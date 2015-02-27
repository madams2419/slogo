package backend.command;


public class ArcTangent extends UnaryMathOperation {

	public ArcTangent() {
		super("ATAN");
	}

	public Double operate(Double degrees) {
		return Math.atan(Math.toRadians(degrees));
	}

}
