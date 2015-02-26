package backend;

import java.util.function.BiFunction;


public abstract class Command {

	private String name;
	protected int numParams, curNumParams;
	protected Command[] params;
	protected Command parent;
	protected Double returnVal;

	public Command(String name, int numParams) {
		this.name = name;
		this.numParams = numParams;
		curNumParams = 0;
		params = new Command[numParams];
		returnVal = null;
	}

	public abstract Double execute();

	public String toString() {
		return name;
	}

	public boolean needsParams() {
		return curNumParams < numParams;
	}

	public void setParam(Command newParam) {
		params[curNumParams] = newParam;
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

	public Double getReturnVal() {
		return (returnVal != null) ? returnVal : execute();
	}

	public Command getParent() {
		return parent;
	}


}
