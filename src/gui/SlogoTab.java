package gui;

import gui.textAreas.CommandBox;
import gui.textAreas.PreviousCommandsBox;
import gui.textAreas.StatusBox;
import gui.textAreas.UserFunctionsAndCommands;
import gui.textAreas.UserVariablesBox;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import javafx.stage.Screen;
import javafx.stage.Stage;
import backend.Model;
import backend.Turtle;
import backend.Variable;
import backend.command.Command;

public class SlogoTab extends Region {
	// Would be better if these values were stored somewhere/read in
	// possibly resource bundle.
	private double infoBoxWidthPct = .2;
	private double infoBoxHeightPct = .4725;
	private double commandBoxWidthPct = .5;
	private double commandBoxHeightPct = .25;
	private double topMenuHeightPct = .055;
	private double buttonWidthPct = .1;
	private double buttonHeightPct = .25;
	private RunButtons runButtons;
	private CommandBox commandBox;
	private DrawingArea turtlePanel;
	private PreviousCommandsBox prevCommandsBox;
	private StatusBox statusBox;
	private UserVariablesBox userVariablesBox;
	private Model myModel;

	public SlogoTab(Model model) {
		myModel = model;

		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		double screenHeight = this.getScreenHeight(bounds);
		double screenWidth = this.getScreenWidth(bounds);

		this.setPrefHeight(screenHeight);
		this.setPrefWidth(screenWidth);
		this.setLayoutX(0);
		this.setLayoutY(0);

		runButtons = new RunButtons(screenWidth, screenHeight, buttonWidthPct,
				buttonHeightPct, (infoBoxWidthPct + commandBoxWidthPct)
						* screenWidth, (1 - buttonHeightPct) * screenHeight);

		commandBox = new CommandBox(commandBoxHeightPct, commandBoxWidthPct
				+ buttonWidthPct, infoBoxWidthPct * screenWidth, screenHeight
				* (1 - commandBoxHeightPct), screenWidth, screenHeight,
				"Type a Command...", true, runButtons);

		statusBox = new StatusBox(infoBoxHeightPct, infoBoxWidthPct, 0,
				topMenuHeightPct * screenHeight, screenWidth, screenHeight,
				"Status", false);
		UserFunctionsAndCommands userFunctionsBox = new UserFunctionsAndCommands(
				infoBoxHeightPct, infoBoxWidthPct, 0,
				(topMenuHeightPct + infoBoxHeightPct) * screenHeight,
				screenWidth, screenHeight,
				"User Defined Functions and Commands", false);
		userVariablesBox = new UserVariablesBox(infoBoxHeightPct,
				infoBoxWidthPct, (1 - infoBoxWidthPct) * screenWidth,
				topMenuHeightPct * screenHeight, screenWidth, screenHeight,
				"User Defined Variables", false);
		prevCommandsBox = new PreviousCommandsBox(infoBoxHeightPct,
				infoBoxWidthPct, (1 - infoBoxWidthPct) * screenWidth,
				(topMenuHeightPct + infoBoxHeightPct) * screenHeight,
				screenWidth, screenHeight, "Previously Executed Commands",
				false);

		setButtonActions();
		Double drawingAreaWidth = screenWidth - 2
				* (screenWidth * infoBoxWidthPct);
		Double drawingAreaHeight = screenHeight
				- (screenHeight * (commandBoxHeightPct + topMenuHeightPct));

		turtlePanel = new DrawingArea(drawingAreaWidth, drawingAreaHeight,
				infoBoxWidthPct, screenHeight
						- (screenHeight * topMenuHeightPct));

		myModel.getGrid().setDimensions(drawingAreaWidth.intValue(),
				drawingAreaHeight.intValue());
		commandBox.setLayoutX(commandBox.getxLocation());
		commandBox.setLayoutY(commandBox.getyLocation());

		turtlePanel.setLayoutX(statusBox.getWidth());
		turtlePanel.setLayoutY(screenHeight * topMenuHeightPct);

		statusBox.setLayoutX(statusBox.getxLocation());
		statusBox.setLayoutY(statusBox.getyLocation());

		userFunctionsBox.setLayoutX(userFunctionsBox.getxLocation());
		userFunctionsBox.setLayoutY(userFunctionsBox.getyLocation());

		userVariablesBox.setLayoutX(userVariablesBox.getxLocation());
		userVariablesBox.setLayoutY(userVariablesBox.getyLocation());

		prevCommandsBox.setLayoutX(prevCommandsBox.getxLocation());
		prevCommandsBox.setLayoutY(prevCommandsBox.getyLocation());

		// root.getChildren().add(topMenu);

		this.getChildren().add(commandBox);

		// root.getChildren().add(runButtons);

		this.getChildren().add(statusBox);
		this.getChildren().add(userFunctionsBox);
		this.getChildren().add(userVariablesBox);
		this.getChildren().add(prevCommandsBox);

		this.getChildren().add(turtlePanel);

	}

