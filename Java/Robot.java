import java.util.*;
public class Robot
{
	public static void main(String ar[])
	{
		Scanner r=new Scanner(System.in);
		
		int m=r.nextInt();
		String s="";
		while(m-->0)
		{
			int f=r.nextInt(),b=r.nextInt(),t=r.nextInt(),fd=r.nextInt(),bd=r.nextInt();
			int d=0,cost=0;
			int i=0;
			if(f>b)
			while(true)
			{
				if(fd<=d+f)
				{
					cost=(f+b)*i+fd-d;
					cost*=t;
					s+=cost+" F \n";
					break;
				}
				d+=f-b;
				i++;
			}
			else if(f<b)
			while(true)
			{
				if(bd<=d)
				{
					cost=(f+b)*i+bd-d;
					cost*=t;
					s+=cost+" B \n";
					break;
				}
				//System.out.println(d);
				d+=b-f;
				i++;
			}
			else
			{
				if(fd<=f)
				{
					cost=fd*t;
					s+=cost+" F \n";
					break;
				}
				else
				s+="No Ditch \n";
			}
			}
			System.out.println(s);
	}
}