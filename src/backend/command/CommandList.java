package backend.command;

import backend.StringPair;

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
		Double returnVal = 0.0;
		for(Command param : params) {
			returnVal = param.execute();
		}
		return returnVal;
	}

}
