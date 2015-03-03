package gui;

import java.util.ArrayList;

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
			
			this.drawingCanvas.getGraphicsContext2D().strokeLine(l.getStartPoint().getX(), l.getStartPoint().getY(), 
					l.getEndPoint().getX(), l.getEndPoint().getY());
		}
		
		System.out.println("drawLines complete");
	}
	
	protected void drawTurtles(ArrayList<Turtle> turtles){
		this.drawingCanvas.getGraphicsContext2D().setLineWidth(50);
		this.drawingCanvas.getGraphicsContext2D().setStroke(Color.RED);
		
		
		for (Turtle t: turtles){
			
			TurtleImage turtleImage = new TurtleImage();
			turtleImage.setLocation(t);
			turtleImage.orientTurtle(t);
		
			double x = t.getLocation().getX();
			double y = t.getLocation().getY();
			double[] xlocs = {x - 10, x + 10, x};
			double[] ylocs = {y, y, y + 20};
			
			//Polygon p = new Polygon(xlocs[0], ylocs[0], xlocs[1], ylocs[1], xlocs[2], ylocs[2]);
			//this.drawingCanvas.getGraphicsContext2D().
			this.getChildren().add(turtleImage);
			this.drawingCanvas.getGraphicsContext2D().fillPolygon(xlocs, ylocs, 3);
			
			
		}
	}
	
	


	private void drawShapes(GraphicsContext gc) {
		gc.setFill(Color.GREEN);
		gc.setStroke(Color.BLUE);
		gc.setLineWidth(5);
		gc.strokeLine(40, 10, 10, 40);
		gc.fillOval(10, 60, 30, 30);
		gc.strokeOval(60, 60, 30, 30);
		gc.fillRoundRect(110, 60, 30, 30, 10, 10);
		gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
		gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
		gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
		gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
		gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
		gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
		gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
		gc.fillPolygon(new double[] { 10, 40, 10, 40 }, new double[] { 210,
				210, 240, 240 }, 4);
		gc.strokePolygon(new double[] { 60, 90, 60, 90 }, new double[] { 210,
				210, 240, 240 }, 4);
		gc.strokePolyline(new double[] { 110, 140, 110, 140 }, new double[] {
				210, 210, 240, 240 }, 4);
	}

}
