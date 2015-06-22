package processing.test.move;

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

public class move extends PApplet {

/*
World's simplest Android App!
blprnt@blprnt.com
Sept 25, 2010
*/

// Build a container to hold the current rotation of the box
float boxRotation = 0;

public void setup() {
  // Set the size of the screen (this is not really necessary 
  // in Android mode, but we'll do it anyway)
 
  // Turn on smoothing to make everything pretty.
  smooth();
  // Set the fill and stroke color for the box and circle
  fill(255);
  stroke(255);
  // Tell the rectangles to draw from the center point (the default is the TL corner)
  rectMode(CENTER);
}

public void draw() {
  // Set the background color, which gets more red as we move our finger down the screen.
  background(mouseY * (255.0f/800), 100, 0);
  // Change our box rotation depending on how our finger has moved right-to-left
  boxRotation += (float) (pmouseX - mouseX)/100;

  // Draw the ball-and-stick
  line(width/2, height/2, mouseX, mouseY);
  ellipse(mouseX, mouseY, 40, 40);

  // Draw the box
  pushMatrix();
  translate(width/2, height/2);
  rotate(boxRotation);
  rect(0,0, 150, 150);
  popMatrix();
}


  public int sketchWidth() { return 480; }
  public int sketchHeight() { return 800; }
}
