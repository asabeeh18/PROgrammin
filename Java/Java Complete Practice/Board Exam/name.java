import java.io.*;
public class name
{
public static void main(String args[])throws IOException
{
InputStreamReader reader=new InputStreamReader(System.in);
BufferedReader br=new BufferedReader(reader);
int c=0,d=0,k;
System.out.println("Enter your name ");
String n=br.readLine();
int l=n.length();
System.out.print("\n");
for(int i=0;i<l;i++)
{
if(n.charAt(i)==' ')
c++;
}
if(d==c)
{ 
System.out.print("Hello Mr. "+n);
}
if(c>d)
{
System.out.print("Hello Mr. "+n.charAt(0)+".");
for(k=1;k<l;k++)
{
if(n.charAt(k)==' ')
d++;
if((d<c) && (n.charAt(k)==' '))
System.out.print(n.charAt(k+1)+".");
if(d==c)
break;
}
if(d==c)
{
for(int j=k+1;j<l;j++)
System.out.print(n.charAt(j));
}
}
}
}
