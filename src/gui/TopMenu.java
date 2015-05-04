package gui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.List;

import backend.Model;
import backend.Turtle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TopMenu extends Region {

	protected double overlayWidth;
	protected double overlayHeight;
	protected double heightPct;

	protected Model myModel;
	protected TabPanel tabPanel;

	public TopMenu(double overlayWidth, double overlayHeight, double heightPct,
			Model myModel, TabPanel tabPanel) {

		this.overlayWidth = overlayWidth;
		this.overlayHeight = overlayHeight;
		this.heightPct = heightPct;
		this.myModel = myModel;
		this.tabPanel = tabPanel;
		addMenuBar();

	}

	public void addMenuBar() {

		Menu menuFile = new Menu("File");
		createFileMenuItems(menuFile);

		Menu menuDisplay = new Menu("Display");
		createDisplayMenuItems(menuDisplay);

		Menu menuLanguage = new Menu("Language");
		createLanguageMenuItems(menuLanguage);

		Menu menuHelp = new Menu("Help");
		createHelpMenuItems(menuHelp);

		MenuBar menuBar = new MenuBar();

		menuBar.getMenus()
				.addAll(menuFile, menuDisplay, menuLanguage, menuHelp);
		menuBar.setPrefWidth(overlayWidth);
		menuBar.setPrefHeight(heightPct * overlayHeight);

		menuBar.getStylesheets().add("GUIStyle.CSS");
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
		MenuItem newTab = new MenuItem("New Tab");
		newTab.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				tabPanel.makeNewTab();
			}
		});
		MenuItem newWorkspace = new MenuItem("New Workspace");
		newWorkspace.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				tabPanel.makeNewTab();
			}
		});

		file.getItems().addAll(newWorkspace, save, load, newTab);

	}

	public void createDisplayMenuItems(Menu turtle) {

		MenuItem chooseTurtle = new MenuItem("Choose Turtle Image");
		chooseTurtle.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				// Turtle.setImage();
				System.out.println("You are choosing a new Turtle");
				File initTurtleImage = new File("../resources/sea_turtle.png");
				Stage fileChooserStage = new Stage();
				FileChooser fileChooser = new FileChooser();
				fileChooser.setTitle("Choose a Turtle Image");
				fileChooser.getExtensionFilters().addAll(
						new FileChooser.ExtensionFilter("All Images", "*.*"),
						new FileChooser.ExtensionFilter("JPG", "*.jpg"),
						new FileChooser.ExtensionFilter("GIF", "*.gif"),
						new FileChooser.ExtensionFilter("BMP", "*.bmp"),
						new FileChooser.ExtensionFilter("PNG", "*.png"));
				File file = fileChooser.showOpenDialog(fileChooserStage);
				String imagePath = file.getAbsolutePath();
				List<Turtle> turtles = myModel.getGrid().getAllTurtles();
				for (Turtle turtle : turtles) {

					try {
						turtle.setImageByFullPath(imagePath);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});

		MenuItem chooseBackgroundColor = new MenuItem("Background Color");
		chooseBackgroundColor.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				System.out.println("You are choosing a new Background Color");
				Color c = openColorPicker();

			}
		});

		MenuItem choosePenColor = new MenuItem("Choose Pen Color");
		choosePenColor.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				System.out.println("You are choosing a new Pen color");
				Color c = openColorPicker();
			}
		});
		
		MenuItem allTurtleViewMode = new MenuItem("Enter All Turtle View");
		allTurtleViewMode.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t){
				System.out.println("You Are Entering All Turtle View Mode");
			}
		});

		turtle.getItems().addAll(chooseTurtle, chooseBackgroundColor,
				choosePenColor);
	}

	public void createLanguageMenuItems(Menu language) {

		MenuItem English = new MenuItem("English");
		English.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				myModel.setLanguage(English.getText());
				System.out.println("Your Language Choice is: English");
			}
		});
		MenuItem French = new MenuItem("French");
		French.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				myModel.setLanguage(French.getText());
				System.out.println("Your Language Choice is: French");
			}
		});

		MenuItem Italian = new MenuItem("Italian");
		Italian.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				myModel.setLanguage(Italian.getText());
				System.out.println("Your Language Choice is: Italian");
			}
		});
		MenuItem German = new MenuItem("German");
		German.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				myModel.setLanguage(German.getText());
				System.out.println("Your Language Choice is: German");
			}
		});

		language.getItems().addAll(English, French, Italian, German);

	}

	public void createHelpMenuItems(Menu help) {

		MenuItem documentation = new MenuItem("Documentation");
		documentation.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent t) {
				File file = new File("src/resources/help.html");
				Desktop desktop = Desktop.getDesktop();
				try {
					desktop.open(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		help.getItems().addAll(documentation);

	}

	public Color openColorPicker() {

		ColorPickingScreen colorPicker = new ColorPickingScreen();
		Stage s = new Stage();
		colorPicker.start(s);
		System.out.println(colorPicker.getColor());
		colorPicker.getColor().toString();
		return colorPicker.getColor();
	}

	/*
	 * (takes) javafx.scene.paint.Color --> (returns) java.awt.Color
	 */
	public java.awt.Color paintToAwt(javafx.scene.paint.Color c) {
		return new java.awt.Color((float) c.getRed(), (float) c.getGreen(),
				(float) c.getBlue());
	}

}
