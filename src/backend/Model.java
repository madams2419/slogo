package backend;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
	private Stack<Command> executedCommands;
	private HashMap<String, Double> userVariables;
	private HashMap<String, Command> userFunctions;
	private String helpPagePath;

	public Model() {
		Turtle turtle = new Turtle(turtleImgPath, new Point(0, 0), new Heading(90), turtlePenColor);
		grid = new Grid(new Dimension(gridWidth, gridHeight), gridColor, turtle);
		pendingCommands = new LinkedList<>();
		executedCommands = new Stack<>();
		userVariables = new HashMap<>();
		userFunctions = new HashMap<>();
		helpPagePath = helpPgPath;
	}

	public void parseProgram(String prog) {
		//TODO
	}

	public Command executeNextCommand() {
		Command targetCommand = pendingCommands.poll();
		targetCommand.execute();
		executedCommands.push(targetCommand);
		return targetCommand;
	}

	public void setVariable(String name, double value) {
		userVariables.put(name, value);
	}

	public static void setLanguage(String language) {
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

}
