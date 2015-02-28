package gui.textAreas;

import java.util.Stack;

import backend.command.*;
import backend.Model;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

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
		//this.setStyle("-fx-border-color: black;");
		this.isPrompt = isPrompt;
		
		this.textArea = makeTextArea();

		setRegionPreferences();
		addTextAreaToRegion();

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
		}

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
