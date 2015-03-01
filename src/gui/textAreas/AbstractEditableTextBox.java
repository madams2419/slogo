package gui.textAreas;

import java.util.Stack;

import backend.command.*;
import backend.Model;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public abstract class AbstractEditableTextBox extends Region{
	
	protected double prefHeightRatio;
	protected double prefWidthRatio;
	private double xLocation;
	private double yLocation;
	protected double overlayWidth;
	protected double overlayHeight;
	protected String initText;
	protected TextArea textArea;
	public boolean isPrompt;
	
	public AbstractEditableTextBox(double prefHeightRatio,
			double prefWidthRatio, double xLocation, double yLocation,
			double overlayWidth, double overlayHeight, String initText,
			boolean isPrompt) {

		this.prefHeightRatio = prefHeightRatio;
		this.prefWidthRatio = prefWidthRatio;
		this.setxLocation(xLocation);
		this.setyLocation(yLocation);
		this.overlayHeight = overlayHeight; 
		this.overlayWidth = overlayWidth;
		this.initText = initText;
		
	
		this.setStyle("-fx-border-width: 200;");
		this.setStyle("-fx-border-style: dashed;");
		this.setStyle("-fx-border-radius: 20;");
		this.setStyle("-fx-border-insets: 67;");
		this.setStyle("-fx-border-color: red;");
		
		final String cssDefault = "-fx-border-color: blue;\n"
                + "-fx-border-insets: 5;\n"
                + "-fx-border-width: 3;\n"
                + "-fx-border-style: dashed;\n";
       
   
        //this.setStyle(cssDefault);
		

		this.isPrompt = isPrompt;
		
		this.textArea = makeTextArea();
		//this.setBorder(new Border(new BorderStroke(Color.BLACK, )))
		setRegionPreferences();
		addTextAreaToRegion();

	}
	
	public void setText(String s){
		this.textArea.setText(s);
	}
	
	public TextArea makeTextArea() {

		TextArea textArea = new TextArea();
		addTextToTextArea(textArea);
		textArea.setPrefRowCount(10);
		textArea.setPrefWidth(prefWidthRatio * overlayWidth);
		textArea.setPrefHeight(prefHeightRatio * overlayHeight);

		return textArea;

	}
	
	private void addTextToTextArea(TextArea ta) {
		if (this.isPrompt) {
			ta.setPromptText(this.initText);
			ta.getText();
			
		} else {
			ta.setText(this.initText);
			//makeTitle(this.initText);
		}

	}
	
	//LOTS OF HARD CODED CONSTANTS HERE
	
	/*private void makeTitle(String titleText){
		System.out.println(titleText);
		Label title = new Label(titleText);
		//title.setTextFill(Color.RED);
		//title.setTextAlignment(TextAlignment.CENTER);
		//title.setFont(new Font(14)); 
		title.setStyle("-fx-background-color: linear-gradient(#2A5058, #61a2b1);");
		//title.setStyle("-fx-fill: blue;");
		this.getChildren().add(title);
		

	}*/
	
	public void setRegionPreferences() {

		this.setPrefHeight(prefHeightRatio * overlayHeight);
		this.setWidth(prefWidthRatio * overlayWidth);

	}
	
	public void addTextAreaToRegion() {

		this.getChildren().add(this.textArea);

	}
	
	public abstract void updateText();

	public double getxLocation() {
		return xLocation;
	}

	public void setxLocation(double xLocation) {
		this.xLocation = xLocation;
	}

	public double getyLocation() {
		return yLocation;
	}

	public void setyLocation(double yLocation) {
		this.yLocation = yLocation;
	}

}
