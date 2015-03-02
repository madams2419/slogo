package gui.textAreas;

import javafx.scene.layout.VBox;


public class UserVariablesBox extends AbstractEditableTextBox {

	private VBox myFields;
	
	public UserVariablesBox(double prefHeightRatio, double prefWidthRatio,
			double xLocation, double yLocation, double overlayWidth,
			double overlayHeight, String initText, boolean isPrompt) {
		super(prefHeightRatio, prefWidthRatio, xLocation, yLocation,
				overlayWidth, overlayHeight, initText, isPrompt);

		this.prefHeightRatio = prefHeightRatio;
		this.prefWidthRatio = prefWidthRatio;
		this.setxLocation(xLocation);
		this.setyLocation(yLocation);
		this.overlayHeight = overlayHeight;
		this.overlayWidth = overlayWidth;
		this.initText = initText;
		this.isPrompt = isPrompt;

		this.textArea = makeTextArea();
		myFields = new VBox();
		setRegionPreferences();
		addTextAreaToRegion();
	}

	public VBox getFields(){
		return myFields;
	}
	
	@Override
	public void updateText() {
		// TODO Auto-generated method stub

	}

}
