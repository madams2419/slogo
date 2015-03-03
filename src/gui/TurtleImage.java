package gui;

import java.awt.Point;

import backend.Turtle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class TurtleImage extends ImageView{
	
	protected String imagePath;
	private double turtleWidthPct = .025;
	private double turtleHeightPct = .025;
	
	public TurtleImage(){
		
		String imagePath = "/sea_turtle.png";
		this.imagePath = imagePath;
		Image image = new Image(getClass().getResourceAsStream(
				"/sea_turtle.png"));
		this.setImage(image); 
		
		
	}
	
	public void setImagePath(String imagePath){
		
	}
	
	public void sizeTurtle(double screenWidth, double screenHeight){
		
		this.setFitWidth(turtleWidthPct * screenWidth);
		this.setFitHeight(turtleHeightPct * screenHeight); 
				
	}
	
	public void orientTurtle(Turtle turtle){
		
		this.setRotate(turtle.getHeading().getAngle()); 
	}
	
	public void setLocation(Turtle t){
		
		this.setLayoutX(t.getLocation().getX()); 
		this.setLayoutY(t.getLocation().getY());
		
	}

}
