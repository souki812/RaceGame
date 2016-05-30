# RaceGame

a 2-D car race game in which the user can use the keyboard in order to move the car right or left. The player will face obstacles along the way that will reduce the number of points he gets. We also provide coins as well as strengths for him to take in order to gain more points. If the player gains a certain amount of coins (to be determined), he will win.

•	Actions the player can take:
The player will be only be able to move left and right using the keyboard in order to avoid the obstacles or try to catch the coins. 


•	The actions that the program will automatically take are:

-	An animated road that goes down, which gives the impression of moving to the player.
-	The car will automatically move along the road without user input. The only options the player has are the “left” or “right” directions.
-	Give a constant speed to the car.
-	Prevent the car from going out of the road frame.
-	An increase in the points of the player whenever he gains the coins.
-	A decrease in the points of the player whenever he hits an obstacle.
-	A Game over message if the points are below or equal to zero. 
-	A “you won” message if the points are above the max number of coins.

3-	class outline:
We will mainly have two classes:

-	a player class which:
•	Calculate the player’s points and determine if he’s lost or won. 
•	Define the move method to make the car move right or left.
•	Give a constant speed to the car.
•	Prevent the car from going out of the road frame.
•	Give a color to the car

-	A game class which:
•	 Will draw the animated road by using a timer. 
•	Set the color for the general environment.
•	Will define the player’s movements using keyboard input.
•	Will make the car move forward along the road without user input.
•	Will randomly put obstacles for the player.
•	Will randomly put coins in different places for the player.

