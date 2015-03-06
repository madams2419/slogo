package gui;

import java.awt.Point;

import backend.Turtle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleImage extends ImageView{
	
	protected String imagePath;
	protected double turtleWidthPct = .05;
	
	public TurtleImage(){
		
		String defaultImagePath = "../resources/sea_turtle.png";
		this.imagePath = defaultImagePath;
		Image image = new Image(getClass().getResourceAsStream(
				defaultImagePath));
		this.setImage(image); 
		
		
	}
	
	public void setImagePath(){
		
		this.imagePath = imagePath;
		
		
	}
	
	public void updateImage(){
		
		Image image = new Image(getClass().getResourceAsStream(
				this.imagePath));
		this.setImage(image);
		
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
