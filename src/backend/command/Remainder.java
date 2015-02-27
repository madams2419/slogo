package backend.command;


public class Remainder extends BinaryMathOperation {

	public Remainder() {
		super("REMAINDER");
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 % expr2;
	}

}





