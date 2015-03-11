package backend;

import java.awt.Color;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Pen {

	private Color color;
	private int width;
	private boolean isDown;
	private ArrayList<Line> lines;

	public Pen(Color color, int width, boolean isDown) {
		this.color = color;
		this.width = width;
		this.isDown = isDown;
		lines = new ArrayList<>();
	}

	public Color getColor() {
		return color;
	}

	public int getWidth() {
		return width;
	}

	public List<Line> getLines() {
		return lines;
	}

	public boolean clearLines() {
		boolean linesCleared = false;
		if(lines.size() > 0) {
			linesCleared = true;
			lines.clear();
		}
		return linesCleared;
	}

	public boolean isDown() {
		return isDown;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setDown(boolean isDown) {
		this.isDown = isDown;
	}

	public Line drawLine(Point start, Point end) {
		if(!isDown()) return null;
		Line newLine = new Line(start, end, color, width);
		lines.add(newLine);
		return null;
	}

}
