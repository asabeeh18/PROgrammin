int value = 0;

void draw() {
  fill(value,value/2,value/3);
  rect(25, 25, 50, 50);
}

void mouseDragged() 
{
  value = value + 5;
  if (value > 255) {
    value = 0;
  }
}
