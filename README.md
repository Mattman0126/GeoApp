# GeoApp
Code for my GeoApp, a simple program that tracks points clicked by the user on a canvas, and can perform various actions on said points
, such as draw lines between them, change color, etc.

The program is built using an MVC style framework, where the model and the view are completely independent from each other.
The canvas class contains all the data and methods necessary for the canvas to plot points in the position of a mouse-click, 
as well as draw lines between said "child points".  Aside from the basic functionality of this program, the side-bar will (eventually)
allow for the selection of either All points or specific points by ID #, provide functionality to move said points in any direction,
and allow for the user to customize the color and weight of both points and lines generated by the program.  
This panel also contains a checkbox to disable the gridlines.
