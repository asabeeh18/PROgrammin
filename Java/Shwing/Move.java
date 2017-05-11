import java.io.*;
import java.awt.*;
import java.applet.*;
/*<Applet code="Move" height="500" width="500"></Applet>*/
public class Move extends Applet
{
	int cx,cy,px,py;
	String s="A=";
	public void init()
	{
		setBackground(Color.yellow);
	}	
	public void paint(Graphics g)
	{
		g.drawString(s,cx,cy);
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int ch=0;
		try{
		ch=Integer.parseInt(br.readLine());
		}
		catch(IOException e)
			{}
		px=cx;
		py=cy;
		if(ch==8)
		{
			if(cy==0){}
			else
				cy--;
		}
		else if(ch==4)
		{
			if(cx==0){}
			else
				cx++;
		}
		else if(ch==2)
		{
			cy++;
		}
		else if(ch==6)
		{
			cx++;
		}
		else{}
		g.setColor(Color.white);
		g.drawString(s,px,py);
		g.setColor(Color.black);
		g.drawString(s,cx,cy);
	}
}	