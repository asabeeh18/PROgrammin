import javax.swing.*;
import java.awt.*;
public class Anim
{
   int x=0;
   int y=0;
       public static void main(String[] args)
       {
        Anim gui=new Anim();
       gui.play();
     }
public void play()
   {
           JFrame frame=new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            DrawPanel draw=new DrawPanel();
            frame.getContentPane().add(draw);
             frame.setSize(500,500);
              frame.setVisibility(true);
             for(int i=0;i<150;i++)
              {
                 x++;
                 y++;
                 draw.repaint();  //tells the panel to redraw itself so we can see the circle in new location
              try{
               Thread.sleep(25);
                  }catch(Exception e)
                  {}
         }
     }
}
class DrawPanel extends JPanel{
     public void paintComponent(Graphics g)
       { 
        g.setColor(Color.WHITE);
        g.fillRect(0,0,this.getWidth(),this.getHeight());
      g.setColor(Color.GREEN);
     g.fillOval(x,y,50,50);
}
}