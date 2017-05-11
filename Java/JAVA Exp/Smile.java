//Smiley
import java.applet.*;
import java.awt.*;
/*
	<applet code="Smile" height="500" width="500"></applet>
*/	
public class Smile extends Applet
{
	public void paint(Graphics g)
	{
		g.setColor(Color.yellow);
		g.fillOval(0,0,200,200);
		g.setColor(Color.BLACK);
			g.fillOval(20,50,50,50);
			g.fillOval(130,50,50,50);
			
		g.fillOval(20,50,50,50);
			g.fillOval(130,50,50,50);
		g.drawLine(100,100,100,150);
		g.drawString("GO HOME",300,300);
		g.drawArc(50,120,100,50,180,180);
		g.setColor(Color.white);
		//g.fillRect(80,170,30,30);
	}
}	