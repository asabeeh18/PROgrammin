import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.Toolkit;
public class Simple extends JFrame
{
	public Simple() 
	{
		setSize(300, 200);
		int a=3+2;
		setTitle(a+"");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//Following 3 lines sets the window to centre of screen
		Toolkit toolkit = getToolkit();
		Dimension size = toolkit.getScreenSize();	//dimension class stores dimensions OBject
		setLocation(size.width/2 - getWidth()/2,size.height/2 - getHeight()/2);
	}
	public static void main(String[] args)
	{
		Simple simple = new Simple();
		simple.setVisible(true);
	} 
}