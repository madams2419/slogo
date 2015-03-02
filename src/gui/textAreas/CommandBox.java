package gui.textAreas;



public class CommandBox extends AbstractEditableTextBox {

	public CommandBox(double prefHeightRatio, double prefWidthRatio,
			double xLocation, double yLocation, double overlayWidth,
			double overlayHeight, String initText, boolean isPrompt) {
		
		super(prefHeightRatio, prefWidthRatio, xLocation, yLocation, overlayWidth,
				overlayHeight, initText, isPrompt);
		
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
