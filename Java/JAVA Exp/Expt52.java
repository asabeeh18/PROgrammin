 import java.util.*;
class Sample extends Thread
{
   private char ch;
   public Sample(char ch)
   {
      this.ch=ch;
   }
   public void run( )
  {
    for (int i=1; i<=7; i++)
    {
      try
      {
       System.out.print(ch+" ");
       Thread.sleep(200);
       }
       catch(Exception e) { }
    }
   }
}

 class Expt52
 {
  public static void main(String args[])
  {
     Sample x=new Sample('*');
     Sample y=new Sample('/');
     x.start( ); 
     y.start( );
        
 }
}




 
