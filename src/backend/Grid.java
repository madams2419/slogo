package backend;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class Grid {

	private Dimension size;
	private Color bgColor;
	private ArrayList<Turtle> turtles;
	private ArrayList<Turtle> activeTurtles;
	private Turtle targetTurtle;

	public Grid(Dimension size, Color bgColor) {
		this.size = size;
		this.bgColor = bgColor;
		turtles = new ArrayList<>();
		activeTurtles = new ArrayList<>();
		targetTurtle = null;
	}

	public Grid(Dimension size, Color bgColor, Turtle turtle) {
		this(size, bgColor);
		turtles.add(turtle);
	}

	public void setBGColor(Color newBGColor) {
		bgColor = newBGColor;
	}

	public void addTurtle(Turtle newTurtle) {
		turtles.add(newTurtle);
	}

	public Dimension getSize() {
		return size;
	}

	public Color getBGColor() {
		return bgColor;
	}

	public List<Turtle> getTurtles() {
		return turtles;
	}

	public Turtle getActiveTurtle() {
		return turtles.get(0);
	}

	public void setActiveTurtles(List<Double> turtleIds) {
		for(Turtle turtle : turtles) {
			turtle.setActivation(false);
		}

		for(int i = 0; i < turtleIds.size(); i++) {
			turtles.get(i).setActivation(true);
		}
	}

	public List<Line> getLines() {
		ArrayList<Line> allLines = new ArrayList<>();

		for(Turtle t : turtles) {
			allLines.addAll(t.getLines());
		}

		return allLines;
	}

}
