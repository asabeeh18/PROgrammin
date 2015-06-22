import java.applet.*;
import java.awt.*;

/*
  <applet code = "Expt13" height = 800 width = 800></applet>
*/

public class Expt13 extends Applet
{
     public void init()
     {
          setBackground(Color.WHITE);
          setForeground(Color.RED);
     }

     public void paint(Graphics g)
     {
          g.fillOval(100, 100, 500, 500);
          g.setColor(Color.GREEN);
          g.drawString("RED", 350, 130);

          g.fillOval(150, 150, 400, 400);
          g.setColor(Color.BLUE);
          g.drawString("GREEN", 350, 180);

          g.fillOval(200, 200, 300, 300);
          g.setColor(Color.PINK);
          g.drawString("BLUE", 350, 230);

          g.fillOval(250, 250, 200, 200);
          g.setColor(Color.CYAN);
          g.drawString("PINK", 350, 280);

          g.fillOval(300, 300, 100, 100);
          g.setColor(Color.BLACK);
          g.drawString("CYAN", 350, 330);
     }
}