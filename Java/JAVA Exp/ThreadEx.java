//Multi threading
import java.util.*;
class ToThread extends Thread
{
	Thread t;
	ToThread()
	{
		this.start();
	}
	public void run()
	{
		//t.sleep(990);
		for(int i=0;i<10;i++)
		{
			System.out.println(i);
			try{
			t.sleep(990);
			}
			catch(InterruptedException e){}
		}
	}
}
class ThreadEx
{
	public static void main(String a[])
	{	
		ToThread to=new ToThread();
		try{
			Thread.sleep(990);//sleep() is static
			}
			catch(InterruptedException e){}
		for(int i=0;i<50;i++)
			System.out.println("BAAKA");
	}
}		