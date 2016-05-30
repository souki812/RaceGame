//Soukaina Alami/ Reena Hu
//The road class creates segments of the road that we are going to be moving down.



import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JApplet;

import java.awt.*;
import java.io.File;
import java.io.IOException;


public class Road extends JPanel {
	//constants
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;


	//instance variables
	private Point location;
	private Image coin;
	private int segmentPosition = 0;
	private Image tree;
	private Image house;


	//constructor
	public Road(int segmentPosition){

		this.segmentPosition =segmentPosition;
		setImage();
	}




	//use images for the houses and trees
	private void setImage() {
		try{


			tree = ImageIO.read(new File("obstacles/5.png"));
			house = ImageIO.read(new File("obstacles/house.png"));
		} catch (IOException ioe) {
			System.err.println("Image file not found");
		}
	}




	//draw method for the segment of the road
	public void draw(Graphics page) {

		//road
		page.setColor(Color.gray);
		page.fillRect(200, segmentPosition, 400, 100);

		page.setColor(Color.white);
		page.fillRect( 395, segmentPosition, 10,  60);

		//trees
		for(int x=0; x< 150; x+=50){
			page.drawImage(tree, 
					x, segmentPosition, null);

			//houses
			for(int x1=620;  x1<800; x1+=150){
				page.drawImage(house, x1, segmentPosition, null);
			}
		}
	}

	//move method to create an animated road.
	public void move(){

		segmentPosition+=10;
		if(segmentPosition == HEIGHT){
			segmentPosition= 0;
		}else{
			if(segmentPosition == 500){
				segmentPosition = -100;
			}
		}
	}

}














