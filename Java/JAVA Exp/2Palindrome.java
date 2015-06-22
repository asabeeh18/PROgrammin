//2.Palindrome Number
import java.util.*;
class Palindrome
{
	public boolean isPalin(int x)
	{
		return ((x==reverse(x))?true:false);
	}	
	public int reverse(int x)
	{
		int n=0;
		while(x!=0)
		{
			//u=x%10;
			n=n*10+x%10;
			x/=10;
		}
		return n;
	}
}
class Exp2
{	
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter number of integers ");
		int n=src.nextInt();
		System.out.println("Enter the integers ");
		int a[]=new int[n];
		for(int i=0;i<n;i++)
			a[i]=src.nextInt();
		Palindrome p=new Palindrome();	
		System.out.print("Palindrome Numbers: ");
		for(int i=0;i<n;i++)
			if(p.isPalin(a[i]))
				System.out.print(a[i]+" ");		
	}
}