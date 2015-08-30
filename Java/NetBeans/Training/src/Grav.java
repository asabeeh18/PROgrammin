import java.util.*;
class Grav
{
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		int t=r.nextInt();
		r.nextLine();
		char s[][]=new char[2][];
		int l;
		int grav;
		while(t-->0)
		{
			grav=0;
			s[0]=r.nextLine().toCharArray();
			s[1]=r.nextLine().toCharArray();
			int c[]=new int[2];
			//System.out.println(new String(s[0])+"\n"+new String(s[1]));
			while(c[0]<s[0].length && s[0][c[0]]=='.')
				c[0]++;
			while(c[1]<s[1].length && s[1][c[1]]=='.')
				c[1]++;
			
			if(c[0]>c[1])
				l=0;
			else
				l=1;
			int d=c[l]-1;
			if(d==-1)
			{
				System.out.println("No");
				continue;
			}
			int oldgrav=-1;
			while(d<s[0].length-1)
			{
				l^=1;	//toggle 1 and 0
				if(oldgrav==grav)
				{
					System.out.println("No");
					break;
				}
				
				oldgrav=grav;
				if(s[l][d+1]=='.')
				{
					grav++;
					while(d<s[0].length-1 && s[l][d+1]=='.')
						d++;
				}
				else if(s[l][d]=='.')
				{
					grav++;
					while(d<s[0].length-1 && s[l][d]=='.')
						d++;
				}
			}
			if(d>=s[0].length-1)
			System.out.println("Yes\n"+(grav));
		}
	}
}