// This entire file is part of my masterpiece.
// Sajal Kantha (skk21)
package gui;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import backend.Model;



public class RunSlogo extends Application {

	private double topMenuHeightPct = .025;
	private double tabPanelHeightPct = .03;
	private SlogoTab activeTab;
	private Group root = new Group();
	Model myModel = new Model();


	Stage stage;
	Scene scene;
	public RunSlogo(){
		
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		this.stage = primaryStage;
		primaryStage.setTitle("Slogo Interpreter");
		Screen screen = Screen.getPrimary();
		Rectangle2D bounds = screen.getVisualBounds();

		double screenHeight = this.getScreenHeight(bounds);
		double screenWidth = this.getScreenWidth(bounds);

		setStageToFillWindow(screenWidth, screenHeight);
		scene = new Scene(root, screenHeight, screenWidth);
		
		TabPanel tabPanel = new TabPanel(tabPanelHeightPct, screenHeight, screenWidth, this, myModel);
		
		TopMenu topMenu = new TopMenu(screenWidth, screenHeight,
				topMenuHeightPct, myModel, tabPanel);

		root.getChildren().add(topMenu);
		root.getChildren().add(tabPanel);
		
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
		this.activeTab.toBack();
	}
}
