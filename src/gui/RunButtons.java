package gui;
import java.util.Stack;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import backend.command.Command;
import java.util.EventListener;

public class RunButtons extends Region{
	
	////////////////////////////////////////////
	Button runButton;
	Button stepButton;
	//Dont let these stay as instance variables - they're only so currently to allow for the getters
	/////////////////////////////////////////////

	public RunButtons(double screenHeight, double screenWidth, double overlayWidthPct, double overlayHeightPct, double xLocation, double yLocation) {


		this.setLayoutX(xLocation);
		this.setLayoutY(yLocation);

		//Not really sure if these are needed
		BorderPane border = new BorderPane();
		border.setPadding(new Insets(0, 0, 20, 20));
		
		this.setPrefHeight(overlayHeightPct * screenHeight); 
		this.setPrefWidth(overlayWidthPct * screenWidth); 
		this.setStyle("-fx-border-color: black;");
		
		runButton = new Button("Run All");
		stepButton = new Button("Step");
	
		

		runButton.setMaxWidth(Double.MAX_VALUE);
		stepButton.setMaxWidth(Double.MAX_VALUE);
		
		


		VBox vbButtons = new VBox(); 
		vbButtons.setSpacing(.03 * screenHeight);
		vbButtons.setPadding(new Insets(40, 20, 30, 40)); 
		vbButtons.getChildren().addAll(runButton, stepButton);
		
		//vbButtons.setStyle("-fx-border-color: black;");
			
		this.getChildren().add(vbButtons);
		 
		this.setPrefHeight(overlayHeightPct * screenHeight); 
		this.setPrefWidth(overlayWidthPct * screenWidth); 
		
		
	}
	
	////////////////////////////
	//ideally we don't have these
	public Button getRunButton(){
		return runButton;
	}
	
	public Button getStepButton(){
		return stepButton;
	}
	///////////////////////////////
	private void addRunButton(){
		
		Button runButton = new Button("Run All"); 		
		this.getChildren().add(runButton);

	
		
	}
	
	private void addStepButton(){
		Button stepButton = new Button("Step");
		this.getChildren().add(stepButton);
	}

}
