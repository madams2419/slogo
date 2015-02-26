package backend;

public class QuotientOperation extends BinaryMathOperation {

	public QuotientOperation() {
		super("QUOTIENT");
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 / expr2;
	}

}





