//Soukaina Alami/ Reena Hu
//The obstacles class creates coins and monsters. Whenever the car hits the coins, the points go up.
//Whenever the car hits the monsters the points go down.


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JApplet;
import java.util.ArrayList;


public class obstacles extends JApplet {


	//constants
	public static final int HEIGHT = 600;
	public static final int x = 300;

	//instance variables
	private Point location;
	private Image coin;
	private Image Stop;
	private Image monster;
	private Image Homer;
	private Image banlam;
	private int i;
	private int yPosition;
	private int index;
	
	
	//Constructor
	public obstacles(int yPosition){
		location = new Point(x, yPosition);
		this.yPosition =yPosition;
		setObstacle();

	}

	//use of the images for the coins and obstacles.
	public void setObstacle(){
		try{
			coin = ImageIO.read(new File("obstacles/Coin.gif"));
			banlam = ImageIO.read(new File("obstacles/monster.png"));
			monster = ImageIO.read(new File("obstacles/9.png"));

		} catch (IOException ioe) {
			System.err.println("Image file not found");
		}
	}
	
	
	//draw method to put the obstacles in appropriate positions.
	public void draw(Graphics page) {
		page.drawImage(coin, 
				x, yPosition, null);
		page.drawImage(coin, 
				x+180, yPosition, null);

		page.drawImage(banlam, 
				x-50, yPosition-240, null);	

		page.drawImage(monster, 
				x+180, yPosition+180, null);
	}
	
	//getters
	public int getLocationX(){
		return x;
	}
	public int getLocationY(){
		return yPosition;
	}

	//move method to make the coins and obstacles go down the road.
	public void move(){

		yPosition+=10;
		if(yPosition == HEIGHT){
			yPosition=0;

		}else{
			if(yPosition == HEIGHT-100){
				yPosition = -100;
			}
		}
	}

	


}