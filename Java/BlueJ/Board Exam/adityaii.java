import java.io.*;
public class adityaii
{
public static void main(String ar[])
{
BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));

System.out.println("Enter the string: ");
String name=sc.nextLine();
int l,n,r=0,c=-1,i=0,j,z;
char t;
l=name.length();

n=(l*2)-1;
char a[][]=new char[n][n];
z=n;
while(n>0)
{
t=name.charAt(i);
for(j=1;j<=n;j++)
a[r][++c]=t;
for(j=1;j<n;j++)
a[++r][c]=t;
for(j=1;j<n;j++)
a[r][--c]=t;
for(j=1;j<n-1;j++)
a[--r][c]=t;
n-=2;
i+=1;
}


n=z;
for(i=0;i<n;i++)
{
for(j=0;j<n;j++)
{
System.out.print(a[i][j]+" ");
}
System.out.println();
}


}


}