	public void updatePanels() {

		setVariablesBox();

		List<Command> comList = myModel.getExecutedCommands();
		ArrayList<Hyperlink> fields = new ArrayList<>();
		StringBuilder s = new StringBuilder();
		for (Command c : comList) {
			Hyperlink h = new Hyperlink(c.toString());
			h.getStylesheets().add("GUIStyle.css");
			h.setOnAction(event -> {
				// System.out.println("Link click");
				myModel.executeCommand(c);

				List<backend.Line> backLines = myModel.getGrid().getLines();
				turtlePanel.drawLines(backLines);
				List<backend.Turtle> turtles = myModel.getGrid()
						.getAllTurtles();
				turtlePanel.drawTurtles(turtles);
				updatePanels();

				// is this bad? ^^^ it is pseudo-recursive

			});
			fields.add(h);
		}
		prevCommandsBox.setBoxes(fields);

		// updating status box
		s.setLength(0);
		for (Turtle t : this.myModel.getGrid().getAllTurtles()) {
			s.append("Turtle " + t.getID() + ": \n  " + t.getLocation().getX()
					+ ", " + t.getLocation().getY() + "\n  "
					+ t.getHeading().getAngle() + "\n");
		}
		statusBox.setText(s.toString());

		// updating variables

	}

	private void setVariablesBox() {

		userVariablesBox.getLabels().getChildren().clear();
		userVariablesBox.getFields().getChildren().clear();

		for (String s : myModel.getUserVariables().keySet()) {

			Label l = new Label(myModel.getUserVariables().get(s).toString());
			l.getStylesheets().add("GUIStyle.css");
			l.getStyleClass().add("varlabel");

			double val = myModel.getUserVariables().get(s).getValue();

			TextField t = new TextField(Double.toString(val));
			t.getStylesheets().add("GUIStyle.css");
			t.getStyleClass().add("varfield");
			t.setOnAction((event) -> {
				myModel.setUserVariable(myModel.getUserVariables().get(s)
						.toString(), new Variable(myModel.getUserVariables()
						.get(s).toString(), Double.parseDouble(t.getText())));
			});

			userVariablesBox.getLabels().getChildren().add(l);
			userVariablesBox.getFields().getChildren().add(t);

		}
	}

	private void setButtonActions() {
		Button runButton = runButtons.getRunButton();
		Button stepButton = runButtons.getStepButton();

		runButton.setOnAction((event) -> {
			String s = commandBox.getText();
			myModel.parseProgram(s);
			myModel.executeAllCommands();

			List<backend.Line> backLines = myModel.getGrid().getLines();
			turtlePanel.drawLines(backLines);
			List<backend.Turtle> turtles = myModel.getGrid().getAllTurtles();
			turtlePanel.drawTurtles(turtles);
			updatePanels();

		});

		stepButton.setOnAction((event) -> {
			String s = commandBox.getText();
			myModel.parseProgram(s);
			myModel.executeNextCommand();

			// Null check here?

				List<backend.Line> backLines = myModel.getGrid().getLines();
				turtlePanel.drawLines(backLines);
				List<backend.Turtle> turtles = myModel.getGrid()
						.getAllTurtles();
				turtlePanel.drawTurtles(turtles);
				updatePanels();
			});

	}

	private void setStageToFillWindow(Double screenWidth, Double screenHeight) {

		// stage.setX(0);
		// stage.setY(0);
		//
		// stage.setWidth(screenWidth);
		// stage.setHeight(screenHeight);

	}

	private double getScreenHeight(Rectangle2D bounds) {

		double screenHeight = bounds.getHeight();
		return screenHeight;

	}

	private double getScreenWidth(Rectangle2D bounds) {

		double screenWidth = bounds.getWidth();
		return screenWidth;

	}

	public DrawingArea getDrawingArea() {
		return this.turtlePanel;
	}

}
