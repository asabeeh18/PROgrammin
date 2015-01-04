package processing.test.manwalk;

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
float y=0.9f*displayHeight;
//int dispalyWidth=displayWidth;
//int displayHeight=displayHeight;
public void draw()
{
  background(100);
  int targetY=mouseY;
  y += (targetY - y) * easing;
  drawMan(0,y);
}
public void setup()
{
 
  line(0.8f*displayWidth,0,0.8f*displayWidth,displayHeight);
  line(20,20,20,40);
  drawMan(0,0.9f*displayHeight);
}
public void drawMan(float a,float b)
{
  line(0.7f*displayWidth,b,0.8f*displayWidth,b);  //legs
  line(0.5f*displayWidth,b,0.7f*displayWidth,b);  //stem
  line(0.5f*displayWidth,b,0.6f*displayWidth,b);  //hands
  ellipse(0.45f*displayWidth,b,0.1f*displayWidth,0.1f*displayWidth);  //head
}

  public int sketchWidth() { return displayWidth; }
  public int sketchHeight() { return displayHeight; }
}
