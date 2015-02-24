package gui;
import java.util.ResourceBundle;


import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.Region;

public class TopMenu extends Region {


	protected double overlayWidth;
	protected double overlayHeight;

	public TopMenu(double overlayWidth, double overlayHeight) {


		this.overlayWidth = overlayWidth;
		this.overlayHeight = overlayHeight;
//		this.setMinSize(overlayWidth, overlayHeight);
//		this.setMaxSize(overlayWidth, overlayHeight);
//		this.getStyleClass().add("overlay-color");
		addMenuBar();

	}
	
	
	public void addMenuBar(){
		Menu menu1 = new Menu("File");
		Menu menu2 = new Menu("Turtle Options");
		Menu menu3 = new Menu("Language");
		Menu menu4 = new Menu("Help");
		
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menu1,menu2,menu3,menu4);		
		menuBar.setPrefWidth(overlayWidth);
		menuBar.setPrefHeight(.05 * overlayHeight);
		this.getChildren().add(menuBar);
		
		
		
		
		
		
	}

}
