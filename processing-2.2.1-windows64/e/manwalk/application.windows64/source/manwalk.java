import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class manwalk extends PApplet {

float easing=0.02f;
float x=0;
float y=0.6f*displayHeight;
float i=1;
float inc=0.5f;
float f=0;
float d=0.1f*displayHeight;
float t=0;
public void draw()
{

  background(i*3*255/displayWidth, i, 100);
  //moveMan(30, 0);

  if (f==0 || f==1)
    drawMan((x+i)%displayWidth, 0.6f*displayHeight);
  if (f==2 || f==3)
  {
    drawMan(x, 0.6f*displayHeight-i);
    line(x+10, 0.6f*displayHeight+0.1f*displayHeight, x+10, 0.6f*displayHeight+0.1f*displayHeight-i);
    line(x+0.1f*displayHeight-10, 0.6f*displayHeight+0.1f*displayHeight, x+0.1f*displayHeight-10, 0.6f*displayHeight+0.1f*displayHeight-i);
    if (i>=0.05f*displayHeight && f==2)
    {
      f=3;
      println("====================================================");
      inc=-0.5f;
      if(t>=5)
      {
        f=4;
        inc=0.5f;
      }
    }
    if (f==3)
    {  
      if (i<=1)
      {  
        t++;
        inc=0.5f;
        f=2;
      }
    }
   
  }
  if(f==4)
  {
     drawMan(x+i, 0.5f*displayHeight-10);
     if(i>=0.2f*displayHeight+20)
     {
       f=5;
       inc=0.5f;
       x=(x+i)%displayWidth;
       i=1;
     }
  }  
  
  if(f==5)
  {
   drawMan(x, 0.5f*displayHeight+i);
    line(x+10, 0.6f*displayHeight+0.1f*displayHeight, x+10, 0.6f*displayHeight+i);
    line(x+0.1f*displayHeight-10, 0.6f*displayHeight+0.1f*displayHeight, x+0.1f*displayHeight-10, 0.6f*displayHeight+i);
      if (i>=0.1f*displayHeight)
      {  
        t++;
        inc=0;
        f=7;
      }
  }
  if(f==7)
  {
    
    drawMan(x, 0.6f*displayHeight);
    f=0;
    i=1;
    inc=0.5f;
  }
  i+=inc;
  println(i+" "+f);
  drawMan(displayWidth/3.0f, 0.6f*displayHeight);
  if ((i)%displayWidth+ 0.1f*displayHeight>=displayWidth/3.0f && f==0)
  {
    inc=-inc;
    f=1;
  }
  if (f==1 && (i)%displayWidth==0)
  {
    inc=-inc+2;
    f=0;
  }
  if (millis()>=50000 && millis()<=53000)
  {
    textSize(160);
    textAlign(CENTER);
    text("DAMN!!!\nITS ANNOYING!!", displayWidth/2, displayHeight/5);
  }
  if (millis()>53000 && millis()<65000)
  {
    textSize(160);
    textAlign(CENTER);
    text("STOP", displayWidth/2, displayHeight/5);
    i=1;
    f=2;
    inc=0.5f;
    x=displayWidth/3-0.1f*displayHeight-10;
    drawMan(x, 0.6f*displayHeight);
  }
}
public void setup()
{
  size(displayWidth, displayHeight);
  smooth();
 
  drawMan(0, 0.6f*displayHeight);
}
public void drawMan(float a, float b)
{
  noStroke();
  fill(100, i*3*255/displayWidth, i);
  rect(a, b, 0.1f*displayHeight, 0.1f*displayHeight);
  stroke(0);
}

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--full-screen", "--bgcolor=#666666", "--stop-color=#cccccc", "manwalk" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
