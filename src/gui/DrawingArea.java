package gui;

import java.awt.Point;
import java.util.List;
import java.util.HashMap;

import backend.DrawableImage;
import backend.Turtle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;

public class DrawingArea extends Region {

	protected double drawingAreaWidth;
	protected double drawingAreaHeight;
	protected double drawingAreaXLocation;
	protected double drawingAreaYLocation;
	protected Canvas drawingCanvas;
	protected HashMap<DrawableImage, DrawableImageView> turtleMap = new HashMap<>();

	public DrawingArea(double drawingAreaWidth, double drawingAreaHeight,
			double drawingAreaXLocation, double drawingAreaYLocation) {

		Canvas drawingCanvas = new Canvas(drawingAreaWidth, drawingAreaHeight);

		this.drawingAreaWidth = drawingAreaWidth;
		this.drawingAreaHeight = drawingAreaHeight;
		this.drawingAreaXLocation = drawingAreaXLocation;
		this.drawingAreaYLocation = drawingAreaYLocation;

		this.drawingCanvas = drawingCanvas;
		this.setHeight(drawingAreaHeight);
		this.setWidth(drawingAreaWidth);
		
		ScrollPane scrollPane = new ScrollPane(drawingCanvas);
		scrollPane.setPrefSize(drawingAreaWidth, drawingAreaHeight);
        scrollPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-focus-color: transparent;");
        
        
		this.getChildren().add(drawingCanvas);
		this.getChildren().add(scrollPane);
		

	}
	
	protected void drawLines(List<backend.Line> lines){
		this.drawingCanvas.getGraphicsContext2D().clearRect(-1000, -1000, 2000, 2000);
		for (backend.Line l : lines){
			this.drawingCanvas.getGraphicsContext2D().setLineWidth(l.getWidth());
			this.drawingCanvas.getGraphicsContext2D().setStroke(awtToPaint(l.getColor()));
			Point adjustedLStartPoint = convertCoordinates(l.getStartPoint());
			Point adjustedLEndPoint = convertCoordinates(l.getEndPoint());
			this.drawingCanvas.getGraphicsContext2D().strokeLine(adjustedLStartPoint.getX(), adjustedLStartPoint.getY(), 
					adjustedLEndPoint.getX(), adjustedLEndPoint.getY());
		}
		
		//System.out.println("drawLines complete");
	}
	
	protected void drawTurtles(List<DrawableImage> turtles, double imageWidthPct){
		// this.drawingCanvas.getGraphicsContext2D().setLineWidth(50);
		// this.drawingCanvas.getGraphicsContext2D().setStroke(Color.RED);
		
		
		for (DrawableImage t: turtles){
			
			DrawableImageView turtleImage;
			if(turtleMap.get(t) == null){
				turtleImage = new DrawableImageView(t, imageWidthPct);
				turtleMap.put(t, turtleImage);
				this.getChildren().add(turtleImage);

			}
			else{
				turtleImage = turtleMap.get(t);
				turtleImage.updateImage();
			}
			turtleImage.setImageSize(drawingAreaWidth, drawingAreaHeight); 
			
			Point adjustedTurtleLocation = convertCoordinates(t.getLocation());
			adjustedTurtleLocation = positionPointRelativeToLines(adjustedTurtleLocation, turtleImage);
			turtleImage.setLocation(adjustedTurtleLocation);
			turtleImage.orientImage();
		
		}
	}
	
	private Point positionPointRelativeToLines(Point turtleLocation, DrawableImageView turtleImage) {
		
		Point adjustedturtleLocation = new Point();
		double xLocation = turtleLocation.getX();
		double yLocation = turtleLocation.getY();
		
		xLocation = xLocation - (.5 * drawingAreaWidth * turtleImage.getImageWidthPct());
		yLocation = yLocation + (turtleImage.getFitHeight());
		
		adjustedturtleLocation.setLocation(xLocation, yLocation); 
		
		return adjustedturtleLocation;
	}

	protected Point convertCoordinates(Point point){ 
		
		Point adjustedCoordinatePoint = new Point();
		
		double xLocation = point.getX();
		double yLocation = point.getY();
		
		xLocation = xLocation + (.5 * drawingAreaWidth);
		yLocation = (.5 * drawingAreaHeight) + yLocation;
		
		adjustedCoordinatePoint.setLocation(xLocation, yLocation);
		return adjustedCoordinatePoint;
	}
	
	
	public javafx.scene.paint.Color awtToPaint(java.awt.Color c) {
		return Color.rgb(c.getRed(), c.getGreen(), c.getBlue());
	}
	
}
