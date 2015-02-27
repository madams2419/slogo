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
	
	public Command getCommand(StringPair csp) {
		Command newCommand;
		String comClassName = "backend.command." + csp.getProperty();
		
		try {
			Class<?> comClass = Class.forName(comClassName);
			String comSuperName = comClass.getSuperclass().getName();
			Constructor<?>[] comConstructors = comClass.getDeclaredConstructors();
			
			if(comSuperName.contains("TurtleCommand")) {
				newCommand = (Command) comConstructors[0].newInstance(grid.getActiveTurtle());
			} else {
				newCommand = (Command) comConstructors[0].newInstance();
			}
			
		} catch (Exception e) {
			// TODO add some actual error handling
			e.printStackTrace();
			newCommand = null;
		}
		
		return newCommand;
		
	}
	
	public static void main(String[] args) {
		Grid g = new Grid(new Dimension(100,100), Color.RED);
		
		Turtle t = new Turtle("testPath", new Point(0,0), new Heading(90),Color.BLACK);
		
		g.addTurtle(t);
		
		CommandFactory cf = new CommandFactory(g);
		
		StringPair testSp = new StringPair("Forward", "FWD");
		
		Command c = cf.getCommand(testSp);
		
		System.out.println(c.needsParams());
		
		
	}
}
