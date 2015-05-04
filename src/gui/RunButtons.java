package gui;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


public class RunButtons extends Region {
	
	Button runButton;
	Button stepButton;
	// Dont let these stay as instance variables - they're only so currently to
	// allow for the getters

	public RunButtons(double screenHeight, double screenWidth, double overlayWidthPct, double overlayHeightPct, double xLocation, double yLocation) {


		this.setLayoutX(xLocation);
		this.setLayoutY(yLocation);
		
		this.setPrefHeight(overlayHeightPct * screenHeight); 
		this.setPrefWidth(overlayWidthPct * screenWidth); 
		
		runButton = new Button("Run All");
		stepButton = new Button("Step");

		runButton.setMaxWidth(Double.MAX_VALUE);
		stepButton.setMaxWidth(Double.MAX_VALUE);
		
		runButton.getStylesheets().add("GUIStyle.css");
		stepButton.getStylesheets().add("GUIStyle.css");

		VBox vbButtons = new VBox(); 
		vbButtons.setSpacing(.03 * screenHeight);
		vbButtons.setPadding(new Insets(40, 20, 30, 40)); 
		vbButtons.getChildren().addAll(runButton, stepButton);
			
		this.getChildren().add(vbButtons);
		this.setPrefHeight(overlayHeightPct * screenHeight); 
		this.setPrefWidth(overlayWidthPct * screenWidth); 
		
	}

	public Button getRunButton() {
		return runButton;
	}

	public Button getStepButton() {
		return stepButton;
	}

	

}
