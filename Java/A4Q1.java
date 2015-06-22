/*Implement the interface using a suitable JAVA class program and also develop the main program*/
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
	int a[][]=new int[M][N];
	int b[][]=new int[M][N];
	int c[][]=new int[M][N];
	public void readMatrix()
	{
		Scanner src=new Scanner(System.in);
		System.out.println("Enter Matrix A");
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				a[i][j]=src.nextInt();
		System.out.println("Enter Matrix B");		
		for(int i=0;i<M;i++)
			for(int j=0;j<N;j++)
				b[i][j]=src.nextInt();
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
				int s=0;
				for(int k=0;k<N;k++)
					s+=a[i][k]*b[k][j];
				c[i][j]=s;
			}
	}
	public void transposeMatrix()
	{
		for(int i=0;i<M;i++)   
			for(int j=0;j<N;j++)
				c[j][i]=a[i][j];
		System.out.println("transpose of Matrix A:\n ");
		displayMatrix();
		for(int i=0;i<M;i++)   
			for(int j=0;j<N;j++)
				c[j][i]=b[i][j];
		System.out.println("transpose of Matrix B:\n ");
		displayMatrix();
	}
}
class A4Q1
{
	public static void main(String args[])	
	{
		MyMatrix m=new MyMatrix();
		m.readMatrix();
		System.out.println("Addition of A and B\n");
		m.addMatrix();
		m.displayMatrix();
		System.out.println("Multiplication of A and B\n");
		m.multMatrix();
		m.displayMatrix();
		m.transposeMatrix();
	}
}	
		