package backend;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.awt.Color;

public class Grid {

	private Dimension size;
	private Color bgColor;
	private HashMap<Integer, Turtle> allTurtles;
	private ArrayList<Turtle> activeTurtles;

	public Grid(Dimension size, Color bgColor) {
		this.size = size;
		this.bgColor = bgColor;
		allTurtles = new HashMap<>();
		activeTurtles = new ArrayList<>();
	}

	public Grid(Dimension size, Color bgColor, Turtle turtle) {
		this(size, bgColor);
		addTurtle(turtle);
	}

	public void setBGColor(Color newBGColor) {
		bgColor = newBGColor;
	}

	public void setPenColor(Color newPenColor) {
		//TODO
	}

	public void addTurtle(Turtle newTurtle) {
		allTurtles.put(newTurtle.getID(), newTurtle);
		if(activeTurtles.isEmpty()) {
			activeTurtles.add(newTurtle);
		}
	}

	public Dimension getSize() {
		return size;
	}

	public Color getBGColor() {
		return bgColor;
	}

	public List<Turtle> getAllTurtles() {
		return new ArrayList<Turtle>(allTurtles.values());
	}

	public List<Turtle> getActiveTurtles() {
		return (ArrayList<Turtle>) activeTurtles.clone();
	}

	public Turtle getTurtleById(int id) {
		if(allTurtles.containsKey(id)) {
			return allTurtles.get(id);
		} else {
			Turtle newTurtle = new Turtle(id);
			allTurtles.put(id, newTurtle);
			return newTurtle;
		}
	}

	public double setActiveTurtles(List<Turtle> turtles) {
		activeTurtles.clear();
		activeTurtles.addAll(turtles);
		return new Double(turtles.get(turtles.size() - 1).getID());
	}

	public void setActiveTurtle(Turtle turtle) {
		activeTurtles.clear();
		activeTurtles.add(turtle);
	}

	public List<Line> getLines() {
		ArrayList<Line> allLines = new ArrayList<>();
		Iterator<Turtle> it = allTurtles.values().iterator();

		while(it.hasNext()) {
			allLines.addAll(it.next().getLines());
		}

		return allLines;
	}
	
	public void setDimensions(int width, int height) {
		size = new Dimension(width, height);
	}

}
