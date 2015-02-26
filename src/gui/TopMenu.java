package gui;

import backend.Model;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Region;

public class TopMenu extends Region {

	protected double overlayWidth;
	protected double overlayHeight;
	protected double heightPct;

	public TopMenu(double overlayWidth, double overlayHeight, double heightPct) {

		this.overlayWidth = overlayWidth;
		this.overlayHeight = overlayHeight;
		this.heightPct = heightPct;
		addMenuBar();

	}

	public void addMenuBar() {

		Menu menuFile = new Menu("File");
		createFileMenuItems(menuFile);

		Menu menuTurtle = new Menu("Turtle Options");
		createTurtleMenuItems(menuTurtle);

		Menu menuLanguage = new Menu("Language");
		createLanguageMenuItems(menuLanguage);

		Menu menuHelp = new Menu("Help");
		createHelpMenuItems(menuHelp);

		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(menuFile, menuTurtle, menuLanguage, menuHelp);
		menuBar.setPrefWidth(overlayWidth);
		menuBar.setPrefHeight(heightPct * overlayHeight);
		this.getChildren().add(menuBar);

	}

	public void createFileMenuItems(Menu file) {

		MenuItem save = new MenuItem("Save Workspace");
		save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
		save.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				// TO DO
				// Make this actual save at some point
				System.out.println("Your workspace has been Saved");
			}
		});
		MenuItem load = new MenuItem("Load Workspace");
		load.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				// TO DO
				// Load an actual workspace
				System.out.println("Your workspace is loading...");
			}
		});

		file.getItems().addAll(save, load);

	}

	public void createTurtleMenuItems(Menu turtle) {

		MenuItem chooseTurtle = new MenuItem("Choose Turtle Image");
		MenuItem chooseBackgroundColor = new MenuItem("Background Color");
		turtle.getItems().addAll(chooseTurtle, chooseBackgroundColor);
	}

	public void createLanguageMenuItems(Menu language) {

		MenuItem English = new MenuItem("English");
		English.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				Model.setLanguage(English.getText());
				System.out.println("Your Language Choice is: English");
			}
		});
		MenuItem French = new MenuItem("French");
		French.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				Model.setLanguage(French.getText());
				System.out.println("Your Language Choice is: French");
			}
		});

		MenuItem Italian = new MenuItem("Italian");
		Italian.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				Model.setLanguage(Italian.getText());
				System.out.println("Your Language Choice is: Italian");
			}
		});
		MenuItem German = new MenuItem("German");
		German.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				Model.setLanguage(German.getText());
				System.out.println("Your Language Choice is: German");
			}
		});

		language.getItems().addAll(English, French, Italian, German);

	}

	public void createHelpMenuItems(Menu help) {

		MenuItem documentation = new MenuItem("Documentation");

		help.getItems().addAll(documentation);

	}

}
