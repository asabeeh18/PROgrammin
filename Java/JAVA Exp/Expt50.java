 import java.util.*;

class Sample extends Thread
{
   public void run( )
  {
    for (int i=1; i<=10; i++)
    {
      try
      {
       System.out.println("Child : "+i+" ");
       Thread.sleep(200);
       }
       catch(Exception e) { }
    }
   }
}

 class Expt50
 {
  public static void main(String args[])
  {
     Sample x=new Sample( );
     x.start( ); 
     for (int i=1; i<=10; i++)
     {
       try
      {
        System.out.println("Main : "+i+" ");  
         Thread.sleep(500);
      }
      catch(Exception e) { }
     }     
 }
}




 
