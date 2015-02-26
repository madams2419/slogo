package backend.command;


public class PowerOperation extends BinaryMathOperation {

	public PowerOperation() {
		super("POW");
	}

	public Double operate(Double base, Double exponent) {
		return Math.pow(base, exponent);
	}

}
