import java.io.*;
import javax.microedition.midlet.*;
import javax.microedition.lcdui.*;
public class cava2 extends MIDlet {
	
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
				
				Image image = Image.createImage("/Waterfall.png");
				if(image != null)
					g.drawImage(image, 0, 0, Graphics.TOP | Graphics.LEFT);
				else
					System.out.println("Image Not Found");
				} catch (IOException ex) {
				System.out.println(ex);
			}   
		}  
	}   
}