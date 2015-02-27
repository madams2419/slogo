package backend.command;


public class Power extends BinaryMathOperation {

	public Power() {
		super("POW");
	}

	public Double operate(Double base, Double exponent) {
		return Math.pow(base, exponent);
	}

}
