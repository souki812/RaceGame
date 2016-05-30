//Soukaina Alami/ Reena Hu
//The game class uses a timer in order to implement the road and obstacles classes. It also uses keyboard input
//in order to allow the player to move left or right. In summary, it manages the 3 classes and creates an animated 
//game.


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;



public class Game extends JPanel 
implements ActionListener, KeyListener {
	
	// constants
	public static final int WIDTH = 800;
	public static final int HEIGHT = 400;
	public static final int INTERVAL = 20;
	public static final int MOVEMENT = 450;

	// instance variable
	private int countCoins=0;
	private Timer timer;
	private Road road;
	private Player player;
	private obstacles obstacle;
	private ArrayList<Road> roadSegments;
	private int index=0;
	private int x =350;
	private int y= 400;
	private String str;
	private Image coin;
	private Image overMessage;
	private Image winMessage;




	//constructor
	public Game(){

		obstacle = new obstacles(index);
		player = new Player();

		Point location = new Point(x, y);

		roadSegments = new ArrayList<Road>();

		//add the roadsegments to the arrayList.
		for(index= 0; index<600; index+=100){

			roadSegments.add(new Road(index));
		}


		//starting the timer and letting the Game class handle the event.
		timer = new Timer(INTERVAL, this);
		timer.start();


		//creating the background of the game
		super.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		super.setBackground(Color.green);

		//adding a key listener to take keyboard input.
		this.addKeyListener(this);
		this.setFocusable(true);

		//display the images
		setImage();

	}
	//method using images of coin, a winMessage and a GameOver message.
	private void setImage() {
		try{

			winMessage = ImageIO.read(new File("obstacles/win.gif"));
			coin = ImageIO.read(new File("obstacles/Coin.gif"));
			overMessage = ImageIO.read(new File("obstacles/over.gif"));

		} catch (IOException ioe) {
			System.err.println("Image file not found");
		}

	}

	// display the panel
	public void paintComponent(Graphics page) {

		//if you reach the score of -3, you lose.
		if(countCoins>-4){

			// do what the parent class JPanel does first
			super.paintComponent(page);

			// draw the roadSegments
			for (Road road: roadSegments) {

				road.draw(page);
			}
			
			//draw the obstacle, the player and the coin.
			obstacle.draw(page);
			player.draw(page);

			page.setColor(Color.red);
			page.drawString(str, 750, 30);

			page.drawImage(coin, 
					700, 0, null);
		}else{
			//display the gameOver message if you have -3 coins.
			if(countCoins < -3)
				gameOver(page);
		}

		//if you win more than 30 coins, you win.
		if(countCoins > 30){
			win(page);

		}
	}



	// catch the timer
	public void actionPerformed(ActionEvent event) {
		if(countCoins > -4 && countCoins < 31){
			if (event.getSource() == timer) {

				//move the obstacles down the road
				obstacle.move();

				//keep track of the score whenever the player touches the coin or the obstacle.
				score();

				//move the segments of the road to give the impression it's animated.
				for (int i=0; i<roadSegments.size(); i++) {
					roadSegments.get(i).move();
				}

				// repaint the component
				super.repaint();
			}
		}	
	}

	//score method to keep track of the player's score.
	public void score(){
		int playerLocation = player.getLocationX();
		int obstacleX = obstacle.getLocationX();
		int obstacleY = obstacle.getLocationY();


		str ="" + countCoins;

		//if you hit a coin, the number of points goes up by one.
		if(obstacleY == 280 && obstacleX==300 && playerLocation == 250){
			countCoins++;
		}
		if(obstacleY== 450 && obstacleX==300 && playerLocation ==450){
			countCoins++;
		}

		//if you hit the green monster, you lose one point.
		if((obstacleX-50) == 250 && (obstacleY-240) == 250 && playerLocation ==250){
			countCoins--;
		}

		//if you hit the blue monster, you lose 3 points.
		if((obstacleX+180) == 480 && (obstacleY+180) == 250 && playerLocation ==450){
			countCoins-=3;
		}
	}


	//gameOver display
	public void gameOver(Graphics page){

		page.drawImage(overMessage, 100, -50, null);
	}


	//win message display
	public void win(Graphics page){
		page.drawImage(winMessage, 145, -20, null);
	}







	public static void main(String[] args) {
		JFrame frame = new JFrame("Game Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		Game game = new Game();
		frame.getContentPane().add(game);


		frame.pack();
		frame.setVisible(true);
	}


	//keyboard input: "a" = left;  "d" = right
	public void keyTyped(KeyEvent event) {
		switch (event.getKeyChar()) {

		case 'a':
			player.move(250);

			break;
		case 'd':
			player.move(450);
			break;
		default:
		}
	}
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}


