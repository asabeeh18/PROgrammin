int x,y;
void draw()
{
  dLine();
  //dRect();
} 
void dLine()
{
  float weight = dist(mouseX, mouseY, pmouseX, pmouseY);
  strokeWeight(weight/2);//slow thin
 // float my = map(mouseY,0,displayHeight,0.2*displayHeight,displayHeight);
  line(mouseX, mouseY, pmouseX, pmouseY);
}
void dRect()
{
  x=mouseX;
  y=mouseY; 
}
void mouseDragged()
{
  if(f=3)
    rect(x,y,mouseX,mouseY);
}
void setup()
{
 /* 0.2*displayHeight
  displayWidth
  line
  circle
  rectangle
  vertex
  background
  CLear*/
  size(displayWidth,displayHeight);
  for(int i=0;i<6;i++)
  {
     rect(i*displayWidth/6,0,displayWidth/6,0.1*displayHeight);
     rect(i*displayWidth/6,0.1*displayHeight,displayWidth/6,0.1*displayHeight);
  }
  line(3,3,displayWidth/6-5,displayHeight*0.1-5);
  ellipse(displayWidth/4,0.5*0.1*displayHeight,0.5*0.1*displayHeight,0.5*0.1*displayHeight);
  rect(2*displayWidth/6+10,10,displayWidth/6-30,0.1*displayHeight-30);
  point(displayWidth/2,0.5*0.1*displayHeight);
  fill(130,12,232);
  rect(5*displayWidth/6,0,displayWidth/6,0.1*displayHeight);
}
