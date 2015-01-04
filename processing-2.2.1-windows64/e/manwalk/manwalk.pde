float easing=0.02;
float x=0;
float y=0.6*displayHeight;
float i=1;
float inc=0.5;
float f=0;
float d=0.1*displayHeight;
void draw()
{
  
   background(i * (3*255.0/displayWidth), 100, 0);
  //moveMan(30, 0);
  
    if(f==0 || f==1)
      drawMan((x+i)%displayWidth, 0.6*displayHeight);
    if(f==2)
    {
     // drawMan(x,0.6*displayHeight-i);
     
   //   line(x+d/3.0,0.6*displayHeight+d,x+d/3.0,0.6*displayHeight+d+100);
      strokeWeight(10);
      line(x+2*d/3.0,0.6*displayHeight+d,x+2*d/3.0,0.6*displayHeight+d+100);
      strokeWeight(1);
    }
       
    i+=inc;
    println(millis());
    
      drawMan(displayWidth/3.0,0.6*displayHeight);
    if((i)%displayWidth+ 0.1*displayHeight>=displayWidth/3.0 && f==0)
    {
      inc=-inc;
      f=1;
    }
    if(f==1 && (i)%displayWidth==0)
    {
       inc=-inc+2;
       f=0;
    }
    if(millis()>=50000 && millis()<=53000)
    {
      textSize(160);
      textAlign(CENTER);
      text("DAMN!!!\nITS ANNOYING!!",displayWidth/2,displayHeight/5);
    }
    if(millis()>53000 && millis()<65000)
    {
      textSize(160);
      textAlign(CENTER);
      text("STOP",displayWidth/2,displayHeight/5);
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
  fill((100-i)%255,(i)%255,(100+i)%255);
  rect(a, b, 0.1*displayHeight, 0.1*displayHeight);
}
