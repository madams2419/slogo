package backend.command;

import java.util.ArrayList;
import backend.StringPair;


public abstract class Command implements Cloneable {

	private StringPair stringPair;
	protected int numParams;
	protected ArrayList<Command> params;
	protected Command parent;

	public Command(StringPair stringPair, int numParams, Command parent) {
		this.stringPair = stringPair;
		this.numParams = numParams;
		this.parent = parent;
		params = new ArrayList<>();
	}

	public abstract Double execute();

	public String toString() {
		return stringPair.getProperty();
	}

	public String getTypedString() {
		return stringPair.getValue();
	}

	public boolean needsParams() {
		return params.size() < numParams;
	}

	public void setParam(Command newParam) {
		params.add(newParam);
	}

	public boolean hasParent() {
		return parent != null;
	}

	public Double getParamValue(int paramIndex) {
		return params.get(0).execute();
	}

	public ArrayList<Command> getParams() {
		return params;
	}

	public Command getParent() {
		return parent;
	}


}
