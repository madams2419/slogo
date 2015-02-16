# SLogo Design Document

## Introduction

## Overview
The program is partitioned into two packages, frontend and backend. The frontend package is responsible for displaying graphical resources, handling user input, and communicating user requests to the backend. The backend package maintains a model of the SLogo simulation and provides an API with methods for parsing and executing SLogo commands and retrieving model data. A UML model of the system is provided as MODEL.jpg in the project root directory.

### Frontend/Backend API
The backend provides an API with methods for parsing and executing SLogo commands and retrieving model data. Please see the API reference at the end of this document for details.

### Frontend Structure
#### Display
The central class on the frontend is Display. Display sets up the JavaFX scene, conveys SLogo command strings to the backend for parsing, handles SLogo program run and step with calls to the backend executeNextCommand() method, and renders simulation visuals.

### Backend Structure
#### Model
The central class on the backend is Model. Model stores all relevant model data including the grid object, Queues of pending and executed commands, a HashMap of user-defined variables, a HashMap of user-defined functions, and a string path to the HTML help page. Model provides the parseProgram method to parse an SLogo program string into Command objects. Model provides the executeNextCommand method to execute the next command in the pendingCommands Queue and to update the grid accordingly. Model also provides a series of get and set methods for the frontend to retrieve display data and set user-controlled variables.

#### Grid
Model contains a grid object, which is an instance of the Grid class. Grid represents the state of the simulated SLogo Turtle environment. Grid has a size, background color, resident turtle object, and list of lines that have already been drawn. Grid provides methods for setting its background color and retrieving the turtle and line list.

#### Turtle
The turtle class represents the simulated SLogo turtle. Turtle has an image representation, a location, a heading, and a pen color. Turtle provides public methods to set its image and pen color. It also provides public methods to get its location and heading. Turtle provides protected methods to effect movement and rotation.

#### Line
The line class represents a line segment created by the turtle executing a single SLogo movement command. Line has a color, start and end points, and a visibility boolean (a line is not visible if it is created by a pen-up turtle movement). Line provides public methods to get its color, start and end points, and visibility. Line provides a protected method to check if it intersects with another line.

#### Variable
The variable class represents a user-defined SLogo program variable. Variable has a name and a value. Variable provides public methods to access both of these fields. 

#### Command Hierarchy
SLogo programs are parsed into Command objects, which are represented with an inheritance hierarchy. At the higheset level of abstraction is the abstract Command class, which defines a name field and a toString() method. 

Command is extended by TurtleCommand, TurtleQuery, UserFunction, Error, and Operation. TurtleCommand represents a command that modifies the state (position, heading, pen deployment, or visibility) of the turtle. TurtleQuery represents a command that retrieves information about the Turtle's state. UserFunction encapsulates a list of commands defining a user function. Error represents an invalid command. Operation represents math or boolean operations.

## User Interface

## Design Details

## API Example Code
> The user types 'fd 50' in the command window, presses 'run,' and sees the turtle move in the display window leaving a trail.

<pre><code>display.handleRun() // handle the 'run' button being pressed
model.parseProgram(String prog) // String prog = 'fd 50'; parse the program string into command objects and populate internal pendingCommands queue in model
model.executeNextCommand() // execute next command in pendingCommands and updates backend model (grid and turtle) accordingly
grid = Model.getGrid() // get reference to the grid
turtle = grid.getTurtle() // get reference to turtle
lines = grid.getLines() // get reference to List of lines the turtle has drawn
display.update() // update JavaFX scene with new turtle and line data
	turtle.getImage()
	turtle.getLocation()
	turtle.getHeading()
	line.getStartPoint()
	line.getEndPoint()
	line.getColor()
</pre></code>


## Design Considerations

## Team Responsibilities

## API Reference
### Model Public Methods
##### parseProgram(String prog) : void
Parses a string representation of an SLogo program into a Queue of command objects.
##### executeNextCommand() : void
Executes the next command on the command queue and updates backend state accordingly. 
##### setVariable(String name, Double value) : void
Updates the value of the variable hashed by name with the new value provided.
##### setLanguage(String lang) : void
Sets the language of the backend parser.
##### getGrid() : Grid
Returns a reference to the backend grid object.
##### getExecutedCommands() : Queue
Returns Queue of executed commands.
##### getUserVariables() : HashMap
Returns HashMap of user defined variables.
##### getUserFunctions() : HashMap
Returns hashMap of user defined commands.

### Grid Public Methods
##### getTurtle() : Turtle
Returns reference to Turtle object.
##### getLines() : List
Returns reference to List of lines that have been drawn on the grid.

### Turtle Public Methods
##### setImage(Image img) : void
Sets the turtle's display image.
##### setPenColor(Color color) : void
Sets the color of the turtle's pen. 
##### getLocation() : Point
Returns turtle's location.
##### getHeading() : Heading
Returns turtle's heading.

#### Line Public Methods
##### getColor() : Color
Returns line Color.
##### getStartPoint() : Point
Returns line start point.
##### getEndPoint() : Point
Returns line end point.



> Written with [StackEdit](https://stackedit.io/).
