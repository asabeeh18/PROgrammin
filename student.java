//TextField(String label, String text, int maxSize, int constraints) 
//Command(String label, int commandType, int priority) 
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
public class Student extends MIDlet
{
	TextBox name,mark,roll,phone;
	Form f;
	public void startApp()
	{
		f=new Form("Student");
		name=new TextBox("Name","",50,TextBox.ANY);
		roll=new TextBox("Roll Number","",50,TextBox.ANY);
		mark=new TextBox("Marks","",3,TextBox.NUMERIC);
		phone=new TextBox("Phone No.","",50,TextBox.NUMERIC);
		Command submit=new Command("Submit",Command.OK,1)
		
		f.append(name);
		f.append(roll);
		f.append(mark);
		f.append(phone);
		
		f.addCommand(submit);
		f.setListener(this);
		
		display.setCurrent(f)
	}
	public void commandAction(Command c,Displayable d)
	{
		//String name,mark,roll,phone;
		f.deleteAll();
		TextField name1=new TextField("nam",name.getString(),50,TextField.ANY);
		
	}
}