//Multithreading variables changing extent
import java.util.*;
class Sample extends Thread
{
	int k=2;
	public void run()
	{
		int i;
		for(i=0;i<10;i++)
		{
			k*=k;
			try{
			Thread.sleep(10);}
			catch(Exception e){}
			System.out.println(k);
		}
	}
	void func()
	{
		System.out.println(k);
	}
}	
class Threed
{
	public static void main(String args[])
	{
		Sample x=new Sample();
		Sample y=new Sample();
		x.start();
		y.start();
		x.func();
		
	}
}	
		
			
			