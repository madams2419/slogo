package gui.textAreas;

import java.util.ArrayList;
import java.util.Stack;

import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import backend.Model;
import backend.command.Command;

public class PreviousCommandsBox extends AbstractEditableTextBox {
	private VBox col;
	private static double SIDE_OFFSET = 5.0;
	public PreviousCommandsBox(double prefHeightRatio, double prefWidthRatio,
			double xLocation, double yLocation, double overlayWidth,
			double overlayHeight, String initText, boolean isPrompt) {
		super(prefHeightRatio, prefWidthRatio, xLocation, yLocation, overlayWidth,
				overlayHeight, initText, isPrompt);

		col = new VBox();
		this.label.getStyleClass().add("midlabel");
		this.textArea.setEditable(false);
		this.getChildren().add(col);
		
		col.setPrefWidth(prefWidthRatio * overlayWidth);
		col.setPrefHeight((1 -titleHeightPct) *(prefHeightRatio * overlayHeight));
		col.setLayoutX(SIDE_OFFSET);
		col.setLayoutY(titleHeightPct * (prefHeightRatio * overlayHeight));
	}

	public void setBoxes(ArrayList<Hyperlink> fields){
		col.getChildren().clear(); // BAD WAY OF DOING THIS - would make more sense if they were just added or removed and not cleared and rewritten each time
		for (Hyperlink h : fields)
			col.getChildren().add(h);
	}
	
	@Override
	public void updateText() {
		
		//textArea.setText(makeExecutedCommandsList()); 
		
	}
	


}
