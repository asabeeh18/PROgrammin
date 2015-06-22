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
float x=0.1f*displayWidth;
float y=0.6f*displayHeight;
float dim=0.3f*displayHeight;
//int dispalyWidth=displayWidth;
//int displayHeight=displayHeight;
public void draw()
{

  int targetX=mouseX;
}
public void setup()
{

 
  background(100);
  drawMan(0.1f*displayWidth, 0.6f*displayHeight);
  moveMan(30, 0);
}
public void drawMan(float a, float b)
{
  rect(a, b, 0.1f*displayHeight, 0.1f*displayHeight);
}
public void moveMan(float a, float b)
{
  float i=0;
  float inc;
  if (a>0)
    inc=0.01f;
  else
    inc=-0.01f;
  while (abs (i)<=abs(a))
  {
    delay(20);
    x += (i) * easing;
    drawMan(x, 0.6f*displayHeight);
    i+=inc;
    println(i);
  }
}


  public int sketchWidth() { return displayWidth; }
  public int sketchHeight() { return displayHeight; }
}
