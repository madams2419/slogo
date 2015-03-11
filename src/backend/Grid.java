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
	private BiIndex<Color> colorMap;
	private BiIndex<String> imageMap;

	public Grid(Dimension size, BiIndex<Color> colorMap, BiIndex<String> imageMap) {
		this.size = size;
		this.bgColor = colorMap.getValue(Defaults.GRID_COLOR_INDEX);
		this.colorMap = colorMap;
		this.imageMap = imageMap;
		allTurtles = new HashMap<>();
		activeTurtles = new ArrayList<>();
	}

	public Grid(Dimension size, BiIndex<Color> colorMap, BiIndex<String> imageMap, Turtle turtle) {
		this(size, colorMap, imageMap);
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
	
	public List<Turtle> getShowingTurtles() {
		List<Turtle> showingTurtles = new ArrayList<>();
		for(Turtle turtle : getAllTurtles()) {
			if(turtle.isShowing() == 1.0) {
				showingTurtles.add(turtle);
			}
		}
		return showingTurtles;
	}

	public Turtle getTurtleById(int id) {
		if(allTurtles.containsKey(id)) {
			return allTurtles.get(id);
		} else {
			Turtle newTurtle = new Turtle(id, colorMap, imageMap);
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
	
	//TODO refactor with method extraction for this and the above method
	public List<Stamp> getStamps() {
		ArrayList<Stamp> allStamps = new ArrayList<>();
		Iterator<Turtle> it = allTurtles.values().iterator();

		while(it.hasNext()) {
			allStamps.addAll(it.next().getStamps());
		}
		return allStamps;
	}
	
	public List<DrawableImage> getDrawableImages() {
		List<DrawableImage> dbis = new ArrayList<>();
		dbis.addAll((List)getShowingTurtles());
		dbis.addAll((List)getStamps());
		return dbis;
	}
	
	public void setDimensions(int width, int height) {
		size = new Dimension(width, height);
	}

}
