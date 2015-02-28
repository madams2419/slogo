package backend.command;

import java.util.function.BiFunction;

import backend.StringPair;


public abstract class Command {

	private StringPair stringPair;
	protected int numParams, curNumParams;
	protected Command[] params;
	protected Command parent;

	public Command(StringPair stringPair, int numParams, Command parent) {
		this.stringPair = stringPair;
		this.numParams = numParams;
		this.parent = parent;
		curNumParams = 0;
		params = new Command[numParams];
	}

	public abstract Double execute();

	public String toString() {
		return stringPair.getProperty();
	}

	public String getTypedString() {
		return stringPair.getValue();
	}

	public boolean needsParams() {
		return curNumParams < numParams;
	}

	public void setParam(Command newParam) {
		params[curNumParams] = newParam;
		curNumParams++;
	}

	public Double[] evaluateParams() {
		Double[] paramVals = new Double[numParams];
		for(int i = 0; i < params.length; i++) {
			paramVals[i] = params[i].execute();
		}
		return paramVals;
	}

	public Double operateOnParams(BiFunction<Command, Double, Double> func) {
		Double result = new Double(0);
		for(Command param : params) {
			result = func.apply(param, result);
		}
		return result;
	}

	public boolean hasParent() {
		return parent != null;
	}

	public Double getParamValue(int paramIndex) {
		return params[paramIndex].execute();
	}

	public Command[] getParams() {
		return params;
	}

	public Command getParent() {
		return parent;
	}


}
