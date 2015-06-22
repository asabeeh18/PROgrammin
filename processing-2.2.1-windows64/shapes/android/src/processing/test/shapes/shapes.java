package processing.test.shapes;

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

public class shapes extends PApplet {


public void setup()
{
  background((random(0,255)+255)/2);
  strokeWeight(0);
 
  //ellipse(random(0,displayWidth),random(0,displayHeight),random(0,displayWidth),random(0,displayHeight));
}  
public void mouseDragged()
{
  flatColor();
  switch((int)random(0,5))
  {
    case 0:
            
            ellipse(random(0,displayWidth),random(0,displayHeight),random(0,displayWidth),random(0,displayHeight));
            break;
    case 1:
            
            rect(random(0,displayWidth),random(0,displayHeight),random(0,displayWidth),random(0,displayHeight));
            break;
    case 2:
            
            line(random(0,displayWidth),random(0,displayHeight),random(0,displayWidth),random(0,displayHeight));
            break;
    case 3:
            
            quad(random(0,displayWidth),random(0,displayHeight),random(0,displayWidth),random(0,displayHeight),random(0,displayWidth),random(0,displayHeight),random(0,displayWidth),random(0,displayHeight));
            break;
    case 4:
            
            arc(random(0,displayWidth),random(0,displayHeight),random(0,displayWidth),random(0,displayHeight),random(0,2*PI),random(0,2*PI));
            break;
    case 5:
            
            triangle(random(0,displayWidth),random(0,displayHeight),random(0,displayWidth),random(0,displayHeight),random(0,displayWidth),random(0,displayHeight));
  }        
} 
public void draw()
{
   
}

public void flatColor()
{
  switch((int)random(0,20))
  {
     case 1:
           //Turquoise
//#1abc9c
          fill(26, 188, 156);
          break;
      case 2:
    //Greensea
//#16a085
          fill(22, 160, 133);break;

        case 3:
//2ecc71
fill(46, 204, 113);break;
case 4:
//Nephritis
//27ae60
fill(39, 174, 96);break;
case 5:
//Peterrier
//3498db
fill(52, 152, 219);break;
case 6:
//Belizehole
//2980b9
fill(41, 128, 185);break;
case 7:
//Amethyst
//9b59b6
fill(155, 89, 182);break;
case 8:
//Wisteria
//8e44ad
fill(142, 68, 173);break;
case 9:
//Wetasphalt
//34495e
fill(52, 73, 94);break;
case 10:
//Midnightblue
//2c3e50
fill(44, 62, 80);break;
case 11:
//Sunflower
//f1c40f
fill(241, 196, 15);break;
case 12:
//Orange
//f39c12
fill(243, 156, 18);break;
case 13:
//Carrot
//e67e22
fill(230, 126, 34);break;
case 14:
//Pumpkin
//d35400
fill(211, 84, 0);break;
case 15:
//Alizarin
//e74c3c
fill(231, 76, 60);break;
case 16:
//Pomegranate
//c0392b
fill(192, 57, 43);break;
case 17:
//Clouds
//ecf0f1
fill(236, 240, 241);break;
case 18:
//Silver
//bdc3c7
fill(189, 195, 199);break;
case 19:
//Concrete
//95a5a6
fill(149, 165, 166);break;
case 20:
//Asbestos
//7f8c8d
fill(127, 140, 141);break;
  }
} 

  public int sketchWidth() { return displayWidth; }
  public int sketchHeight() { return displayHeight; }
}
