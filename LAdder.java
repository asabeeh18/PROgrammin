import java.util.*;
public class Main
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		int t=src.nextInt();
		while(t-->0)
		{
			int b=src.nextInt();
			int ls=src.nextInt();
			double max=Math.sqrt(ls*ls+b*b);
			double min=Math.sqrt(ls*ls-b*b);
			System.out.println(min+" "+max);
		}
	}
}	