import java.util.*;
class Pascal
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter number of lines");
		int n=src.nextInt();
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=i;j++)
				System.out.print(fact(i)/fact(j)/fact(i-j));
			System.out.println();	
		}
	}
	public static long fact(int n)
	{
		int f=1;
		for(int i=1;i<=n;i++)
			f*=i;
		return f;	
	}
}	
