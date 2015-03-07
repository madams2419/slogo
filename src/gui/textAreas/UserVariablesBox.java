package gui.textAreas;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class UserVariablesBox extends AbstractEditableTextBox {
	private static double SIDE_OFFSET = 5.0;
	private VBox myLabels;
	private VBox myFields;
	private HBox myData;
	
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
		this.textArea.setEditable(false);
		this.label.getStyleClass().add("toplabel");
		
		myLabels = new VBox();
		//myLabels.setPrefWidth(prefWidthRatio * overlayWidth);
		myLabels.setPrefHeight((1 -titleHeightPct) *(prefHeightRatio * overlayHeight));
		myLabels.setLayoutX(SIDE_OFFSET);
		//myLabels.setLayoutY(titleHeightPct * (prefHeightRatio * overlayHeight));
		
		myFields = new VBox();
		myFields.setPrefWidth(prefWidthRatio * overlayWidth);
		myFields.setPrefHeight((1 -titleHeightPct) *(prefHeightRatio * overlayHeight));
		myFields.setLayoutX(SIDE_OFFSET + prefWidthRatio * overlayWidth); // is this the right X-layout?
		//myFields.setLayoutY(titleHeightPct * (prefHeightRatio * overlayHeight));
		
		myData = new HBox();
		myData.getChildren().add(myLabels);
		myData.getChildren().add(myFields);
		myData.setLayoutX(SIDE_OFFSET);
		myData.setLayoutY(titleHeightPct * (prefHeightRatio * overlayHeight));
		
		setRegionPreferences();
		addTextAreaToRegion();
		this.getChildren().add(myData);
	}

	public VBox getFields(){
		return myFields;
	}
	
	public VBox getLabels(){
		return myLabels;
	}
	
	@Override
	public void updateText() {
		// TODO Auto-generated method stub

	}

}
