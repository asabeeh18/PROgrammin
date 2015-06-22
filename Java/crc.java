//CRC
import java.util.*;
class Main
{
	public static int rem(int s,int g)
	{
		int l2=(int)(Math.log(g)/Math.log(2.0));
		while(true)
		{
			int l1=(int)(Math.log(s)/Math.log(2));
			if(l2>l1)
				break;
			int a=g*(int)Math.pow(2,l1-l2);
			s=s^a;
		}
		return s;
	}

	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter String in Binary Code: ");
		String s=src.nextLine();
		System.out.println("Enter Polynomial: ");
		String g=src.nextLine();
		for(int i=1;i<g.length();i++)	//pad 0's
			s=s+0;
			
		int is=Integer.parseInt(s,2);
		int ig=Integer.parseInt(g,2);
		int mod=(is%ig);
		String a=Integer.toBinaryString(mod);
		while(a.length()!=g.length()-1)	//pad 0 to remainder
			a+=0;
		int b=is+Integer.parseInt(a,2);

		s=Integer.toBinaryString(b);
		System.out.println("Generated Binary Code: "+s);
		System.out.println("Enter Received Binary Code: ");
		String r=src.nextLine();
		int rec=Integer.parseInt(r,2);
		if(rem(rec,ig)==0)
		{
			System.out.println("ALL OK!");
		}
		else
			System.out.println(":'( ");
	}
}