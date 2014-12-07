import java.io.*;
class Month	extends Thread
{
	public void run()
	{
		String[] mnth={"January","February","March","April","May","June","July","August","September","October","November","December"};
		for(int i=0;i<12;i++)
			System.out.println(mnth[i]);
	}
}
class Day extends Thread
{
	public void run()
	{
		String[] week={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		for(int i=0;i<7;i++)
			System.out.println(week[i]);
	}
}
class Expt12
{
	public static void main(String args[])throws Exception
	{
		Month t1=new Month();
		Day t2=new Day();
		t1.start();
		t2.join();
		//catch(Exception e){}	
		for(int i=0;i<10;i++)
			System.out.println("Inside Main");
	}
}	