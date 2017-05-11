import java.io.*;
public class possi
{
void sailee()throws IOException
{

BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
System.out.println("Please input a three digit number");
int s= Integer.parseInt(br.readLine());
int rem[]= new int [4];

String hundreds[]={"one hundred","two hundred","three hundred","four hundred","five hundred","six hundred","seven hundred","eight hundred","nine hundred"};
String tens[]={"twenty","thirty","forty","fifty"};
String units[]={"one","two","three","four","five","six"};
int i=0,i2;
int p=s;
while(p!=0&&i<5)
{
rem[i]=p%10;
p=p/10;
i++;
}
for(i2=0;i2<=9;i2++)
{
if(rem[2]==i2)
{
System.out.print(hundreds[i2]+" and ");
}
if(rem[1]==i2)
{
System.out.print(tens[i2]+" ");
}
if(rem[0]==i2)
{
System.out.println(units[i2]);
}
}
}
}