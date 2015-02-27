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
		comFactory = new CommandFactory(grid);
		parser = new SLogoParser(comFactory);
	}

	public void parseProgram(String prog) {
		pendingCommands = parser.parseProgram(prog);
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

	public static Stack<Command> getExecutedCommands() {
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
		String[] examples = {
				"# foo",
				"foo #",
				"#",
				"",
				"fd",
				"FD",
				"forwardd",
				"allOrNothing",
				"all_or_nothing",
				"allOr_nothing?",
				"allOr?nothing_",
				":allornothing",
				"90",
				"9.09",
				"9.0.0",
				"[",
				"]",
				"(",
				")"
		};
		String userInput = "# fd 50 rt 90 BACK :distance Left :angle";
	}

}
