import java.io.*;
public class Bsearch
{
public static void main (String ars[]) throws IOException
{
int ub;
int lb;
int mid;
int i;
int arr[]=new int[50];
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
System.out.print("Enter Total Numbers : ");
String v1=br.readLine();
int X;
X = Integer.parseInt (v1);

for (i=0; i<X; i++)
{
System.out.print("Enter the numbers in ascending order : ");
arr[i]=Integer.parseInt (br.readLine());
}
int a;
ub=X;
lb=0;
System.out.print("\nEnter Number to be searched : ");
int value;
value=Integer.parseInt (br.readLine());
mid=(lb+ub)/2;
while (value!=arr[mid])
{
if (value<arr[mid])
ub=mid;
else if (value>arr[mid])
lb=mid;
mid=(lb+ub)/2;
}
mid=mid+1;
System.out.println ( "The required number is found at position : "+mid);
}
}