package backend.command;


public class ProductOperation extends BinaryMathOperation {

	public ProductOperation() {
		super("PRODUCT");
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 * expr2;
	}

}





