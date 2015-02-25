package gui;

import javax.swing.JScrollPane;

import javafx.css.*;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Main extends Application {

	private Timeline timeline;
	private KeyFrame keyFrame;
	private Group root;
	private long lastTime;
	private double infoBoxWidthPct = .4;
	private double commandBoxWidthPct = .5;
	private double commandBoxHeightPct = .25;
	private double topMenuHeightPct = .05;
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

		CommandBox commandBox = new CommandBox(screenWidth, screenHeight, commandBoxWidthPct, commandBoxHeightPct);

		EditableTextBoxAbstractOverlay statusBox = new EditableTextBoxAbstractOverlay(
				.25, infoBoxWidthPct, (1 - infoBoxWidthPct) * screenWidth, .75 * screenHeight, screenWidth,
				screenHeight, "Status");
		EditableTextBoxAbstractOverlay userFunctionsBox = new EditableTextBoxAbstractOverlay(
				.25, infoBoxWidthPct, (1 - infoBoxWidthPct) * screenWidth, .5 * screenHeight, screenWidth,
				screenHeight, "User Defined Functions and Commands");
		EditableTextBoxAbstractOverlay userVariablesBox = new EditableTextBoxAbstractOverlay(
				.25, infoBoxWidthPct, (1 - infoBoxWidthPct) * screenWidth, .25 * screenHeight, screenWidth,
				screenHeight, "User Defined Variables");
		EditableTextBoxAbstractOverlay prevCommandsBox = new EditableTextBoxAbstractOverlay(
				.2, infoBoxWidthPct, (1 - infoBoxWidthPct) * screenWidth, (float)0.05 * (float) screenHeight, screenWidth,
				screenHeight, "Previously Executed Commands");

		TopMenu topMenu = new TopMenu(screenWidth, screenHeight, topMenuHeightPct);
		
		RunButtons runButtons = new RunButtons(screenWidth, screenHeight);
		
		DrawingArea turtlePanel = new DrawingArea(screenWidth - (screenWidth * infoBoxWidthPct), 
				screenHeight - (screenHeight * (commandBoxHeightPct + topMenuHeightPct)), 0, screenHeight - (screenHeight * topMenuHeightPct));
		

		// TODO
		// Determine this location based on other values

		commandBox.setLayoutY(screenHeight - commandBox.getPrefHeight());
		commandBox.setLayoutX(0);
		
		turtlePanel.setLayoutX(0);
		turtlePanel.setLayoutY(screenHeight * topMenuHeightPct);
		
		
		statusBox.setLayoutX(statusBox.xLocation);
		statusBox.setLayoutY(statusBox.yLocation);
		
		userFunctionsBox.setLayoutX(userFunctionsBox.xLocation);
		userFunctionsBox.setLayoutY(userFunctionsBox.yLocation);
		
		userVariablesBox.setLayoutX(userVariablesBox.xLocation);
		userVariablesBox.setLayoutY(userVariablesBox.yLocation);
		
		prevCommandsBox.setLayoutX(prevCommandsBox.xLocation);
		prevCommandsBox.setLayoutY(prevCommandsBox.yLocation);

		
		

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
