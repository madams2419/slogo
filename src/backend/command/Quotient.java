package backend.command;


public class Quotient extends BinaryMathOperation {

	public Quotient() {
		super("QUOTIENT");
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 / expr2;
	}

}





