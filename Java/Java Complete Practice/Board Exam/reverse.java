import java.io.*;
class reverse
{
 BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
 void rev()throws IOException
 {
  String s=bf.readLine();
  s=s.toLowerCase();   //97-122
  int l=s.length();
  char s1[]=new char[l];
  l--;
  for(int i=0;i<l;i++)
  {
   int x=(int)s.charAt(i);
   x=(122-x)+97;
   s1[i]=(char)x;
  }
  for(int i=0;i<l;i++)
  {
   System.out.print(s1[i]);
  }     
      
}}