package gui;

import java.awt.Point;

import backend.Turtle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleImage extends ImageView{
	
	protected String imagePath;
	private double turtleWidthPct = .025;
	private double turtleHeightPct = .025;
	
	public TurtleImage(String imagePath){
		
		this.imagePath = imagePath;
		Image image = new Image(imagePath);
		this.setImage(image); 
		
		
	}
	
	public void sizeTurtle(double screenWidth, double screenHeight){
		
		this.setFitWidth(turtleWidthPct * screenWidth);
		this.setFitHeight(turtleHeightPct * screenHeight); 
				
	}
	
	public void orientTurtle(Turtle turtle){
		
		this.setRotate(turtle.getHeading().getAngle()); 
	}
	
	public void setLocation(Turtle turtle){
		Point Location = turtle.getLocation();
	}

}
