class Temperature 
{
float f,c;
  float Convertctof (float t)
  {
      f=1.8f*t+32.0f;
      return f;
    }
    
    float Convertftoc(float e)
    {
    c=(e-32)/1.8f;
    return c;
  
    }
    void Display()
    {
       System.out.println(""+f+"\n"+c); 
    }
}
      