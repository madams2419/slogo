package backend.command;

import backend.StringPair;


public class Product extends BinaryMathOperation {
	
	public Product(StringPair stringPair, Command parent) {
		super(stringPair, parent);
	}

	public Double operate(Double expr1, Double expr2) {
		return expr1 * expr2;
	}

}





