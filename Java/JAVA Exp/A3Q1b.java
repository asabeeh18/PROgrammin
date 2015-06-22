/*Q 1.b Create a class Complex which stores real and imaginary parts of a complex number
 provide the following functions constructors,add,toString,modulus.*/
import java.util.*;
import java.io.*;
class Complex
{
	private int i,r;
	Complex()
	{}
	Complex(int r,int i)
	{
		this.r=r;
		this.i=i;		
	}
	public void add(Complex a,Complex b)
	{
		r=a.r+b.r;
		i=a.i+b.i;
	}
	public double modulus()
	{
		return Math.sqrt(i*i+r*r);
	}
	public String toString()
	{
		String s="";
		if(i<0)
			s=r+i+"i";
		else if(i>0)	
			s=r+"+"+i+"i";	
		else
			s=r+"";
		return s;
	}		
}
class A3Q1b
{
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		Complex a=new Complex(src.nextInt(),src.nextInt());
		Complex b=new Complex(src.nextInt(),src.nextInt());
		Complex c=new Complex();
		c.add(a,b);
		System.out.println("Addition result: "+c);
		System.out.println("Modulus Result for 1st="+a.modulus());
		System.out.println("Modulus Result for 2nd="+b.modulus());
	}
}