package backend;

public abstract class BinaryMathOperation extends Command {

	public BinaryMathOperation(String name) {
		super(name, 2);
	}

	public Double execute() {
		return operate(params[0].execute(), params[1].execute());
	}

	public abstract Double operate(Double expr1, Double expr2);

}


