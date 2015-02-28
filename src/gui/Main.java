package gui;

import gui.textAreas.CommandBox;
import gui.textAreas.PreviousCommandsBox;
import gui.textAreas.StatusBox;
import gui.textAreas.UserFunctionsAndCommands;
import gui.textAreas.UserVariablesBox;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

	private Timeline timeline;
	private KeyFrame keyFrame;
	private Group root;
	private long lastTime;
	private double infoBoxWidthPct = .2;
	private double infoBoxHeightPct = .475;
	private double commandBoxWidthPct = .5;
	private double commandBoxHeightPct = .25;
	private double topMenuHeightPct = .05;
	private double buttonWidthPct = .1;
	private double buttonHeightPct = .25;

	Stage stage;
	Scene scene;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		stage = primaryStage;
		primaryStage.setTitle("Slogo Interpreter");
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		double screenHeight = this.getScreenHeight(bounds);
		double screenWidth = this.getScreenWidth(bounds);

		setStageToFillWindow(screenWidth, screenHeight);
		Group root = new Group();
		scene = new Scene(root, screenHeight, screenWidth);

		CommandBox commandBox = new CommandBox(commandBoxHeightPct,
				commandBoxWidthPct, infoBoxWidthPct * screenWidth, screenHeight
						* (1 - commandBoxHeightPct), screenWidth, screenHeight,
				"Type a Command...", true);

		StatusBox statusBox = new StatusBox(infoBoxHeightPct, infoBoxWidthPct,
				0, topMenuHeightPct * screenHeight, screenWidth, screenHeight,
				"Status", false);
		UserFunctionsAndCommands userFunctionsBox = new UserFunctionsAndCommands(
				infoBoxHeightPct, infoBoxWidthPct, 0,
				(topMenuHeightPct + infoBoxHeightPct) * screenHeight,
				screenWidth, screenHeight,
				"User Defined Functions and Commands", false);
		UserVariablesBox userVariablesBox = new UserVariablesBox(
				infoBoxHeightPct, infoBoxWidthPct, (1 - infoBoxWidthPct)
						* screenWidth, topMenuHeightPct * screenHeight,
				screenWidth, screenHeight, "User Defined Variables", false);
		PreviousCommandsBox prevCommandsBox = new PreviousCommandsBox(
				infoBoxHeightPct, infoBoxWidthPct, (1 - infoBoxWidthPct)
						* screenWidth, (topMenuHeightPct + infoBoxHeightPct)
						* screenHeight, screenWidth, screenHeight,
				"Previously Executed Commands", false);

		TopMenu topMenu = new TopMenu(screenWidth, screenHeight,
				topMenuHeightPct);

		RunButtons runButtons = new RunButtons(screenWidth, screenHeight,
				buttonWidthPct, buttonHeightPct,
				(infoBoxWidthPct + commandBoxWidthPct) * screenWidth,
				(1 - buttonHeightPct) * screenHeight);

		DrawingArea turtlePanel = new DrawingArea(screenWidth
				- (screenWidth * infoBoxWidthPct), screenHeight
				- (screenHeight * (commandBoxHeightPct + topMenuHeightPct)),
				infoBoxWidthPct, screenHeight
						- (screenHeight * topMenuHeightPct));

		// TODO
		// Determine this location based on other values

		commandBox.setLayoutX(commandBox.getxLocation());
		commandBox.setLayoutY(commandBox.getyLocation());

		turtlePanel.setLayoutX(0);
		turtlePanel.setLayoutY(screenHeight * topMenuHeightPct);

		statusBox.setLayoutX(statusBox.getxLocation());
		statusBox.setLayoutY(statusBox.getyLocation());

		userFunctionsBox.setLayoutX(userFunctionsBox.getxLocation());
		userFunctionsBox.setLayoutY(userFunctionsBox.getyLocation());

		userVariablesBox.setLayoutX(userVariablesBox.getxLocation());
		userVariablesBox.setLayoutY(userVariablesBox.getyLocation());

		prevCommandsBox.setLayoutX(prevCommandsBox.getxLocation());
		prevCommandsBox.setLayoutY(prevCommandsBox.getyLocation());

		root.getChildren().add(topMenu);

		root.getChildren().add(commandBox);

		root.getChildren().add(runButtons);

		root.getChildren().add(statusBox);
		root.getChildren().add(userFunctionsBox);
		root.getChildren().add(userVariablesBox);
		root.getChildren().add(prevCommandsBox);

		root.getChildren().add(turtlePanel);

		// ApplicationView av = new ApplicationView(screenWidth, screenHeight);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private void setStageToFillWindow(Double screenWidth, Double screenHeight) {

		stage.setX(0);
		stage.setY(0);

		stage.setWidth(screenWidth);
		stage.setHeight(screenHeight);

	}

	private double getScreenHeight(Rectangle2D bounds) {

		double screenHeight = bounds.getHeight();
		return screenHeight;

	}

	private double getScreenWidth(Rectangle2D bounds) {

		double screenWidth = bounds.getWidth();
		return screenWidth;

	}

	public static void main(String[] args) {
		launch(args);
	}

}
