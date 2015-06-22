//draw circle
import java.applet.*;
import java.awt.*;
/*
	<applet code="Circle" height=800 width=800>Applet Not Supported</applet>
*/
public class Circle extends Applet
{
	public void init()
	{
		setBackground(Color.GREEN);
		setForeground(Color.YELLOW);
	}
	public void paint(Graphics g)
	{
		/*for(int i=0;i<30;i++)
		{
			init();
			for(int j=0;j<1000;j++)
				g.fillOval(i,i,100,100);
			setForeground(getBackground());
				g.fillOval(i,i,100,100);
				
		}	*/
		for(int j=0;j<20000;j++)
			g.fillOval(0,0,100,100);
		setForeground(Color.GREEN);
		g.fillOval(0,0,100,100);
		init();
		for(int j=0;j<20000;j++)
			g.fillOval(100,100,100,100);	
			
	}
}	