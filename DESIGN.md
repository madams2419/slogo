# SLogo Design Document

## Introduction
Our goal for SLogo is to develop a GUI program and implement an API that allows users to control and interact with "turtle" graphics through a series of simple commands. We plan to use a Model-View pattern as the general architecture for the project because it will allow us to more easily extend or modify parts of the visualization or implementation independently of each other. In our design, the model will have two main responsibilities: parsing and interpreting a body of text, and providing the GUI with the information necessary to keep the display updated. Under each of these, further specifications are delegated (such as keeping track of variables, or packaging movement information).  The GUI, on the other hand, needs to be able to provide the model with various types of user input data (ex. code entered or a field edited), and use the model's information to correctly maintain the display platform.

When inspecting our design, two portions of the workflow are especially critical and open-ended: the packaging of the data between ends of the API, and the correct tracking and application of various types of languages and user-defined commands. However, we are confident in our original plan to confront these barriers, and are excited to get underway.

## Overview
The program is partitioned into two packages, frontend and backend. The frontend package is responsible for displaying graphical resources, handling user input, and communicating user requests to the backend. The backend package maintains a model of the SLogo simulation and provides an API with methods for parsing and executing SLogo commands and retrieving model data. A UML model of the system is provided as MODEL.jpg in the project root directory.

### Frontend/Backend API
The backend provides an API with methods for parsing and executing SLogo commands and retrieving model data. The frontend visualizes the model’s state and command information, and handles user input. Please see the API reference at the end of this document for details.

### Frontend Structure
#### Display
The central class on the frontend is Display. Display sets up the JavaFX scene, conveys SLogo command strings to the backend for parsing, handles SLogo program run and step with calls to the backend executeNextCommand() method, and renders simulation visuals.

⧸⧸###⧸⧸#### Panes and other classes
Critical subclasses of the frontend will include the Main class (which will extend JavaFX’s Application), as well as various Pane subclasses which will correspond to regions of the GUI. Some of these will have regions for text editing, others for displaying data, and others still will display a list of buttons for the user to interact with. 

####Communication and Updating
Another key feature of the front end is the interface for communication with the backend. This will be done via packages which will be specifically designed to contain data useful for the GUI. Once the front end obtains updated Grid data, it will make the appropriate changes to the various JavaFX panels (including instantiating new scenery or outputting text).

###⧸⧸ Backend Structure
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
SLogo programs are parsed into objects of the Command type, which are represented with an inheritance hierarchy. At the higheset level of abstraction is the abstract Command class, which defines a name field and a toString() method. 

Command is extended by TurtleCommand, TurtleQuery, UserFunction, Error, and Operation. TurtleCommand represents a command that modifies the state (position, heading, pen deployment, or visibility) of the turtle. TurtleQuery represents a command that retrieves information about the Turtle's state. UserFunction encapsulates a list of commands defining a user function. Error represents an invalid command. Operation represents math or boolean operations.

## User Interface

We plan for the user interface to closely resemble the online Logo IDE, with a few adjustments to allow for additional features. The user interface will be split into multiple panels, similar to eclipse. These panels will correspond to a command box, a display area for the turtle and the drawings, a menu bar, as well as a side box that displays relevant information

#### Turtle Panel

The largest panel at the center of the screen will be dedicated to the display of the turtle, and the animation of its movements. It will show the visually display the orientation of the turtle as well as the movements that the turtle has undergone and their corresponding animations. 

#### Command Box
Below the turtle panel will be a command box. This will be where the user will write the commands he/she wishes to execute. In addition, this will be the area where This box will feature the ability to run all the written commands, or step through the commands one by one. Furthermore When an unrecognized command is told to execute, the command box will display an error message that alerts the user that the command was not recognized. 

####  Sidebar

To the right of this center panel, there will be a vertical bar that will contain the previous commands, user defined variables, user defined commands and a status bar. The user defined variables, and user defined commands sections will allow the user to edit the text, therefore editing the values of the variables as well as the effect of certain functions. The status bar will contain relevant information for the user, such as the turtle's position, its heading, whether the pen is down, and the color of the pen. 

#### Menu Bar
At the top of the screen there will be a menu bar. This menu bar will allow the user to select a variety of settings. From this bar the user will be able to set the color of the pen, the image of the turtle, the language of the program, as well as access a reference page that outlines the commands that can be used, and a description of their use cases. This bar will feature four tabs, File, Turtle, Help, Language. The file tab will allow the user to save or load a file, as well as open a new file. The Turtle tab will enable the user to set a new image for the turtle, as well as select the pen color. The help tab will direct the user to the HTML formatted help page that documents the available commands. Lastly, the language tab will enable the user to select between several languages for the program. 

[User Interface ](https://lh3.googleusercontent.com/atOXBR1zOy5LTkyyCyXPivzPuONn5fl3wwqh7K0RY3NCyq1Vh5kCF871HySpQ9DA0lh6peupnZw=w1420-h666 "User Interface")


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
The most fundamental (and philosophically important) design decisions we made was that of where / how to store JavaFX data. Specifically, we ahad to address the question of how shapes get from back to front, and in what form. After discussing this issue, we decided that the best practice in this instance would be to ensure that no objects specifically needed by the front end would be handled by the back end. We worked around the difficulties by designing a backend Grid class which will contain only data representations of state. This will be subsequently read by the frontend, and used to instanciate the visual data.
A second important design consideration that we have not yet addressed is the mechanics of parsing and interpreting the user input data as an API, and being able to add extendability for other languages or user-defined commands. Based on research and recitation content, we expect to be able to apply the principles of property binding and regexing in reading the user's code. Beyond these issues, there is actually a limited amount of algorithmic complexity involved in parsing the code; being able to adapt linguistically will be the most crucial piece to implement.

The only dependency or assumption of our current design - if successfully implemented - will be the GUI's need for valid Grid data from the backend in order to update the display. While this problem can be solved by ensuring proper defaults for Grid data, the assumption that we still make is that visual Grid information will only be editable from the backend, and not interactive. Were this the case, a separate form of communication would need to be established between our Model and View.

## Team Responsibilities

#### Frontend
The Front End will be handled by Sajal and Patrick. We plan to implement components as we go, and do not have specific features that each member will implement. Furthermore, in the design phase, it appears that the backend will require more work than the user interface, as nearly all of the functionality of the program is left to the backend. If the front end can be implemented early, Sajal and Patrick will assist with the backend where needed. 

#### Backend
The backend components will be handled by Mike and Robert.  We are meeting on Thursday to hash out design details and split up the workload.

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

