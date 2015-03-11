package backend;

import java.awt.Color;
import java.awt.Point;

public class Constants {
	
	public static final String DEFAULT_LANGUAGE =  "English";
	
	public static final int GRID_WIDTH = 400;
	public static final int GRID_HEIGHT = 400;
	public static final Color GRID_COLOR = Color.WHITE;

	public static final String TURTLE_IMG_PATH = "../resources/sea_turtle.png";
	public static final Point TURTLE_START_POINT = new Point(0,0);
	public static final Heading TURTLE_START_HEADING = new Heading(90);
	public static final Color TURTLE_PEN_COLOR = Color.RED;
	public static final int TURTLE_PEN_WIDTH = 1;

	public static final String HELP_PAGE_PATH = "http://www.cs.duke.edu/courses/compsci308/spring15/assign/03_slogo/commands.php";

}
