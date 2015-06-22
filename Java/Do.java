import java.util.*;
class Do
{
	public static void main(String ar[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("UP DOWN LEFT RIGHT ");
		char up=(src.next()).charAt(0);
		//src.next();
		char down=(src.next()).charAt(0);
		//src.next();
		char left=(src.next()).charAt(0);
		//src.next();
		char right=(src.next()).charAt(0);
		System.out.println("UP "+up+" Down "+down+" left "+left+" right "+right);
	}
}	