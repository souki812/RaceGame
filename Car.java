import javax.swing.*;
import java.awt.*;

public class Car extends JApplet
{
  public void paint(Graphics g)  
  {
// setting background and foreground colors
     g.setColor(Color.white);
     g.fillRect(0, 0, getWidth(), getHeight());
     g.setColor(Color.red);

// drawing the car body
     g.fillRect(110,110, 20, 20);

// drawing the wheels
     g.setColor(Color.black);
     g.fillOval(130, 110, 10, 10);     // left wheel
     g.fillOval(130, 120, 10, 10);     // right wheel
 

     g.setColor(Color.blue);
     g.fillRect(115,115, 10, 10);
     g.drawString("how do you like it?", 80, 90);
  }
}