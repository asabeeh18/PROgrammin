/*Poll 
need Any more help
goto this link 
http://docs.oracle.com/javame/config/cldc/ref-impl/midp2.0/jsr118/javax/microedition/lcdui/package-summary.html

..For some reason when the item is selected the tick mark doesnt show up :/
*/
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
//import javax.lang.*;	//Cause Dube said but in my laptop adding it gives error 
//always make class public ..and name everything the same(for a safe side)
public class Choice extends MIDlet implements CommandListener	//implement CommandListener ONLY if u have a COmmandButton
{
	
	Form f;
	Display display;
	ChoiceGroup cg;	//its a Check box thingy
	//This function is called when app is started..NO main
	public void startApp()
	{
		//New Form with name Poll
		f=new Form("Poll");
		//String array for Choice
		String s[]={"Pizza","Burger","Donut"};	//Add items here to change the poll
		
		//Create choice grup..params::ChoiceGroup(String label, int choiceType, String[] stringElements, Image[] imageElements) 
		//its a Check box thingy
		cg=new ChoiceGroup("poll",ChoiceGroup.MULTIPLE,s,null);
		//Create a Command button ..Command(String label, int commandType(can be OK,BACK,SCREEN..), int priority) 
		Command submit=new Command("Submit",Command.OK,1);
		
		//Add ChoiceGrup to form (OR anyother object too)
		f.append(cg);
		//Add Command button to form
		f.addCommand(submit);
		
		//set the listener so that "commandAction" is auto called when we click the button
		f.setCommandListener(this);
		//Get the screen display object
		display=Display.getDisplay(this);
		
		//add the form to current display
		display.setCurrent(f);
	}
	
	//Automatically Called when the submit button is clicked  ..ignore the parameters we dont use them
	public void commandAction(Command c,Displayable d)	
	{
		String s="";	//s will store the list of selected items
		//CLear the form
		f.deleteAll();
		for(int i=0;i<cg.size();i++)	//cg size gives size of the choice group
			if(cg.isSelected(i))	//if the item at poz i is selected
				s+=cg.getString(i)+"\n";	//copy that item in stirng s append '\n' in the end for display
		
		//Add the string s in the form
		f.append(new StringItem("Result\n",s));
		//add the form to current display
		display.setCurrent(f);
	}
	
	//abstract class....MUST define these functions
	public void destroyApp(boolean b)
	{}
	public void pauseApp()
	{}
}