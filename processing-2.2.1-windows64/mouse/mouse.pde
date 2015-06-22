int i=0;
void draw()
{
/*  int x=(int)random(displayWidth);
  int y=(int)random(displayHeight);
   ellipse(x,y,50,50);
   if(dist(x,y,mouseX,mouseY)<=80)
     println("OK");
     delay(3000);
  //  println("Press");
   if(dist(x,y,mouseX,mouseY)<=80)
     println("OK");
   //background(mouseY * (255.0/800), 100, 0);*/
     ellipse(mouseX,mouseY,50,50);
}
void setup()
{
   size(displayWidth,displayHeight);
   smooth();
   strokeWeight(10);
   int x=(int)random(displayWidth);
  int y=(int)random(displayHeight);
   ellipse(mouseX,mouseY,50,50);
   for(int i=0;i<10000;i++)
   if(dist(x,y,mouseX,mouseY)<=80)
     println("OK");
  
}
void delay(int delay)
{
  int time = millis();
  while(millis() - time <= delay);
}









