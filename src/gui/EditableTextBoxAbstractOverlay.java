package gui;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

public class EditableTextBoxAbstractOverlay extends Region {

	protected double prefHeightRatio;
	protected double prefWidthRatio;
	protected double xLocation;
	protected double yLocation;
	protected double overlayWidth;
	protected double overlayHeight;
	protected String initText;

	public EditableTextBoxAbstractOverlay(double prefHeightRatio,
			double prefWidthRatio, double xLocation, double yLocation,
			double overlayWidth, double overlayHeight, String initText) {

		this.prefHeightRatio = prefHeightRatio;
		this.prefWidthRatio = prefWidthRatio;
		this.xLocation = xLocation;
		this.yLocation = yLocation;
		this.overlayHeight = overlayHeight;
		this.overlayWidth = overlayWidth;
		this.initText = initText;
		this.setStyle("-fx-border-color: black;");
		makeTextBox();
		
	}
	
	public void makeTextBox(){
		
		TextArea textArea = new TextArea(initText);
		textArea.setPrefRowCount(10);
		textArea.setLayoutX(0);
		textArea.setPrefWidth(prefWidthRatio * overlayWidth);
		textArea.setPrefHeight(prefHeightRatio * overlayHeight);
		this.setPrefHeight(prefHeightRatio * overlayHeight);
		this.setWidth(prefWidthRatio * overlayWidth);
		this.getChildren().add(textArea);
		
	}

}
