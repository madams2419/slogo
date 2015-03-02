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
	
	//Hard Coded for now
	private double titleHeightPct = .1;
	
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
		makeTitle();

	}
	
	public void setText(String s){
		this.textArea.setText(s);
	}
	
	public TextArea makeTextArea() {

		TextArea textArea = new TextArea();
		textArea.setPrefRowCount(10);
		textArea.setPrefWidth(prefWidthRatio * overlayWidth);
		textArea.setPrefHeight((1 -titleHeightPct) *(prefHeightRatio * overlayHeight));
		textArea.setLayoutX(0);
		textArea.setLayoutY(titleHeightPct * (prefHeightRatio * overlayHeight));

		return textArea;

	}
	
	
	private void makeTitle(){
		
		Label title = new Label("  " + initText);
		title.setPrefHeight(titleHeightPct * (prefHeightRatio * overlayHeight)); 
		title.setPrefWidth(overlayWidth * prefWidthRatio);
		title.setLayoutX(0);
		title.setLayoutY(0);
		
		this.getChildren().add(title);
		
	}
	
	
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
