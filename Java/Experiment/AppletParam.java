import java.awt.*;
import java.applet.*;
public class AppletParam extends Applet
{
	String branch,name,dob;
	int rollNo;
	public void init()
	{
		rollNo=Integer.parseInt(this.getParameter("rollNo"));
		branch=this.getParameter("branch");
		name=this.getParameter("name");
		dob=this.getParameter("DOB");
	}
	public void paint(Graphics g)
	{
		g.drawString("Name",20,20);
		g.drawString("Roll No.",120,20);
		g.drawString("Branch",220,20);
		g.drawString("DOB",320,20);
		g.drawString(name,20,60);
		g.drawString(""+rollNo,120,60);
		g.drawString(branch,220,60);
		g.drawString(dob,320,60);
		//g.drawString(name,20,60);
		//g.drawString(""+rollNo,120,60);
		/*g.drawString("Name"+name,20,20);
		g.drawString("Branch: "+branch,180,20);
		g.drawString("Roll No: "+rollNo,260,20);
		g.drawString("Date Of Birth: "+dob,380,20);*/
	}
}	