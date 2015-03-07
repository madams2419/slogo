package gui;

import gui.textAreas.CommandBox;
import gui.textAreas.PreviousCommandsBox;
import gui.textAreas.StatusBox;
import gui.textAreas.UserFunctionsAndCommands;
import gui.textAreas.UserVariablesBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.stage.Screen;
import javafx.stage.Stage;

import backend.Model;



public class Main extends Application {

	private double topMenuHeightPct = .025;
	private double tabPanelHeightPct = .03;
	private SlogoTab activeTab;
	private HashMap<SlogoTab, Model> tabMap = new HashMap<>();
	private HashMap<Tab, SlogoTab> tabSLogoTabMap = new HashMap<>();
	private Group root = new Group();
	//TAKE THIS OUT, ONLY HERE FOR TESTING
	//THERE SHOULD BE A NEW MODEL FOR EACH TAB
	Model myModel = new Model();


	Stage stage;
	Scene scene;
	public Main(){
		
		
	}

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
		//Group root = new Group();
		//this.root = root;
		scene = new Scene(root, screenHeight, screenWidth);

		TabPanel tabPanel = new TabPanel(tabPanelHeightPct, screenHeight, screenWidth, this);
		
		TopMenu topMenu = new TopMenu(screenWidth, screenHeight,
				topMenuHeightPct, myModel);


		root.getChildren().add(topMenu);
		root.getChildren().add(tabPanel);

		// ApplicationView av = new ApplicationView(screenWidth, screenHeight);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
<<<<<<< HEAD

	private void updatePanels(){
		
		//updating command panel
		List<Command> comList = myModel.getExecutedCommands();
		ArrayList<Hyperlink> fields = new ArrayList<>();
		StringBuilder s = new StringBuilder();
		for (Command c : comList){
			Hyperlink h = new Hyperlink(c.toString());
			h.getStylesheets().add("GUIStyle.css");
			h.setOnAction(event -> {
				System.out.println("Link click");
				myModel.executeCommand(c);
				
				ArrayList<backend.Line> backLines = myModel.getGrid().getLines();
				turtlePanel.drawLines(backLines);			
				ArrayList<backend.Turtle> turtles = myModel.getGrid().getTurtles();
				turtlePanel.drawTurtles(turtles);
				updatePanels();
				
				//is this bad? ^^^ it is pseudo-recursive
				
		        });
			fields.add(h);
		}
		prevCommandsBox.setBoxes(fields);
		
		//updating status box
		s.setLength(0);
		for (Turtle t : this.myModel.getGrid().getTurtles()){
			s.append("Turtle "+ this.myModel.getGrid().getTurtles().indexOf(t) + ": \n  " + t.getLocation().getX() + ", " + t.getLocation().getY()
					+ "\n  " + t.getHeading().getAngle());
		}
		statusBox.setText(s.toString());
		
		//updating variables
		setVariablesBox();
		
	}
	
	private void setVariablesBox(){
		for (String s : myModel.getUserVariables().keySet())
			userVariablesBox.getFields().getChildren().add(new TextField(myModel.getUserVariables().get(s).toString())); // FIX THIS DECLARATION
		
		//more to come here
		
	}
	
	private void setButtonActions(){
		Button runButton = runButtons.getRunButton();
		Button stepButton = runButtons.getStepButton();
		
		runButton.setOnAction((event) -> {
			String s = commandBox.getText();
			myModel.parseProgram(s);
			myModel.executeAllCommands();
			
			ArrayList<backend.Line> backLines = myModel.getGrid().getLines();
			turtlePanel.drawLines(backLines);			
			ArrayList<backend.Turtle> turtles = myModel.getGrid().getTurtles();
			turtlePanel.drawTurtles(turtles);
			updatePanels();

		});
		
		stepButton.setOnAction((event) -> {
			String s = commandBox.getText();
			myModel.parseProgram(s);
			myModel.executeNextCommand();
			
			//Null check here?
			
			ArrayList<backend.Line> backLines = myModel.getGrid().getLines();
			turtlePanel.drawLines(backLines);			
			ArrayList<backend.Turtle> turtles = myModel.getGrid().getTurtles();
			turtlePanel.drawTurtles(turtles);
			updatePanels();
		});
		
	}
=======
>>>>>>> addTabs
	
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

	public SlogoTab getActiveTab() {
		return activeTab;
	}

	public void setActiveTab(SlogoTab activeTab) {
		if(this.activeTab != null){
			this.root.getChildren().remove(this.activeTab);
		}
		this.activeTab = activeTab;
		this.activeTab.setLayoutX(0);
		this.activeTab.setLayoutY(0);
		root.getChildren().add(this.activeTab);
		
		
	}

}
