package gui;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;

import backend.Turtle;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
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
	protected HashMap<Turtle, TurtleImage> turtleMap = new HashMap<>();

	public DrawingArea(double drawingAreaWidth, double drawingAreaHeight,
			double drawingAreaXLocation, double drawingAreaYLocation) {

		Canvas drawingCanvas = new Canvas(drawingAreaWidth, drawingAreaHeight);

		this.drawingAreaWidth = drawingAreaWidth;
		this.drawingAreaHeight = drawingAreaHeight;
		this.drawingAreaXLocation = drawingAreaXLocation;
		this.drawingAreaYLocation = drawingAreaYLocation;

		this.drawingCanvas = drawingCanvas;
		this.getChildren().add(drawingCanvas);
		this.setHeight(drawingAreaHeight);
		this.setWidth(drawingAreaWidth);
		//this.setStyle("-fx-border-color: black;");

	}
	
	protected void drawLines(ArrayList<backend.Line> lines){
		this.drawingCanvas.getGraphicsContext2D().setLineWidth(5);
		this.drawingCanvas.getGraphicsContext2D().setStroke(Color.BLUE);
		for (backend.Line l : lines){
			Point adjustedLStartPoint = convertCoordinates(l.getStartPoint());
			Point adjustedLEndPoint = convertCoordinates(l.getEndPoint());
			this.drawingCanvas.getGraphicsContext2D().strokeLine(adjustedLStartPoint.getX(), adjustedLStartPoint.getY(), 
					adjustedLEndPoint.getX(), adjustedLEndPoint.getY());
		}
		
		System.out.println("drawLines complete");
	}
	
	protected void drawTurtles(ArrayList<Turtle> turtles){
		this.drawingCanvas.getGraphicsContext2D().setLineWidth(50);
		this.drawingCanvas.getGraphicsContext2D().setStroke(Color.RED);
		
		
		for (Turtle t: turtles){
			
			TurtleImage turtleImage;
			if(turtleMap.get(t) == null){
				turtleImage = new TurtleImage();
				turtleMap.put(t, turtleImage);
				this.getChildren().add(turtleImage);

			}
			else{
				turtleImage = turtleMap.get(t);
			}
			turtleImage.sizeTurtle(drawingAreaWidth, drawingAreaHeight); 
			
			Point adjustedTurtleLocation = convertCoordinates(t.getLocation());
			adjustedTurtleLocation = positionPointRelativeToLines(adjustedTurtleLocation, turtleImage);
			turtleImage.setLocation(adjustedTurtleLocation);
			turtleImage.orientTurtle(t);
		
			double x = t.getLocation().getX();
			double y = t.getLocation().getY();
			double[] xlocs = {x - 10, x + 10, x};
			double[] ylocs = {y, y, y + 20};
			
			//Polygon p = new Polygon(xlocs[0], ylocs[0], xlocs[1], ylocs[1], xlocs[2], ylocs[2]);
			//this.drawingCanvas.getGraphicsContext2D().
			
			
		}
	}
	
	private Point positionPointRelativeToLines(Point turtleLocation, TurtleImage turtleImage) {
		
		Point adjustedturtleLocation = new Point();
		double xLocation = turtleLocation.getX();
		double yLocation = turtleLocation.getY();
		
		xLocation = xLocation - (.5 * drawingAreaWidth * turtleImage.turtleWidthPct);
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
	
	public void setInitTurtleImage(ArrayList<Turtle> turtles) {

		TurtleImage turtleImage = new TurtleImage();
		turtleImage.sizeTurtle(drawingAreaWidth, drawingAreaHeight);

		Point initTurtleLocation = new Point(0, 0);

		initTurtleLocation = convertCoordinates(initTurtleLocation);
		turtleImage.setLocation(initTurtleLocation);
		this.getChildren().add(turtleImage);

	}
	

}
