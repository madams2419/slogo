package backend;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

import backend.command.*;

public class Model {

	private BiIndex<Color> colorMap;
	private BiIndex<String> imageMap;
	private Grid grid;
	private Queue<Command> pendingCommands;
	private static Stack<Command> executedCommands;
	private HashMap<String, Variable> userVariables;
	private HashMap<String, UserInstructionContainer> userInstructions;
	private String helpPagePath;
	private CommandFactory comFactory;
	private SLogoParser parser;

	public Model() {
		colorMap = new BiIndex<>(Defaults.COLOR_MAP);
		imageMap = new BiIndex<>(Defaults.IMAGE_MAP);
		Turtle turtle = new Turtle(1, colorMap, imageMap);
		grid = new Grid(new Dimension(Defaults.GRID_WIDTH, Defaults.GRID_HEIGHT), colorMap, imageMap, turtle);
		pendingCommands = new LinkedList<>();
		executedCommands = new Stack<>();
		userVariables = new HashMap<>();
		userInstructions = new HashMap<>();
		helpPagePath = Defaults.HELP_PAGE_PATH;
		comFactory = new CommandFactory(this);
		parser = new SLogoParser(comFactory);
	}

	public BiMap<Integer, Color> getColorMap() {
		return colorMap;
	}

	public BiMap<Integer, String> getImageMap() {
		return imageMap;
	}

	public void parseProgram(String prog) {
		pendingCommands = parser.parseProgram(prog);
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
		}
		printDrawableImages();
		return executedCommands;
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
		parser.changeLanguage(language);
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

	// Debug methods
	private void printLines() {
		List<Line> lines = getGrid().getLines();

		for(Line l : lines) {
			System.out.println(l);
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

	private void printDrawableImages() {
		List<DrawableImage> dbis = grid.getDrawableImages();
		for(DrawableImage t : dbis) {
			System.out.printf("%s at (%f, %f) with image %s\n", t.getClass().getName(), t.getLocation().getX(), t.getLocation().getY(), t.getImagePath());
		}
	}

}
