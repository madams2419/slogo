package backend.command;

import java.util.ArrayList;

import backend.StringPair;


public abstract class Command {

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

	public String getProperty() {
		return stringPair.getProperty();
	}

	public boolean needsParams() {
		return params.size() < numParams;
	}

	public void setParam(Command newParam) {
		params.add(newParam);
	}

	public <T extends Command> T getParam(int index, Class<T> type) {
		return type.cast(params.get(index));
	}
	
	public Command getParam(int index) {
		return getParam(index, Command.class);
	}

	public boolean hasParent() {
		return parent != null;
	}

	public Double executeParam(int paramIndex) {
		return params.get(paramIndex).execute();
	}

	public ArrayList<Command> getParams() {
		return params;
	}

	public Command getParent() {
		return parent;
	}


}
