import java.util.*;
class Booth
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int x=src.nextInt();
		int y=src.nextInt();
		char a[],b[],ac[];
		int d=0;
		int l=(x>y)?x:y;
		for(int i=1;i<=l;i*=2,d++);
		String sac=Integer.toBinaryString(-x);
		String sa=Integer.toBinaryString(x);
		String sb=Integer.toBinaryString(y);
		d++;
		if(x<0)
		{
			a=sa.toCharArray();
			ac=(sac.substring(sac.length()-l+1,sac.length())).toCharArray();
		}	
		else
		{
			a=sa.toCharArray();	
			ac=(sac.substring(sac.length()-l+1,sac.length())).toCharArray();
		}
		//
		if(y<0)
		{	b=(sb.substring(sac.length()-l+1,sb.length())).toCharArray();}
		else
		{	b=sb.toCharArray();}
		System.out.println(a);
		System.out.println(ac);
		System.out.println(b);
	}
}	
			