package gui;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Region;

public class CommandBox extends Region {
	

	protected double overlayWidth;
	protected double overlayHeight;
	protected double widthPct;
	protected double heightPct;

	public CommandBox(double overlayWidth, double overlayHeight, double widthPct, double heightPct) {


		this.overlayWidth = overlayWidth;
		this.overlayHeight = overlayHeight;
		this.widthPct = widthPct;
		this.heightPct = heightPct;
		this.setStyle("-fx-border-color: black;");
		createCommandBox();

	}
	
	private void createCommandBox() {

		// JTextArea textArea = new JTextArea(5,20);
		// JScrollPane scrollPane = new JScrollPane(textArea);
		// root

		TextArea textArea = new TextArea();
		textArea.setPromptText("Type Commands Here...");
		textArea.getText();
		textArea.setPrefRowCount(10);
		textArea.setLayoutX(0);
		textArea.setPrefWidth(widthPct * overlayWidth);
		textArea.setPrefHeight(overlayHeight * heightPct);
		this.setPrefHeight(heightPct * overlayHeight);
		this.setWidth(widthPct * overlayWidth);
		this.getChildren().add(textArea);
		
		


	}

}
