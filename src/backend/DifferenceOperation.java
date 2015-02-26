package backend;

public class DifferenceOperation extends BinaryMathOperation {

	public DifferenceOperation() {
		super("DIFFERENCE");
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 - expr2;
	}

}





