package gui;

import java.awt.Point;
import java.io.File;
import backend.Turtle;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TurtleImage extends ImageView {

	protected double turtleWidthPct = .05;
	protected String defaultImagePath = "../resources/sea_turtle.png";
	protected Turtle turtle;

	public TurtleImage(Turtle turtle) {

		this.turtle = turtle;
		updateImage();
		//On Clicked Image Choice Works but is not supported in backend. 
		this.addEventHandler(MouseEvent.MOUSE_CLICKED,
				new EventHandler<MouseEvent>() {

					@Override
					public void handle(MouseEvent event) {
						Stage fileChooserStage = new Stage();
						FileChooser fileChooser = new FileChooser();
						fileChooser.setTitle("Choose a Turtle Image");
						fileChooser.getExtensionFilters()
								.addAll(new FileChooser.ExtensionFilter(
										"All Images", "*.*"),
										new FileChooser.ExtensionFilter("JPG",
												"*.jpg"),
										new FileChooser.ExtensionFilter("GIF",
												"*.gif"),
										new FileChooser.ExtensionFilter("BMP",
												"*.bmp"),
										new FileChooser.ExtensionFilter("PNG",
												"*.png"));
						File file = fileChooser
								.showOpenDialog(fileChooserStage);
						String imagePath = file.getAbsolutePath();
						Image image = new Image(imagePath);
						System.out.println(imagePath);
						turtle.setImageByFullPath(imagePath);
						turtle.setImageByFullPath(imagePath);
						event.consume();
					}
				});

	}

	public void setDefaultImagePath() {

		if (turtle.getImagePath() == "turtle.jpg") {
			turtle.setImageByFullPath(this.defaultImagePath);
		}

	}

	public void updateImage() {

		Image newTurtle = new Image(getClass().getResourceAsStream(
				turtle.getImagePath()));

		this.setImage(newTurtle);

	}

	public void sizeTurtle(double screenWidth, double screenHeight) {

		this.setFitWidth(screenWidth * turtleWidthPct);
		this.setPreserveRatio(true);
		this.setSmooth(true);
		this.setCache(true);

	}

	public void orientTurtle(Turtle turtle) {

		this.setRotate(turtle.getHeading().getAngle() - 90);
	}

	public void setLocation(Point p) {

		this.setLayoutX(p.getX());
		this.setLayoutY(p.getY());

	}

}
