package backend;

public abstract class UnaryMathOperation extends Command {

	public UnaryMathOperation(String name) {
		super(name, 1);
	}

	public Double execute() {
		return operate(params[0].execute());
	}

	public abstract Double operate(Double expr);

}


