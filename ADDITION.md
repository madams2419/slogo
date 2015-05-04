**Estimation**

I believe that this addition will take me no more than an hour and a half. I suspect that I will need to add methods to only one class (the parent GUI class), providing that the Model API currently supports setting new image path correctyly.

**Review**

This took me just under an hour to complete, and ended up being slightly more complicated than anticipated--loading a new ImageView to be used as a Button label was not as simple as I expected. Furthermore, I suspect that the Backend's implementation of setImageByFullPath is broken; somehow, even using identical file paths, the selected file path doesn't correctly load an image. The new GUI code is 100% functional one the backend bug can be fixed. I only needed to update the TopPanel file, but I did experiment with TurtleImage and Turtle to try and fix the bug. This wasn't successful--I'd request a bug fix by the Model team.

**Analysis**

This part of our project was pretty much just as I remembered--functional and intentional, but somewhat messy to read. I find that most GUI code ends up being this way. I would improve the separation of these into separate methods in the future. However, had I not even read the TopPanel class before, I am convinced that I could still have implemented this feature.

**TO USE**

Display > Show Turtle Images > Click for file browser
*backend has a bug with file loading, but fronted supports what it needs to