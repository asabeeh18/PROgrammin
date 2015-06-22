package processing.test.lameapainter;

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

public class lameAPainter extends PApplet {

int x,y;
public void draw()
{
  dLine();
  //dRect();
} 
public void dLine()
{
  float weight = dist(mouseX, mouseY, pmouseX, pmouseY);
  strokeWeight(weight/2);//slow thin
 // float my = map(mouseY,0,displayHeight,0.2*displayHeight,displayHeight);
  line(mouseX, mouseY, pmouseX, pmouseY);
}
public void dRect()
{
  x=mouseX;
  y=mouseY; 
}
public void mouseDragged()
{
  if(f=3)
    rect(x,y,mouseX,mouseY);
}
public void setup()
{
 /* 0.2*displayHeight
  displayWidth
  line
  circle
  rectangle
  vertex
  background
  CLear*/
 
  for(int i=0;i<6;i++)
  {
     rect(i*displayWidth/6,0,displayWidth/6,0.1f*displayHeight);
     rect(i*displayWidth/6,0.1f*displayHeight,displayWidth/6,0.1f*displayHeight);
  }
  line(3,3,displayWidth/6-5,displayHeight*0.1f-5);
  ellipse(displayWidth/4,0.5f*0.1f*displayHeight,0.5f*0.1f*displayHeight,0.5f*0.1f*displayHeight);
  rect(2*displayWidth/6+10,10,displayWidth/6-30,0.1f*displayHeight-30);
  point(displayWidth/2,0.5f*0.1f*displayHeight);
  fill(130,12,232);
  rect(5*displayWidth/6,0,displayWidth/6,0.1f*displayHeight);
}

  public int sketchWidth() { return displayWidth; }
  public int sketchHeight() { return displayHeight; }
}
