import java.util.Scanner;
public class Mainfake
{
	
	static char p[];
	static int n;
	
	static int ST=-1;
	static int popS()
	{
		if(ST>-1)
		{
			ST--;
			return 1;
		}
		return 0;
	}
	static void pushS()
	{
		ST++;
	}
	static int maiin(int i) //i is '<'
	{
		
		i+=2;
		while(i<n && p[i]!='>')
		{
			if(p[i]=='{')
			pushS();
			else if(p[i]=='}')
			{
				if(popS()==0)
				return 0;
			}
			else if(p[i]=='P')
			{}
			else
				return 0;
			i+=2;
		}
		if(ST==-1 && p[i]=='>')
			return i;
		return 0;
	}
	static int userdef(int i) //i is '<'
	{
		int poi=0;
		i+=2;
		while(i<n && p[i]!=')')
		{
			if(p[i]=='{')
			pushS();
			else if(p[i]=='}')
			{
				if(popS()==0)
				return 0;
			}
			else if(p[i]=='P')
			{
				poi++;
				if(poi>100)
					return 0;
			}
			else
				return 0;
			i+=2;
		}
		if(ST==-1 && p[i]==')')
			return i;
		return 0;
	}
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		int t=r.nextInt();
		String temp123=r.nextLine();
		while(t-->0)
		{
			int status=0;
			int i=0;
			int mainC=0;
			p=(r.nextLine()).toCharArray();
			System.out.print("Compilation Errors");
		}
		
	}
}