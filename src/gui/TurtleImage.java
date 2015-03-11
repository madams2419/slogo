package gui;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import backend.Turtle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleImage extends ImageView{
	
	protected String imagePath;
	protected double turtleWidthPct = .05;
	protected String defaultImagePath = "../resources/sea_turtle.png";
	protected Turtle turtle;
	public TurtleImage(Turtle turtle){
		
		this.turtle = turtle;
		this.imagePath = turtle.getImagePath();
		//setDefaultImagePath();
		Image image = new Image(getClass().getResourceAsStream(
				turtle.getImagePath()));
		this.setImage(image); 
		
		
	}
	
	public void setImagePath(){
		
		this.imagePath = imagePath;
		turtle.setImagePath(imagePath);
		updateImage();
		
	}
	
	public void setDefaultImagePath(){
		
		if(turtle.getImagePath() == "turtle.jpg"){
			turtle.setImagePath(this.defaultImagePath);
		}
		
	}
	
	public void updateImage() {

		String imagePath = turtle.getImagePath();
		imagePath = imagePath.replace("\\", "/");
		Image newTurtle = null;
		if (imagePath == defaultImagePath) {
			newTurtle = new Image(getClass().getResourceAsStream(
					defaultImagePath));
		} else {

			FileInputStream in = null;
			try {
				in = new FileInputStream(imagePath);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			newTurtle = new Image(in);
		}
		
		// Image image = new Image(getClass().getResourceAsStream(imnew
		// Image(getClass().getResourceAsStream(imagePath));agePath));
		this.setImage(newTurtle);

	}
	
	
	
	public void sizeTurtle(double screenWidth, double screenHeight){
		
		this.setFitWidth(screenWidth * turtleWidthPct);
        this.setPreserveRatio(true);
        this.setSmooth(true);
        this.setCache(true);
				
	}
	
	public void orientTurtle(Turtle turtle){
		
		this.setRotate(turtle.getHeading().getAngle() - 90); 
		System.out.println(turtle.getHeading().getAngle());
	}
	
	public void setLocation(Point p){
		
		this.setLayoutX(p.getX()); 
		this.setLayoutY(p.getY());
		
	}

}
