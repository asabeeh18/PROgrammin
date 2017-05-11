//Applet Cycle
import java.awt.*;
import java.applet.*;
/*
	<applet code="AppletCycle" height=800 width=800></applet>
*/
public class AppletCycle extends Applet
{
	private int k=1;
	void init()
	{
		k=k*100;
		setForeground(Color.YELLOW);
		setBackground(Color.RED);
		Graphics.drawString("INIT",k,20);
	}
	public void paint(Graphics g)
	{
		k=k*100;
		g.drawString("PAINT",k,10);
		//init(g);
		setForeground(Color.GREEN);		
	}
}