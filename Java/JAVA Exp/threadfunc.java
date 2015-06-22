//isAlive join setName getName
import java.util.*;
class Sample extends Thread
{
	String name;
	Sample()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("NAMAIWA?");		
		name=src.nextLine();
	}	
	public void run()
	{
		this.setName(name);
		try{this.join();}catch(Exception e){} //infinitus
		for(int i=0;i<5;i++)
			System.out.println(this.getName()+" "+i);
		this.notify();	
	}
}	
class Funci
{
	public static void main(String args[])throws InterruptedException
	{
		Sample x=new Sample();
		Sample y=new Sample();
		x.start();
		y.start();
		for(int i=0;i<5;i++)
		{
			System.out.println(x.getName()+"isAlive?: "+x.isAlive()+" :"+i);
			System.out.println(y.getName()+"isAlive?: "+y.isAlive()+" :"+i);
		}	
		y.wait();
	}
}	