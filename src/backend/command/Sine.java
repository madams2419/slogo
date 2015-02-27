package backend.command;


public class Sine extends UnaryMathOperation {

	public Sine() {
		super("SIN");
	}

	public Double operate(Double degrees) {
		return Math.sin(Math.toRadians(degrees));
	}

}
