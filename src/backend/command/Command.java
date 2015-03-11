package backend.command;

import java.util.ArrayList;

import backend.StringPair;


public abstract class Command {

	private StringPair stringPair;
	protected int numParams;
	protected ArrayList<Command> params;
	protected Command parent;
	int indentLevel;
	Double returnVal;

	public Command(StringPair stringPair, int numParams, Command parent) {
		this.stringPair = stringPair;
		this.numParams = numParams;
		this.parent = parent;
		params = new ArrayList<>();
		indentLevel = (hasParent()) ? parent.getIndentLevel() : 0;
		if(parentIsList()) {
			indentLevel++;
		}
		returnVal = null;
	}

	public abstract Double execute();

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(preParamsFormatString());
		for(Command param : params) {
			sb.append(param.toString());
			if(!param.equals(params.get(params.size() - 1))) {
				sb.append(interParamFormatString());
			}
		}
		sb.append(postParamsFormatString());
		return sb.toString();
	}

	protected String preParamsFormatString() {
		return indentString() + getTypedString() + " ";
	}

	protected String indentString() {
		if(parentIsList()) {
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < indentLevel; i++) {
				sb.append("  ");
			}
			return sb.toString();
		} else {
			return "";
		}
	}

	protected String postParamsFormatString() {
		return "";
	}

	protected String interParamFormatString() {
		return "";
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
		returnVal = params.get(paramIndex).execute();
		return returnVal;
	}

	public Double getReturnVal() {
		return returnVal;
	}

	public Double getParamReturnVal(int paramIndex) {
		return getParam(paramIndex).getReturnVal();
	}

	public ArrayList<Command> getParams() {
		return params;
	}

	public Command getParent() {
		return parent;
	}

	public int getIndentLevel() {
		return indentLevel;
	}

	protected boolean parentIsList() {
		if(hasParent()) {
			return parent.getClass().equals(CommandList.class);
		} else {
			return false;
		}
	}

}
