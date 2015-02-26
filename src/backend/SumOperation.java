package backend;

public class SumOperation extends BinaryMathOperation {

	public SumOperation() {
		super("SUM");
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 + expr2;
	}

}





