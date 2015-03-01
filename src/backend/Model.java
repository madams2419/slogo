package backend;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import backend.command.Command;
import backend.command.CommandFactory;

public class Model {

	////////////////////////////////////////////////////////////////////
	//TODO define these fields with an XML config file or resource file
	////////////////////////////////////////////////////////////////////
	private static final int gridWidth = 1000;
	private static final int gridHeight = 1000;
	private static final Color gridColor = Color.WHITE;

	private static final String turtleImgPath = "turtle.jpg";
	private static final Color turtlePenColor = Color.BLACK;

	private static final String helpPgPath = "help.html";
	////////////////////////////////////////////////////////////////////

	private Grid grid;
	private Queue<Command> pendingCommands;
	private static Stack<Command> executedCommands;
	private HashMap<String, Double> userVariables;
	private HashMap<String, Command> userFunctions;
	private String helpPagePath;
	private CommandFactory comFactory;
	private SLogoParser parser;

	public Model() {
		Turtle turtle = new Turtle(turtleImgPath, new Point(0, 0), new Heading(90), turtlePenColor);
		grid = new Grid(new Dimension(gridWidth, gridHeight), gridColor, turtle);
		pendingCommands = new LinkedList<>();
		executedCommands = new Stack<>();
		userVariables = new HashMap<>();
		userFunctions = new HashMap<>();
		helpPagePath = helpPgPath;
		comFactory = new CommandFactory(grid, userVariables);
		parser = new SLogoParser(comFactory);
	}

	public void parseProgram(String prog) {
		pendingCommands = parser.parseProgram(prog);
		printCommandTree();
	}

	public Command executeNextCommand() {
		Command targetCommand = pendingCommands.poll();
		targetCommand.execute();
		executedCommands.push(targetCommand);
		return targetCommand;
	}
	
	public Stack<Command> executeAllCommands() {
		while(!pendingCommands.isEmpty()) {
			executeNextCommand();
			Turtle t = grid.getActiveTurtle();
			System.out.println("Turtle (x,y): " + t.getLocation().getX() + ", " + t.getLocation().getY());
		}
		
		return executedCommands;
	}

	public void printCommandTree() {
		Command root = pendingCommands.peek();

		System.out.println(root);

		printCommands(root.getParams());
	}

	public void printCommands(ArrayList<Command> params) {
		for(Command c : params) {
			System.out.println(c);

			ArrayList<Command> subParams = c.getParams();
			printCommands(subParams);
		}
	}

	public void setVariable(String name, Double val) {
		userVariables.put(name, val);
	}

	public void setLanguage(String language) {
		//TODO
	}

	public Grid getGrid() {
		return grid;
	}

	public Stack<Command> getExecutedCommands() {
		return executedCommands;
	}

	public HashMap<String, Double> getUserVariables() {
		return userVariables;
	}

	public HashMap<String, Command> getUserFunctions() {
		return userFunctions;
	}

	public String getHelpPagePath() {
		return helpPagePath;
	}

	public static void main (String[] args) {
		//String userInput = "fd 50\n" + "right 45\n" + "fd 100";

		//String userInput = "make :test fd 50\n" + "fd :test\n" + "fd :test\n";

		String userInput = "if difference 1 0 [ fd 50 ]";

		Model m = new Model();

		m.parseProgram(userInput);

		m.executeAllCommands();

		ArrayList<Line> lines = m.getGrid().getLines();

		for(Line l : lines) {
			System.out.println(l);
		}
	}

}
