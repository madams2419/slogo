package gui.textAreas;

import javafx.scene.control.Label;
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
	protected Label label;
	public boolean isPrompt;

	protected double titleHeightPct = .1;
	
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
		this.isPrompt = isPrompt;
		setRegionPreferences();
		makeTitle();
		makeTextArea();

	}
	
	public void setText(String s){
		this.textArea.setText(s);
		this.textArea.getStylesheets().add("GUIStyle.css");
	}
	
	public TextArea makeTextArea() {
		TextArea textArea = new TextArea();
		textArea.setPrefRowCount(10);
		textArea.setPrefWidth(prefWidthRatio * overlayWidth);
		textArea.setPrefHeight((1 -titleHeightPct) *(prefHeightRatio * overlayHeight));
		textArea.setLayoutX(0);
		textArea.setLayoutY(titleHeightPct * (prefHeightRatio * overlayHeight));
		textArea.getStylesheets().add("GUIStyle.css");
		textArea.setWrapText(true);
		this.textArea = textArea;
		this.getChildren().add(textArea);
		return textArea;
	}
	
	
	private void makeTitle(){
		Label title = new Label("  " + initText);
		title.setPrefHeight(titleHeightPct * (prefHeightRatio * overlayHeight)); 
		title.setPrefWidth(overlayWidth * prefWidthRatio);
		title.setLayoutX(0);
		title.setLayoutY(0);
		title.getStylesheets().add("GUIStyle.css");
		this.label = title;
		this.getChildren().add(title);
	}
	
	
	public void setRegionPreferences() {

		this.setPrefHeight(prefHeightRatio * overlayHeight);
		this.setWidth(prefWidthRatio * overlayWidth);

	}
	
	public void addTextAreaToRegion() {
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
