/*
<applet code="circles" width=500 height=500>
</applet>
*/
import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
public class circles extends Applet
{
    public void paint(Graphics gr)
	{
		setForeground(Color.red);
		setBackground(Color.red);
		gr.setColor(Color.pink);
        gr.fillOval (10,10,500,500);
		gr.setColor(Color.green);
		gr.drawString("pink",250,30);
        gr.fillOval (60,60,400,400);
		gr.setColor(Color.yellow);
		gr.drawString("GREEN",250,80);
        gr.fillOval (110,110,300,300);
		gr.setColor(Color.blue);
		gr.drawString("YELLOW",250,130);
        gr.fillOval (160,160,200,200);
		gr.setColor(Color.white);
		gr.drawString("blue",250,180);
        gr.fillOval (210,210,100,100);
		gr.setColor(Color.black);
		gr.drawString("WHITE",250,230);
	}
}