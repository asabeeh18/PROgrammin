import java.util.*;

class Complex
{
	private double r,i; 
	public Complex()
	{}	

	public Complex(double r,double i) 
	{
		this.r=r;
		this.i=i;
	}

	public void add(Complex s,Complex t)
	{
		r=s.r + t.r;
		i=s.i + t.i;
	}

	public double modulus()
	{
		double mod= Math.sqrt(r*r + i*i);
		return mod;
	}
	

	public String toString()
	{
		if(i>0)
			return(r + "+" + i + "i");
		else	return("" + r + i + "i");
	}
}

class ComplexMod
{
	public static void main(String args[])
	{
		double ans;
		Scanner src=new Scanner(System.in);
		System.out.println("enter two complex numbers");
		Complex a=new Complex(src.nextDouble(), src.nextDouble());	
		Complex b=new Complex(src.nextDouble(), src.nextDouble());	
		Complex c=new Complex();
		c.add(a,b);
		System.out.println("ADDITION = " +c);
		ans=a.modulus();
		System.out.println("modulus of "+ a + "= "+ ans );
		ans =b.modulus();
		System.out.println("modulus of "+ b + "= "+ ans );
	}
}