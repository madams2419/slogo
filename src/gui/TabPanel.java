package gui;

import java.util.HashMap;

import backend.Model;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class TabPanel extends TabPane{
	
	double screenHeight;
	double screenWidth;
	double tabPaneHeightPct;
	double topOffsetPct = .025;
	Main main;
	private HashMap<Tab, SlogoTab> tabSlogoTabMap = new HashMap<>(); 
	Model myModel;
	
	
	public TabPanel(Double tabPanelHeightPct, Double screenHeight, Double screenWidth, Main main, Model model){
		
		this.screenHeight = screenHeight;
		this.screenWidth = screenWidth;
		this.tabPaneHeightPct = tabPanelHeightPct;
		this.main = main;
		myModel = model;
		
		makeTabPane(tabPaneHeightPct);
		
	}
	
	private void makeTabPane(Double tabPaneHeightPct) {
		
		this.setPrefHeight(tabPaneHeightPct * screenHeight); 
		this.setPrefWidth(screenWidth);
		this.setLayoutX(0);
		this.setLayoutY(topOffsetPct * screenHeight); 
		
		this.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Tab>() {

            @Override
            public void changed(ObservableValue<? extends Tab> arg0,
                    Tab arg1, Tab arg2) {
            	main.setActiveTab(tabSlogoTabMap.get(arg2));
            }
        });
	}
	
	public void makeNewTab(){
		final Tab tab = new Tab("Tab " + (this.getTabs().size() + 1));
		this.getTabs().add(tab);
		SlogoTab slogoTab = new SlogoTab(myModel);
		tabSlogoTabMap.put(tab, slogoTab);
		main.setActiveTab(slogoTab);
		//this.getSelectionModel().select(tab);
		
	}
	
	

}
