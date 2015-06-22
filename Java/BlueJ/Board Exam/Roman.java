import java.io.*;
public class Roman
{
static final int values[]={1,5,10,50,100,500,1000};
static final char letters[]={'I','V','X','L','C','D','M'};
public static void main(String args[]) throws IOException,ArrayIndexOutOfBoundsException
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
String numeral="";
int tempVal1=0;
int tempVal2=0;
int ans=0;
char ch1,ch2,ch3,ch4;
System.out.print("Enter a Roman number: ");
numeral=br.readLine();
numeral=numeral+" ";
for(int x=0;x<numeral.length();x++)
{
ch1=numeral.charAt(x);
if(ch1==' ')
break;
ch2=numeral.charAt(x+1);
tempVal1=findPos(ch1);
tempVal2=findPos(ch2);
if(x==0)
{
if(values[tempVal1]>values[tempVal2])
{
ans+=values[tempVal1];
}
else if(values[tempVal2]>values[tempVal1]){
ans+=(values[tempVal2]-values[tempVal1]);
x+=1;
}
else if(values[tempVal1]==values[tempVal2]){
ans+=values[tempVal1];
ans+=values[tempVal2];
x+=1;
}
}
else
{
if(ch2==' ')
{
ch3=numeral.charAt(numeral.length()-2);
ch4=numeral.charAt(numeral.length()-3);
int tempVal3=findPos(ch3);
int tempVal4=findPos(ch4);
if(values[tempVal3]<=values[tempVal4])
{
ans+=values[tempVal3];
}
break;
}
else if(tempVal1<tempVal2)
{
ans+=(values[tempVal2]-values[tempVal1]);
x+=1;
}
else if(tempVal1>tempVal2)
{
ans+=values[tempVal1];
}
else if(tempVal1==tempVal2)
{
ans+=values[tempVal1];
ans+=values[tempVal2];
x++;
}
} 
}
System.out.println("Integer value= "+ans);
}
public static int findPos(char ch)
{
for(int y=0;y<letters.length;y++)
{
if(ch==letters[y])
{
return y;
}
}
return 1;
}
}