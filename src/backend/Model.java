package backend;

import java.awt.Dimension;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

import backend.command.*;
import static backend.Constants.*;

public class Model {

	private Grid grid;
	private Queue<Command> pendingCommands;
	private static Stack<Command> executedCommands;
	private HashMap<String, Variable> userVariables;
	private HashMap<String, UserInstructionContainer> userInstructions;
	private String helpPagePath;
	private CommandFactory comFactory;
	private SLogoParser parser;

	public Model() {
		Turtle turtle = new Turtle(1);
		grid = new Grid(new Dimension(GRID_WIDTH, GRID_HEIGHT), GRID_COLOR, turtle);
		pendingCommands = new LinkedList<>();
		executedCommands = new Stack<>();
		userVariables = new HashMap<>();
		userInstructions = new HashMap<>();
		helpPagePath = HELP_PAGE_PATH;
		comFactory = new CommandFactory(this);
		parser = new SLogoParser(comFactory);
	}

	public void parseProgram(String prog) {
		pendingCommands = parser.parseProgram(prog);
		printCommandTree();
	}
	
	public Command executeCommand(Command command) {
		command.execute();
		executedCommands.push(command);
		return command;
	}

	public Command executeNextCommand() {
		Command targetCommand = pendingCommands.poll();
		targetCommand.execute();
		executedCommands.push(targetCommand);
		return targetCommand;
	}
	
	public List<Command> executeAllCommands() {
		while(!pendingCommands.isEmpty()) {
			executeNextCommand();
			//printTurtleLocations();
		}
		
		return executedCommands;
	}
	
	private void printTurtleLocations() {
		List<Turtle> turtles = grid.getAllTurtles();
		for(Turtle t : turtles) {
			System.out.printf("Turtle #%d at (%f, %f)\n", t.getID(), t.getLocation().getX(), t.getLocation().getY());
		}
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

	public void setUserVariable(String name, Variable newVar) {
		userVariables.put(name, newVar);
	}
	
	public void setUserVariable(String name, double val) {
		Variable newVar = new Variable(name, val);
		setUserVariable(name, newVar);
	}
	
	public void setUserVariable(Variable var, double val) {
		String name = var.getName();
		Variable newVar = new Variable(name, val);
		setUserVariable(name, newVar);
	}

	public void setLanguage(String language) {
		//TODO
	}

	public Grid getGrid() {
		return grid;
	}

	public List<Command> getExecutedCommands() {
		return executedCommands;
	}
	
	public List<Command> getPendingCommands() {
		return (List<Command>) pendingCommands;
	}

	public Map<String, Variable> getUserVariables() {
		return userVariables;
	}

	public Map<String, UserInstructionContainer> getUserFunctions() {
		return userInstructions;
	}

	public String getHelpPagePath() {
		return helpPagePath;
	}

	public static void main (String[] args) throws FileNotFoundException {
		//String userInput = "fd 50\n" + "right 45\n" + "fd 100";

		//String userInput = "make :test fd 50\n" + "fd :test\n" + "fd :test\n";

		//String userInput = "if difference 0 0 [ fd 50 ]";
		//String userInput = "towards 45 -45";
		
		String userInput = new Scanner(new File("test.logo")).useDelimiter("\\Z").next();

		//String userInput = "if less? 1 2 [ fd 50 ]";

		Model m = new Model();

		m.parseProgram(userInput);

		m.executeAllCommands();
		
		//m.printLines();
	}
	
	private void printLines() {
		List<Line> lines = getGrid().getLines();

		for(Line l : lines) {
			System.out.println(l);
		}
	}

}
