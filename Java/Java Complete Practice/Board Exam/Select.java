import java.io.*;
class Select
{
 BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
 void rev()throws IOException
 {
 int l=Integer.parseInt(bf.readLine());
 int tmp,m,p;
 int n[]=new int[l];
 for(int i=0;i<l;i++)
 {
  System.out.println(i+" ");
  n[i]=Integer.parseInt(bf.readLine());
 }
 
 for(int i=0;i<l;i++)
 {
     m=n[0];
     p=0;
  for(int j=i+1;j<l;j++)
  {
   if(n[j]>m)
  {
   m=n[j];   
   p=j;
  }
}
  tmp=n[i];
  n[i]=n[p];
  n[p]=tmp;
}
for(int i=0;i<l;i++)
 {
  System.out.println(n[i]);
 }
}}