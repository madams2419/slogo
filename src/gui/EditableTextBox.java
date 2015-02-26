package gui;

import java.util.Stack;

import backend.Command;
import backend.Model;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

public class EditableTextBox extends Region {

	protected double prefHeightRatio;
	protected double prefWidthRatio;
	protected double xLocation;
	protected double yLocation;
	protected double overlayWidth;
	protected double overlayHeight;
	protected String initText;
	protected TextArea textArea;
	public boolean isPrompt;

	public EditableTextBox(double prefHeightRatio,
			double prefWidthRatio, double xLocation, double yLocation,
			double overlayWidth, double overlayHeight, String initText,
			boolean isPrompt) {

		this.prefHeightRatio = prefHeightRatio;
		this.prefWidthRatio = prefWidthRatio;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.overlayHeight = overlayHeight; 
		this.overlayWidth = overlayWidth;
		this.initText = initText;
		this.setStyle("-fx-border-color: black;");
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
	
	public void makeExecutedCommandsList(){
		
		Stack<Command> executedCommands = Model.getExecutedCommands();
		StringBuilder sb = new StringBuilder();
		while(!executedCommands.isEmpty()){
			sb.append("\n" + executedCommands.pop());
		}
		
		textArea.setText(textArea.getText() + sb.toString());
		
		
		
		
	}

}
