//Soukaina Alami/Reena Hu 
//The player class will create a car that's only  able to move left and right using the keyboard in order to avoid the 
//obstacles or try to catch the coins



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JApplet;


public class Player extends JApplet {

	//instance variables
	private Point location;
	private int direction;
	private Image car = null;



	//constants
	public static final Color COLOR = Color.black;
	public static final int positionX = 250;
	public static final int positionY = 280;

	//constructor
	public Player(){

		location = new Point(positionX, positionY);
		setCurrentAnimation();

	}


	//use of images for the car.
	private void setCurrentAnimation(){
		try{
			car = ImageIO.read(new File("car"  + ".gif"));
		} catch (IOException ioe) {
			System.err.println("Image file not found");

		}

	}

	//draw method for the car as well as the score box
	public  void draw(Graphics page) {
		page.drawImage(car, 
				location.x, location.y, null);


		page.setColor(COLOR);
		page.fillRect( 700, 0, 100,  50);
	}

	//move method to move the car right or left.
	public void move(int distance){
		location.x = distance;
	}

	//getter
	public int getLocationX(){
		return location.x;
	}
}





