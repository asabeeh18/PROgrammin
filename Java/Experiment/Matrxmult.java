import java.util.*;
class Matrix
{
	public void accept(int a[][])
 {
 Scanner src=new Scanner(System.in);
 int i,j;
 for(i=0;i<a.length;i++)
 {
  for(j=0;j<a[0].length;j++)
     a[i][j]=src.nextInt();
  System.out.println("");
  }
 }
public void mult(int a[][],int b[][],int c[][])
{
 int i,k,j,s=0;
 for(i=0;i<a.length;i++)
  for(j=0;j<b.length;j++)
  {
   s=0;
   for(k=0;k<a[0].length;k++)
     s=s+a[i][k]*b[k][j];
   c[i][j]=s;
  }
}
void display(int a[][])
{
 int i,j;
 for(i=0;i<a.length;i++)
 {
  for(j=0;j<a[0].length;j++)
   System.out.println(a[i][j]);
  System.out.println("");
 }
} 
}
class Expt
{
	public static void main(String args[])throws Exception
	{
	Scanner src=new Scanner(System.in);
 System.out.println("For The First Matrix");
 System.out.println("Enter the number of rows");
 int l=src.nextInt();
 System.out.println("Enter the number of columns");
 int mt=src.nextInt();
 int a[][]=new int[l][mt];
 Matrix m=new Matrix();
 System.out.println("Enter the elements");
 m.accept(a);
 String os = System.getProperty("os.name");

    if (os.contains("Windows"))
    {
        Runtime.getRuntime().exec("cls");
    }
    else
    {
        Runtime.getRuntime().exec("clear");
    }
 System.out.println("For The Second Matrix");
 System.out.println("Enter the number of rows");
 int n=src.nextInt();
 System.out.println("Enter the number of columns");
 int o=src.nextInt();
 if(mt!=n)
  System.out.println("Incorrect Values Multiplication NOT POSSIBLE!!!");
 else
 {
 int b[][]=new int[n][o]; 
 System.out.println("Enter the elements");
 m.accept(b);
 int c[][]=new int[mt][o];
 m.mult(a,b,c);
 System.out.println("First MAtrix");
 m.display(a);
 System.out.println("Second MAtrix");
 m.display(b);
 System.out.println("Product:");
 m.display(c);
 }
}
}  
	
	
	
	
	

