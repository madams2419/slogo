package backend.command;


public class Product extends BinaryMathOperation {

	public Product() {
		super("PRODUCT");
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 * expr2;
	}

}





