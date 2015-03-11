package gui;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import backend.Turtle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleImage extends ImageView{
	
	protected double turtleWidthPct = .05;
	protected String defaultImagePath = "../resources/sea_turtle.png";
	protected Turtle turtle;
	public TurtleImage(Turtle turtle){
		
		this.turtle = turtle;
		//setDefaultImagePath();
		updateImage();
		
		
	}
	
	public void setDefaultImagePath(){
		
		if(turtle.getImagePath() == "turtle.jpg"){
			turtle.setImageFullPath(this.defaultImagePath);
		}
		
	}
	
	public void updateImage() {

		Image newTurtle = new Image(getClass().getResourceAsStream(turtle.getImagePath()));
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
		//System.out.println(turtle.getHeading().getAngle());
	}
	
	public void setLocation(Point p){
		
		this.setLayoutX(p.getX()); 
		this.setLayoutY(p.getY());
		
	}

}
