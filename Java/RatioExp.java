/*Rational Number Manipulation
Create a class ‘Ratio’ which stores numerator and denominator of a ratio. The class should have one empty and one parameterized constructor. Provide following functions.
addRatio ( )
subtractRatio( )
multiplyRatio( )
divideRatio( )
compareRatio( )
reciprocal( )
*/


import java.util.*;

class Ratio
{
	Scanner src=new Scanner(System.in);
	private int num,den;	

	public Ratio()
	{}

	public Ratio(int num,int den)
	{
		this.num=num;
		this.den=den;
	}
	void simplify()
	{
		for(int i=2;i<=den;i++)
		{
			if(num%i==0 && den%i==0)
			{
				num=num/i;
				den=den/i;
			}
		}
	}
	public Ratio add(Ratio t)
	{
		Ratio z=new Ratio();
		z.num=num*t.den + t.num*den;
		z.den=den*t.den;
		z.simplify();
		z.simplify();
		z.simplify();
		return z;
	}

	public Ratio subtract(Ratio t)
	{
		Ratio z=new Ratio();
		z.num=num*t.den - t.num*den;
		z.den=den*t.den;
		z.simplify();
		return z;
	}

	public Ratio multiply(Ratio t)
	{
		Ratio z=new Ratio();
		z.num=num*t.num;
		z.den=den*t.den;
		z.simplify();
		z.simplify();
		return z;
	}

	public Ratio divide(Ratio t)
	{
		Ratio z=new Ratio();
		z.num=num*t.den;
		z.den=den*t.num;
		z.simplify();
		return z;
	}

	public boolean compare(Ratio t)
	{
		int term1=num*t.den;
		int term2=t.num*den;
		if(term1>=term2)
			return true;
		else	return false;
	}

	public Ratio reciprocal()
	{
		Ratio z=new Ratio();
		z.num=den;
		z.den=num;
		return z;
	}
	
	public String toString()
	{
		return (num + " / " +den);
	}
}

class RatioExp
{
	public static void main(String args[])
	{
		boolean big;
		int num,den;
		Scanner src=new Scanner(System.in);
		System.out.println("enter ratio 1");
		Ratio a=new Ratio(src.nextInt(),src.nextInt());
		
		System.out.println("enter ratio 2");
		num=src.nextInt();
		den=src.nextInt();
		Ratio b=new Ratio(num,den);
		
		Ratio c=new Ratio();
		c=a.add(b);
		System.out.println("Addition= "+ c);
		
		c=a.subtract(b);
		System.out.println("Subtraction= "+ c);
		
		c=a.multiply(b);
		System.out.println("Multiplication= "+ c);
		
		c=a.divide(b);
		System.out.println("Division= "+ c);
		
		big=a.compare(b);
		if(big)
			System.out.println("Ratio 1 is greater than Ratio 2");
		else	System.out.println("Ratio 1 is less than Ratio 2");
	
		c=a.reciprocal();
		System.out.println("reciprocal of ratio 1= "+ c);
		c=b.reciprocal();
		System.out.println("reciprocal of ratio 2= "+ c);
	}
}
		