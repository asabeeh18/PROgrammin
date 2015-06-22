import java.util.*;

class MyThread extends Thread
{
     String arr[];

     public MyThread(String arr[])
     {
          this.arr = arr;
     }

     public void run()
     {
          for(int i = 0; i < arr.length; i++)
          {
               System.out.println(arr[i]);

               try
               {
                    sleep(200);
               }
               catch(Exception e)
               {}
          }
     }
}

class E12
{
     public static void main(String args[])
     {
          Scanner src = new Scanner(System.in);

          String months[] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
          String days[] = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};

          MyThread mT = new MyThread(months);
          MyThread dT = new MyThread(days);

          mT.start();
          dT.start();
			
          try
          {
               mT.join();
               dT.join();
		
          }
          catch(Exception e)
          {}
				   for(int i=0;i<10;i++)
			System.out.println("Inside Main");
        	
		System.out.println("Main thread has ended.");
     }
}
