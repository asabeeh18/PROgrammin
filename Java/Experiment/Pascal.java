import java.util.*;
class Pascal
{
	public void gen(int n)
	{
	
	for(int i=0;i<n;i++)
	{	
		for(int j=1;j<n-i;j++)
			System.out.print(" ");
		
		for(int j=0;j<=i;j++)
			System.out.print(fact(i)/(fact(i-j)*fact(j))+" ");
		System.out.println();
	}
	}
	public int fact(int n)		
	{
		int f=1;
		for(int i=1;i<=n;i++)
			f=f*i;
		return f;
 	}	
}
class PascalExp
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter number of lines");
		int n=src.nextInt();
		Pascal p=new Pascal();
  		p.gen(n);
	}
}	