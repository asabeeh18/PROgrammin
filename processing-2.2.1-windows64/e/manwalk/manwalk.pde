float easing=0.02;
float x=0;
float y=0.6*displayHeight;
float i=1;
float inc=0.5;
float f=0;
float d=0.1*displayHeight;
float t=0;
void draw()
{

  background(i*3*255/displayWidth, i, 100);
  //moveMan(30, 0);

  if (f==0 || f==1)
    drawMan((x+i)%displayWidth, 0.6*displayHeight);
  if (f==2 || f==3)
  {
    drawMan(x, 0.6*displayHeight-i);
    line(x+10, 0.6*displayHeight+0.1*displayHeight, x+10, 0.6*displayHeight+0.1*displayHeight-i);
    line(x+0.1*displayHeight-10, 0.6*displayHeight+0.1*displayHeight, x+0.1*displayHeight-10, 0.6*displayHeight+0.1*displayHeight-i);
    if (i>=0.05*displayHeight && f==2)
    {
      f=3;
      println("====================================================");
      inc=-0.5;
      if(t>=5)
      {
        f=4;
        inc=0.5;
      }
    }
    if (f==3)
    {  
      if (i<=1)
      {  
        t++;
        inc=0.5;
        f=2;
      }
    }
   
  }
  if(f==4)
  {
     drawMan(x+i, 0.5*displayHeight-10);
     if(i>=0.2*displayHeight+20)
     {
       f=5;
       inc=0.5;
       x=(x+i)%displayWidth;
       i=1;
     }
  }  
  
  if(f==5)
  {
   drawMan(x, 0.5*displayHeight+i);
    line(x+10, 0.6*displayHeight+0.1*displayHeight, x+10, 0.6*displayHeight+i);
    line(x+0.1*displayHeight-10, 0.6*displayHeight+0.1*displayHeight, x+0.1*displayHeight-10, 0.6*displayHeight+i);
      if (i>=0.1*displayHeight)
      {  
        t++;
        inc=0;
        f=7;
      }
  }
  if(f==7)
  {
    
    drawMan(x, 0.6*displayHeight);
    f=0;
    i=1;
    inc=0.5;
  }
  i+=inc;
  println(i+" "+f);
  drawMan(displayWidth/3.0, 0.6*displayHeight);
  if ((i)%displayWidth+ 0.1*displayHeight>=displayWidth/3.0 && f==0)
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
    inc=0.5;
    x=displayWidth/3-0.1*displayHeight-10;
    drawMan(x, 0.6*displayHeight);
  }
}
void setup()
{
  size(displayWidth, displayHeight);
  smooth();
 
  drawMan(0, 0.6*displayHeight);
}
void drawMan(float a, float b)
{
  noStroke();
  fill(100, i*3*255/displayWidth, i);
  rect(a, b, 0.1*displayHeight, 0.1*displayHeight);
  stroke(0);
}

