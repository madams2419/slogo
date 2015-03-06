package backend.command;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

import backend.*;

public class CommandFactory {

	Grid grid;
	HashMap<String, UserInstructionContainer> userInstructions;
	HashMap<String, Variable> userVariables;

	public CommandFactory(Grid grid, HashMap<String, UserInstructionContainer> userInstructions, HashMap<String, Variable> userVariables) {
		this.grid = grid;
		this.userInstructions = userInstructions;
		this.userVariables = userVariables;
	}

	public Command getCommand(StringPair stringPair, Command parent)  {
		Command newCommand;
		String comClassName = "backend.command." + stringPair.getProperty();
		
		System.out.println("Command created: " + stringPair.getProperty());

		try {
			Class<?> comClass = Class.forName(comClassName);
			String comSuperName = comClass.getSuperclass().getName();
			Constructor<?>[] comConstructors = comClass.getDeclaredConstructors();

			if(comSuperName.contains("TurtleCommand")) {
				newCommand = (Command) comConstructors[0].newInstance(stringPair, parent, grid.getActiveTurtle());
			} else {
				if(comClass.getName().contains("Constant"))
					newCommand = (Command) comConstructors[0].newInstance(stringPair, parent);
				else if(comClass.getName().contains("Variable") || comClass.getName().contains("Repeat") || comClass.getName().contains("For")|| comClass.getName().contains("DoTimes"))
					newCommand = (Command) comConstructors[0].newInstance(stringPair, userVariables, parent);
				else if(comClass.getName().contains("Repeat") || comClass.getName().contains("DoTimes"))
					newCommand = (Command) comConstructors[0].newInstance(stringPair, userVariables, parent);
				else if(comClass.getName().contains("UserInstruction"))
					newCommand = (Command) comConstructors[0].newInstance(stringPair, userInstructions, userVariables, parent);
				else
					newCommand = (Command) comConstructors[0].newInstance(stringPair, parent);
			}

		} catch (Exception e) {
		  throw new NullPointerException("Command Not Found");
		}

		return newCommand;
	}

}
