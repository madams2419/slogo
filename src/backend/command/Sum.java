package backend.command;


public class Sum extends BinaryMathOperation {

	public Sum() {
		super("SUM");
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 + expr2;
	}

}





