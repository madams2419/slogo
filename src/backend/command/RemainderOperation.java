package backend.command;


public class RemainderOperation extends BinaryMathOperation {

	public RemainderOperation() {
		super("REMAINDER");
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 % expr2;
	}

}





