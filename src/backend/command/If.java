package backend.command;

import backend.StringPair;

public class If extends Command{

	public If(StringPair stringPair, Command parent) {
		super(stringPair, 2, parent);
	}

	public Double execute(){
		System.out.println("If value:"+ getParam(0).execute().intValue());
		if(getParam(0).execute().intValue()!=0){
			return getParam(1).execute();
		}
		Double returnVal = 0.0;
		return returnVal;
	}
	
}
