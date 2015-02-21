package backend;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

public class Grid {

	private Dimension size;
	private Color bgColor;
	private ArrayList<Turtle> turtles;

	public Grid(Dimension size, Color bgColor) {
		this.size = size;
		this.bgColor = bgColor;
		turtles = new ArrayList<>();
	}

	public Grid(Dimension size, Color bgColor, Turtle turtle) {
		this(size, bgColor);
		turtles.add(turtle);
	}

	protected void setBGColor(Color newBGColor) {
		bgColor = newBGColor;
	}

	protected void addTurtle(Turtle newTurtle) {
		turtles.add(newTurtle);
	}

	public Dimension getSize() {
		return size;
	}

	public Color getBGColor() {
		return bgColor;
	}

	public ArrayList<Turtle> getTurtles() {
		return turtles;
	}

	public ArrayList<Line> getLines() {
		ArrayList<Line> allLines = new ArrayList<>();

		for(Turtle t : turtles) {
			allLines.addAll(t.getLines());
		}

		return allLines;
	}

}
