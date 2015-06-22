//Follower
//right true
//left false
import java.util.*;
class Followr
{
	int cx=0,cy=0;
	void spacer()
	{
		for(int i=0;i<cy;i++)
				System.out.println();
		for(int i=0;i<cx;i++)
			System.out.print(" ");
	}		
	void put(boolean bl)
	{
		spacer();
		if(bl)
		{
			System.out.print("x");
			cx++;
		}	
		else
		{
			System.out.print("x");
			cy++;
		}
	}
	void choice()
	{
		Scanner src=new Scanner(System.in);
		int ch;
		System.out.println(" 2 for down 6 for right 0 to quit");
		do
		{
			ch=src.nextInt();
			if(ch==6)
				put(true);
			else if(ch==2)
				put(false);
			else{}	
		}while(ch!=0);		
	}	
}	
class ME
{
	public static void main(String arf[])
	{
		Followr fr=new Followr();
		fr.choice();
	}	
}	
				