package backend.command;

import backend.*;

public class DoTimes extends For {

	public DoTimes(StringPair stringPair, Model model, Command parent) {
		super(stringPair, parent, model);
	}
	
	@Override
	public int start() {
		return 1;
	}
	
	@Override
	public int end() {
		return forVarList().executeParam(1).intValue();
	}
	
	@Override
	public int increment() {
		return 1;
	}

}
