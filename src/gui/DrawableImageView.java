// This entire file is part of my masterpiece.
// Michael Adams

package gui;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import backend.DrawableImage;
import backend.Turtle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DrawableImageView extends ImageView{
	
	private double imageWidthPct;
	private DrawableImage drawableImage;
	private String curImagePath;
	
	public DrawableImageView(DrawableImage drawableImage, double turtleWidthPct){
		this.drawableImage = drawableImage;
		this.imageWidthPct = turtleWidthPct;
		updateImage();
	}
	
	public void updateImage() {
		String modelImagePath = drawableImage.getImagePath();
		
		if(curImagePath != modelImagePath) {
			curImagePath = modelImagePath;
			Image newImage = new Image(getClass().getResourceAsStream(drawableImage.getImagePath()));
			setImage(newImage);
		}
	}
	
	public void setImageSize(double screenWidth, double screenHeight){
		setFitWidth(screenWidth * imageWidthPct);
        setPreserveRatio(true);
        setSmooth(true);
        setCache(true);	
	}
	
	public void orientImage(){
		setRotate(drawableImage.getOrientation() - 90); 
	}
	
	public void setLocation(Point loc){
		setLayoutX(loc.getX()); 
		setLayoutY(loc.getY());
	}
	
	public double getImageWidthPct() {
		return imageWidthPct;
	}

}
