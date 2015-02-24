package gui;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

public class CommandBox extends Region {
	

	protected double overlayWidth;
	protected double overlayHeight;

	public CommandBox(double overlayWidth, double overlayHeight) {


		this.overlayWidth = overlayWidth;
		this.overlayHeight = overlayHeight;
		this.getStyleClass().add("overlay-color");
		createCommandBox();

	}
	
	private void createCommandBox() {

		// JTextArea textArea = new JTextArea(5,20);
		// JScrollPane scrollPane = new JScrollPane(textArea);
		// root

		TextArea textArea = new TextArea("Type Commands Here");
		textArea.setPrefRowCount(10);
		textArea.setLayoutX(0);
		textArea.setPrefWidth(.5 * overlayWidth);
		textArea.setPrefHeight(overlayHeight * .25);
		this.setPrefHeight(.25 * overlayHeight);
		this.setWidth(.5 * overlayWidth);
		this.getChildren().add(textArea);
		
		


	}

}
