//4.Matrix Multiplication
import java.util.*;
class Matrix
{
	private int a[][];
	public Matrix(){}
	public Matrix(int m,int n)
	{
		a=new int[m][n];
	}	
	public void read()
	{
		Scanner src=new Scanner(System.in);
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[0].length;j++)
				a[i][j]=src.nextInt();
	}		
	public Matrix mult(Matrix m)
	{
		if(a[0].length!=m.a.length)
			return null;
		Matrix x=new Matrix(a.length,m.a[0].length);
		for(int i=0;i<a.length;i++)
			for(int j=0;j<m.a.length;j++)
			{
				int s=0;
				for(int k=0;k<a[0].length;k++)
					s+=a[i][k]*m.a[k][j];
				x.a[i][j]=s;	
			}
		return x;	
	}
	public String toString()
	{
		String s="";
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[0].length;j++)
				s+=a[i][j]+" ";
			s=s+'\n';	
		}
		return s;	
	}	
}
class Exp4
{	
	public static void main(String args[])
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter Rows and Cols of Matrix1");
		Matrix a=new Matrix(src.nextInt(),src.nextInt());
		System.out.println("Enter Elements");
		a.read();
		System.out.println("Enter Rows and Cols of Matrix2");
		Matrix b=new Matrix(src.nextInt(),src.nextInt());		
		System.out.println("Enter Elements");
		b.read();
		System.out.println("Matrix 1:\n"+a);
		System.out.println("Matrix 2:\n"+b);
		System.out.println("SUM \n"+a.mult(b));
		
	}
}