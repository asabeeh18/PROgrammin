import java.util.Scanner;
class PauseStopwatchState extends Thread
{
	public int pauseSecond = 0;
	public boolean pauseFlag;
	public void run()
	{
		try 
		{
			System.out.println("Pause State has Been Called");
			while(pauseFlag!=true)
			{
			Thread.sleep(1000);
			pauseSecond=pauseSecond+1;
			System.out.print('\u000C');
			}
		} 
		catch (InterruptedException e) 
		{
			
		}
		
		
	}
	public int pauseStopwatch() 
	{
		pauseFlag=true;
		return pauseSecond;
	}
}
class StopwatchInstruction extends Thread
{
	private Scanner src;

	public void run()
	{
		System.out.println("1:To Stop 2:To Pause");
		int ch = 0;
		src = new Scanner(System.in);
		Stopwatch x = new Stopwatch();
		while(ch!=1)
		{
		ch = src.nextInt();
		switch(ch)
		{
			case 1:  
					x.makeStopWatchStop();	
					break;
			case 2: PauseStopwatchState y = new PauseStopwatchState();
					y.start();
					System.out.println("Press 1 to Resume");
					if((src.nextInt())==1)
					{
						int totalPauseTime = y.pauseStopwatch();
						Stopwatch z = new Stopwatch();
						z.resumeStateHasBeenCalled(totalPauseTime);
					}
					
		}
		}
		x.makeStopWatchStop();
	}
}
class Stopwatch extends Thread
{
	private static int second=0;
	
	private static boolean flag;
	
	public void run() 
	{
		Scanner src = new Scanner(System.in);
		try 
		{
			while(flag!=true)
			{
			System.out.println("Current Time is : "+second);
			
			Thread.sleep(1000);
			second=second+1;
			}
			
			
		} 
		catch (Exception e) 
		{
			System.out.println("Block 1");
		}
		finally
		{
			System.out.println("Stoped at : "+second);
		}
	}
	public void resumeStateHasBeenCalled(int totalPauseTime) 
	{
	second = second - totalPauseTime;
	
	}
	
	public void makeStopWatchStop() 
	{
		flag=true;
	}
	
}
class Main
{
	public static void main(String args[])
	{
		Scanner src = new Scanner(System.in);
		System.out.println("Press any key to Start StopWatch");
		String s = src.next();
		Stopwatch time = new Stopwatch();
		StopwatchInstruction x = new StopwatchInstruction();
		time.start();
		x.start();
	}
}