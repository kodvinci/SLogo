SLogo 
=====

SLogo Project in Comp Sci 308 Spring 2013

Team 5

	Team Members
1. Jerry Li
2. Leonard Ng'eno
3. Alan Ni
4. Yang Yang
5. Rex Ying - Mentor

Started on: Feb 20th 2013

Finished: March 25 2013

https://github.com/th365thli/SLogo.git

Estimated: 50 hours each

Roles for each person

Everyone- commenting, design, pair programming, debugging and refactoring

Richard Yang and Jerry- Model
	Both - All files in SLogo package (Interpreter, Controller, Parser, Model, Factory)

Richard -
	Initial Commands and design. Reading in commands and translating input. Creating commands. Also part 3 expected commands.
Jerry -
	Extended original design to allow nested and implemented reflection that makes commands extensible. Also part 3 required commands.

Alan and Leonard- View
	Both-
		Creation of Command Area, Display Area, Canvas, ToolBarArea, TurtleArea and Window
		
		
	Leonard- Creation of Message Window, Saving and Loading functionalities, Changing turtle and background functionalities, clickable commands and procedures and variables

	Alan- Pen functionalities, painting trails, grid painting and toggling, creation of color palette, undo and redo functionality, creation of stamps and their functionality, Help functionality

Files used to start project (files containing main): Main.java in default package, utils classes Animal.java, Location.java, Pixmap.java, and Location. java

Resource packages: images, images.background, resources

Information about using program:

Current bugs: Undo/Redo does not currently work with turning, rotating the image of the turtle did not delete the old image prior to rotation, setShape does not change shape, merely changes size of shape. 
			  Nested commands sometimes do not throw exceptions properly. Some exceptions execute but don't show a message in the pop up window. This is probably because exceptions call showmessage from
			  controller instead of model.

Extra features- pop-up error box for exceptions, added support for both background image and background colors

Impressions and improvements for the future- Great project to learn to work together and the separation between view and model.  Possible improvement would be to learn more about MVC principles before the project. 
											 Also API is very important, probably could have written one in greater detail before. 



