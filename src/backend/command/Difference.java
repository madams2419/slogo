package backend.command;

public class Difference extends BinaryMathOperation {

	public Difference() {
		super("DIFFERENCE");
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 - expr2;
	}

}





