//TextField(String label, String text, int maxSize, int constraints) 
//Command(String label, int commandType, int priority) 
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class Avg extends MIDlet implements CommandListener
{
	TextField mark1,mark2,mark3;
	Form f;
	Display display;
	public void startApp()
	{
		f=new Form("Student");
		mark1=new TextField("Marks","",3,TextField.NUMERIC);
		mark2=new TextField("Marks","",3,TextField.NUMERIC);
		mark3=new TextField("Marks","",3,TextField.NUMERIC);
		Command submit=new Command("Submit",Command.OK,1);
		
		f.append(mark1);
		f.append(mark2);
		f.append(mark3);
		
		f.addCommand(submit);
		f.setCommandListener(this);
		display=Display.getDisplay(this);
		display.setCurrent(f);
	}
	public void commandAction(Command co,Displayable d)	
	{
		//String name,mark,roll,phone;
		f.deleteAll();
		int a=Integer.parseInt(mark1.getString());
		int b=Integer.parseInt(mark2.getString());
		int c=Integer.parseInt(mark3.getString());
		
		f.append(new StringItem("Average Marks",((a+b+c)/3.0)+""));
		display.setCurrent(f);
	}
	public void destroyApp(boolean b)
	{}
	public void pauseApp()
	{}
}