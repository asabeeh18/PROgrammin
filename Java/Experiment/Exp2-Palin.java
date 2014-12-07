import java.util.*;
class Palin
{
	public boolean isPalin(int  n)
	{
 		int a=n;
		n=reverse(n);
		if(a==n)
			return(true);
		return(false);
	}
	
	public int reverse(int n)
	{
		int temp=0;
		while(n !=0)
		{
			int u=n%10;
			temp=temp*10+u;
			n=n/10;
		}
		return temp;
	}
}
		 
class Exp2
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter number");
		int n=src.nextInt();
		Palin p=new Palin();
		if(p.isPalin(n))
			System.out.println("PALINDROME");
		else	System.out.println("NOT PALINDROME"); 
	}
}	