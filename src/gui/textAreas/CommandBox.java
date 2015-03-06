package gui.textAreas;

import gui.RunButtons;



public class CommandBox extends AbstractEditableTextBox {

	private static double BOX_RATIO = 0.8;
	private static double SPACING_AMT = 10;
	private RunButtons runButtons;
	
	public CommandBox(double prefHeightRatio, double prefWidthRatio,
			double xLocation, double yLocation, double overlayWidth,
			double overlayHeight, String initText, boolean isPrompt, RunButtons runButtons) {
		
		super(prefHeightRatio, prefWidthRatio, xLocation, yLocation, overlayWidth,
				overlayHeight, initText, isPrompt);
		this.runButtons = runButtons;
		this.runButtons.setLayoutX(2*SPACING_AMT + overlayWidth*prefWidthRatio*BOX_RATIO);
		this.runButtons.setLayoutY(SPACING_AMT);
		this.label.getStyleClass().add("statuslabel");
		this.getStylesheets().add("GUIStyle.css");
		this.getStyleClass().add("overlay");
		
		//this.label.setPrefHeight(2 * titleHeightPct * (prefHeightRatio * overlayHeight)); 
		this.label.setPrefWidth(overlayWidth * prefWidthRatio );
		this.textArea.setPrefWidth(overlayWidth*prefWidthRatio*BOX_RATIO);
		this.textArea.getStyleClass().add("commandbox");
		textArea.setLayoutX(SPACING_AMT);
		textArea.setLayoutY(SPACING_AMT + titleHeightPct * (prefHeightRatio * overlayHeight));

		
		
		//addButtons();
		this.getChildren().add(runButtons);
		setCommandBoxPromptText("Type a Command...");
	}
	
	
	public String getText(){
		return this.textArea.getText(); // Right method call?
	}
	
	private void setCommandBoxPromptText(String promptText){
		this.textArea.setPromptText(promptText);
		
	}
	
	@Override
	public void updateText() {
		// TODO Auto-generated method stub
		
		
	}


		
}
