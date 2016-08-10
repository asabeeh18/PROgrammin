import java.util.Scanner;
class Lucky
{
	public static void main(String as[])
	{
		Scanner r =new Scanner(System.in);
		int t=r.nextInt();
		int n=r.nextInt();
		while(t-->0)
		{
			int x=r.nextInt();
			int y=r.nextInt();
			int res=(int)Math.pow((x%n),y)%n;
			System.out.println(res);
		}
	}
}