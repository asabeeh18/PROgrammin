import java.util.*;
interface Matrix
{
	final static int M=5,N=5;
	void readMatrix();
	void displayMatrix();
	void addMatrix();
	void multMatrix();
	void transposeMatrix();
}
class MyMatrix implements Matrix
{
	int a[][],b[][],c[][];
	final static int M=5,N=5;
	MyMatrix()
	{
		a=new int[M][N];
		b=new int[M][N];
		c=new int[M][N];
	}	
	public void readMatrix()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter the first Matrix");
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				a[i][j]=src.nextInt();
		System.out.println("Enter the Second Matrix");
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				b[i][j]=src.nextInt();
	}			
	public void addMatrix()
	{
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				c[i][j]=a[i][j]+b[i][j];
	}
	public void multMatrix()
	{
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
			{
				int sum=0;
				for(int k=0;k<N;k++)
					sum+=a[i][k]*b[k][j];
				c[i][j]=sum;
			}
	}		
	public void transposeMatrix()
	{
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
			{
				int t=a[i][j];
				a[i][j]=c[j][i];
				c[j][i]=t;
			}	
		System.out.println("Transpose of First Matrix");
		displayMatrix();	
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
			{
				int t=b[i][j];
				b[i][j]=c[j][i];
				c[j][i]=t;
			}	
		System.out.println("Transpose of Second Matrix\n");	
		displayMatrix();
	}		
	public void displayMatrix()
	{
		for(int i=0;i<M;i++)
		{
			for(int j=0;j<N;j++)
				System.out.print(c[i][j]+" ");
			System.out.println();	
		}
	}	
}
class A4Q1
{
	public static void main(String args[])
	{
		MyMatrix m=new MyMatrix();
		m.readMatrix();
		m.addMatrix();
		System.out.print("Sum of first and Second Matrix");
		m.displayMatrix();
		m.multMatrix();
		System.out.print("Product of first and Second Matrix");
		m.displayMatrix();
		m.transposeMatrix();
	}
}	
	