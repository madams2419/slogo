package backend.command;


public class ArctangentOperation extends UnaryMathOperation {

	public ArctangentOperation() {
		super("ATAN");
	}

	public Double operate(Double degrees) {
		return Math.atan(Math.toRadians(degrees));
	}

}
