package backend.command;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import backend.*;

public class CommandFactory {
	
	Grid grid;
	
	public CommandFactory(Grid grid) {
		this.grid = grid;
	}
	
	public Command getCommand(StringPair csp, Command parent) {
		Command newCommand;
		String comClassName = "backend.command." + csp.getProperty();
		
		System.out.println(comClassName);
		
		try {
			Class<?> comClass = Class.forName(comClassName);
			String comSuperName = comClass.getSuperclass().getName();
			Constructor<?>[] comConstructors = comClass.getDeclaredConstructors();
			
			if(comSuperName.contains("TurtleCommand")) {
				newCommand = (Command) comConstructors[0].newInstance(parent, grid.getActiveTurtle());
			} else {
				if(comClass.getName().contains("Constant")) 
					newCommand = (Command) comConstructors[0].newInstance(parent, Double.parseDouble(csp.getValue()));
				else
					newCommand = (Command) comConstructors[0].newInstance(parent);
			}
			
		} catch (Exception e) {
			// TODO add some actual error handling
			e.printStackTrace();
			newCommand = null;
		}
		
		return newCommand;
		
	}
	
}
