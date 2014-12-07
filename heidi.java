import java.util.*;
class Kozo
{
	String s;
	int p[]=new int[4];
	Kozo()
	{
		Scanner src=new Scanner(System.in);
		src.nextInt();
		s=src.next();
		int x[]=new int[4];
		simul(0,x);
	}
	void simul(int i,int x[])
	{
		boolean d=false;
		int m;
		if(i>=s.length())
			return;
		switch(s.charAt(i))
		{
			case 'G':x[0]++;
						break;
			case 'H':x[1]++;
						break;
			case 'R':x[2]++;
						break;
			case 'S':x[3]++;
						break;
			default: 	m=min(x);
						if(x[0]==m)
						{
							x[0]++;
							simul(i+1,x);
							x[0]--;
						}	
						if(x[1]==m)
						{
							x[1]++;
							simul(i+1,x);
							x[1]--;
						}	
						if(x[2]==m)
						{
							x[2]++;
							simul(i+1,x);
							x[2]--;
						}	
						if(x[3]==m)
						{
							x[3]++;
							simul(i+1,x);
							x[3]--;
						}
						d=true;
		}
		if(d==false)
			simul(i+1,x);
		if(i==s.length()-1)
		{
			m=min(x);
			if(x[0]==m && p[0]==0)
			{
				System.out.println("Green");
				p[0]=1;
			}	
			if(x[1]==m && p[1]==0)
			{
				System.out.println("Heliotrope");
				p[1]=1;
			}	
			if(x[2]==m && p[2]==0)
			{
				System.out.println("Red");
				p[2]=1;
			}	
			if(x[3]==m && p[3]==0)
			{
				System.out.println("Silver");
				p[3]=1;
			}
		}
	}
	int min(int a[])
	{
		int m=a[0];
		for(int i=1;i<4;i++)
			if(m>a[i])
				m=a[i];
		return m;
	}	
}
class Solution
{
	public static void main(String args[])
	{
		Kozo z=new Kozo();
	}	
}	
						