package gui;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;


public class RunButtons extends Region{
	
	protected double overlayWidth;
	protected double overlayHeight;

	public RunButtons(double overlayWidth, double overlayHeight) {


		this.overlayWidth = overlayWidth;
		this.overlayHeight = overlayHeight;
		this.setLayoutX(.5 * overlayWidth);
		this.setLayoutY(.25 * overlayHeight);
		
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
		vbButtons.setSpacing(.05 * overlayHeight);
		vbButtons.setPadding(new Insets(0, 20, 20, 20)); 
		vbButtons.getChildren().addAll(runButton, stepButton);
		
		
		this.getChildren().add(vbButtons);
		
		this.setLayoutX(.5 * overlayWidth);
		this.setLayoutY(.8 * overlayHeight); 
		this.setPrefHeight(.25 * overlayHeight); 
		this.setPrefWidth(.1 * overlayWidth); 
		
		
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
