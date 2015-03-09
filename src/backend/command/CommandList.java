package backend.command;

import backend.StringPair;
import java.util.*;

public class CommandList extends Command {

	private boolean listComplete;

	public CommandList(StringPair stringPair, Command parent) {
		super(stringPair, 0, parent);
		listComplete = false;
	}

	@Override
	public boolean needsParams() {
		return !listComplete;
	}

	public void setComplete() {
		listComplete = true;
	}

	public Double execute() {
		List<Double> listVals = executeList();
		return listVals.get(listVals.size() - 1);
	}

	public List<Double> executeList() {
		List<Double> listVals = new ArrayList<>();
		for(Command param : params) {
			listVals.add(param.execute());
		}
		return listVals;
	}

	public int size() {
		return params.size();
	}

}
