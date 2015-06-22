 import java.util.*;

class Sample extends Thread
{
   private String name;
   public Sample(String name)
   {
      this.name=name;
   }
   public void run( )
  {
    for (int i=1; i<=10; i++)
    {
      try
      {
       System.out.println(name+" : "+i+" ");
       Thread.sleep(200);
       }
       catch(Exception e) { }
    }
   }
}

 class Expt51
 {
  public static void main(String args[])
  {
     Sample x=new Sample("India");
     Sample y=new Sample("Mumbai");
     x.start( ); 
     y.start( );
        
 }
}




 
