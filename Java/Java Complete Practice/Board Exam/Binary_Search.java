import java.io.*;
class Binary_Search
{
 BufferedReader bf =new BufferedReader(new InputStreamReader(System.in));
 void main()throws IOException
 {
  System.out.println("Enter d no. of lines");
  int l=Integer.parseInt(bf.readLine());
  int n[]=new int[l];
  for(int i=0;i<l;i++)
 {
  System.out.println("Enter: ");
  n[i]=Integer.parseInt(bf.readLine());
  
 }
 for(int i=0;i<l;i++)
 {
  for(int j=0;j<l;j++)
  {
   if(n[i]>n[j])
   {
     int t=n[i];
     n[i]=n[j];
     n[j]=t;
    }
 }
}
for(int i=0;i<l;i++)
 {
  System.out.println(n[i]);  
 }
 System.out.println("Enter:th esearch ");
 int s=Integer.parseInt(bf.readLine());
 int lb=0;
 int ub=l-1;
 int mid;
 int p=-1;
 while(p==-1&&ub>=lb)
 {
   mid=ub+lb/2;
   if(n[mid]<s)
   {
    ub=mid-1;
  }
  if(mid>s)
  {
   lb=mid-1;
  }
  if(mid==s)
  {
    p=mid;
  }
}

 
  System.out.println(p);  
 

     

}
}