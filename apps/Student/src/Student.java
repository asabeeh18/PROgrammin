//TextField(String label, String text, int maxSize, int constraints) 
//Command(String label, int commandType, int priority) 
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class Student extends MIDlet implements CommandListener
{
	TextField name,mark,roll,phone;
	Form f;
	Display display;
	public void startApp()
	{
		f=new Form("Student");
		name=new TextField("Name","",50,TextField.ANY);
		roll=new TextField("Roll Number","",50,TextField.ANY);
		mark=new TextField("Marks","",3,TextField.NUMERIC);
		phone=new TextField("Phone No.","",50,TextField.NUMERIC);
		Command submit=new Command("Submit",Command.OK,1);
		
		f.append(name);
		f.append(roll);
		f.append(mark);
		f.append(phone);
		
		f.addCommand(submit);
		f.setCommandListener(this);
		display=Display.getDisplay(this);
		display.setCurrent(f);
	}
	public void commandAction(Command c,Displayable d)	
	{
		//String name,mark,roll,phone;
		f.deleteAll();
		
		f.append(new StringItem("Name",name.getString()));
		f.append(new StringItem("Roll",roll.getString()));
		f.append(new StringItem("Marks",mark.getString()));
		f.append(new StringItem("Phone No",phone.getString()));
		display.setCurrent(f);
	}
	public void destroyApp(boolean b)
	{}
	public void pauseApp()
	{}
}