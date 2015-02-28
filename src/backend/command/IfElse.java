package backend.command;

import backend.StringPair;

public class IfElse extends Command{

	public IfElse(StringPair stringPair, Command parent) {
		super(stringPair, 3, parent);
	}

	public Double execute(){
		if(getParam(0).execute().intValue()!=0){
			return getParam(1).execute();
		}
		else{
			return getParam(2).execute();
		}
		
	}
	
}
