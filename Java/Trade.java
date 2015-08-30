import java.util.*;
public class Trade
{
	public static int strMatch(String st,String s[])
	{
		for(int i=0;i<s.length;i++)
		{
			if(s[i].equals(st))
				return i;
		}
		return -1;
	}
	public static int convertDate(int d)
	{
		if(d<6)
			return d;
		if(d>7 && d<13)
			return d-2;
		if(d>14 && d<20)
			return d-4;
		if(d>21 && d<27)
			return d-6;
		return d-8;
	}
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		String[] s=new String[5];
		int[][] date=new int[5][22];
		int[] hold=new int[5];
		int gain=0;
		for(int i=0;i<5;i++)
		{
			s[i]=r.next();
			for(int j=0;j<22;j++)
			{
				date[i][j]=r.nextInt();
			}
		}
		while(true)
		{
			int d=r.nextInt();
			if(d==-1)
			{
				break;
			}
			d=convertDate(d);
		//	System.out.println("Todays date: "+d);
			char bs=r.next().charAt(0);
			String st=r.next();
			int qt=r.nextInt();
			int stock=strMatch(st,s);
			if(bs=='B')
			{
				hold[stock]+=qt;
				gain-=date[stock][d-1]*qt;
			}
			else if(bs=='S')
			{
				hold[stock]-=qt;
				gain+=date[stock][d-1]*qt;
			}
		}
		for(int i=0;i<s.length;i++)
		{
			if(hold[i]>0)
			{
				System.out.println(s[i]+" "+hold[i]);
			}
		}
		if(gain>=0)
			System.out.println(gain+"");
		else
			System.out.println(""+(-gain));
	}
}