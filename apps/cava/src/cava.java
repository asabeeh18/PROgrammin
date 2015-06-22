import java.io.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class cava extends MIDlet {
	
	public Display display;
	
	public void startApp() {
		
		Canvas obj = new DrawImage();
		
		display = Display.getDisplay(this);
		display.setCurrent(obj);
		
	}
	
	public void pauseApp() {
	}
	
	public void destroyApp(boolean unconditional) {
	}
	
	
	public class DrawImage extends Canvas{
		
		int width = getWidth();
		int height = getHeight();
		
		protected void paint(Graphics g) {
			try {
				
				System.out.println("111111");
				Image image = Image.createImage("/Waterfall.png");
				if(image != null)
                g.drawImage(image, 0, 0, Graphics.TOP | Graphics.LEFT);
				else
                System.out.println("2222");
				} catch (IOException ex) {
				System.out.println(ex);
			}   
		}  
	}   
}