package gui;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


public class RunButtons extends Region{
	
	

	public RunButtons(double screenHeight, double screenWidth, double overlayWidthPct, double overlayHeightPct, double xLocation, double yLocation) {


		this.setLayoutX(xLocation);
		this.setLayoutY(yLocation);
		
//		addRunButton();
//		addStepButton();
//		
		BorderPane border = new BorderPane();
		border.setPadding(new Insets(0, 0, 20, 20));

		Button runButton = new Button("Run All");
		Button stepButton = new Button("Step");
	
		

		runButton.setMaxWidth(Double.MAX_VALUE);
		stepButton.setMaxWidth(Double.MAX_VALUE);
		


		VBox vbButtons = new VBox(); 
		vbButtons.setSpacing(.03 * screenHeight);
		vbButtons.setPadding(new Insets(40, 20, 30, 40)); 
		vbButtons.getChildren().addAll(runButton, stepButton);
		
		System.out.println(vbButtons.getHeight());
		
		
		this.getChildren().add(vbButtons);
		 
		this.setPrefHeight(overlayHeightPct * screenHeight); 
		this.setPrefWidth(overlayWidthPct * screenWidth); 
		
		
	}
	
	private void addRunButton(){
		
		Button runButton = new Button("Run All"); 		
		this.getChildren().add(runButton);

	
		
	}
	
	private void addStepButton(){
		Button stepButton = new Button("Step");
		this.getChildren().add(stepButton);
	}

}
