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
		this.setStyle("-fx-border-color: black;");
		this.isPrompt = isPrompt;
		
		this.textArea = makeTextArea();

		setRegionPreferences();
		addTextAreaToRegion();
		
	}

	@Override
	public void updateText() {
		
		textArea.setText(makeExecutedCommandsList()); 
		
	}
	
	public String makeExecutedCommandsList(){
			
			//Need to change Model.getExecutedCommands() to static
			//Stack<Command> executedCommands = Model.getExecutedCommands();
			StringBuilder sb = new StringBuilder();
			//while(!executedCommands.isEmpty()){
				//sb.append("\n" + executedCommands.pop());
			//}
			
			return sb.toString();
			
			
		}

}
