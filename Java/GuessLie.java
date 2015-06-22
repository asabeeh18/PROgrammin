import java.util.*;
class Numb
{
	public int 
class Guess
{
	public static void main(String args[])throws Exception
	{
		Scanner src=new Scanner(System.in);
		int t=src.nextInt();
		while(t-->0)
		{
			int n=src.nextInt();
			//initialize < > = arrays here...initialsed
			int gtr[]=new int[n];
			int les[]=new int[n];
			int eq[]=new int[n];
			boolean bg[]=new boolean[n];
			boolean bl[]=new boolean[n];
			boolean be[]=new boolean[n];
			int g=0,l=0,e=0;
			for(int i=0;i<n;i++)
			{
				char c=src.next();
				if(c=='>')
				{
					gtr[g]=src.nextInt();
					bg[g++]=((src.next()).equals("Yes"))?true:false;
				}	
				else if(c=='>')
				{
					les[l]=src.nextInt();
					bl[l++]=((src.next()).equals("Yes"))?true:false;
				}	
				else if(c=='=')
				{
					eq[e]=src.nextInt();
					be[e++]=((src.next()).equals("Yes"))?true:false;
				}
			}
			
			
				