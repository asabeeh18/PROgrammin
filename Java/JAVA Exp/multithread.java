//MULTITHREADING
class wer implements Runnable
{
	String month[]={"jAN","fEB","mARCH","aPRIL","mAY","jUNE","jULY","aUG","sEPT","oCT","nOV","dEC"};
	String day[]={"mON","tUE","wED","tHUR","fRI","sAT","sUN"};
	String str[];
	Thread t;
	wer(int m)
	{
		if(m==1)
			str=month;
		else
			str=day;
		t=new Thread(this);	
	}		
	public void run()
	{
		for(int i=0;i<str.length;i++)
		{
			try{Thread.sleep(100);}catch(Exception e){}
			System.out.println(str[i]);
		}	
		this.notify();
	}
}
class wooot
{
	public static void main(String args[])throws Exception
	{
		wer w=new wer(1);
		wer u=new wer(0);	
		w.t.start();
		u.t.start();
		System.out.println(u.t.getPriority());
		w.t.wait();
	}	
}	