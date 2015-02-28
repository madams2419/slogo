package gui;

public class StatusBox extends AbstractEditableTextBox {

	public StatusBox(double prefHeightRatio, double prefWidthRatio,
			double xLocation, double yLocation, double overlayWidth,
			double overlayHeight, String initText, boolean isPrompt) {
		super(prefHeightRatio, prefWidthRatio, xLocation, yLocation, overlayWidth,
				overlayHeight, initText, isPrompt);
		
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

	@Override
	public void updateText() {
		// TODO Auto-generated method stub
		
	}

}
