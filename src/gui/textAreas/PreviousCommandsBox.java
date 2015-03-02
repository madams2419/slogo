package gui.textAreas;

import java.util.Stack;

import backend.Model;
import backend.command.Command;

public class PreviousCommandsBox extends AbstractEditableTextBox {

	public PreviousCommandsBox(double prefHeightRatio, double prefWidthRatio,
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
		this.isPrompt = isPrompt;
		this.label.getStyleClass().add("midlabel");

		this.textArea = makeTextArea();
		this.textArea.setEditable(false);
		
		setRegionPreferences();
		addTextAreaToRegion();
		
	}

	@Override
	public void updateText() {
		
		//textArea.setText(makeExecutedCommandsList()); 
		
	}
	


}
