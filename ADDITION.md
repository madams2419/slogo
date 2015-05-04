Slogo Addition
===================

Estimation
-------------

I think it would take under an hour to implement this feature. I think that in order to create an a view that shows all the turtles that are available a menu item must be added. This menu item will contain the action item that iterates through all the available turtles within the model and runs the ST (show turtle) command on each of the turtles, thus showing all the turtles. The opposite, exit all view mode, would do the opposite except for leaving the first turtle visible. I think this feature will require a modification in the class that corresponds to the menu and the menu items respective action items. In addition I will need to alter the class that deals with the image associated with the turtle. 


Review
-------------------
It took me about an hour and 45 minutes to implement this feature. A decent amount of this time was relating to understanding the code that I had previously written to determine how to alter it in a way that would allow for this feature. I believe I have it correct, however, the backend support for the image change does not appear to be working, (the same file choosers/image selections return null pointer exceptions when they did not before, even in cases when no code was altered.) I ended up needing to alter 4 files, the two that I anticipated as well as two more that allowed for access to the necessary components for this feature. 



Analysis
-------------
This project demonstrated how sound the backend design of our slogo project was. By making simple calls to the backend api (which are not working now, but they did before/during the final sprint and demonstration). I was able to make changes to the appreance of all the turles and allow for actions to occur when they are clicked. I think it would have been easy to understand how to make the changes on the back end for the the necessary componenets. The back end api is very intuitive and simple. However, understanding the dependencies on the front end would be far more difficult as many of the classes were completed in an ad hoc manner in order to gain functionality. 