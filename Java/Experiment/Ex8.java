import java.util.*;
class MyInt
{
	private int n;
	MyInt()
	{
	}
	MyInt(int n)
	{
		this.n=n;
	}	
	public int intVal()
	{
		return n;
	}
	public String toString()
	{
		return ""+n;
	}
}
class Ex8
{
	public static void main(String args{])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter the integer Value");
		MyInt m=new MyInt(src.nextInt());
		System.out.println("Enter the 2nd integer Value");
		MyInt n=new MyInt(src.nextInt());
		MyInt sum=new MyInt(m.intVal()+n.intVal());
		System.out.println("Sum of "+m+" and "+n+" is "+sum);
	}	
}		