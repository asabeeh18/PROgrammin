import java.io.*;
class long_word

{
String r;
int h=0;
  int m=0,m2=0;
  int k=0;
  int m7=0;
  int max=0;
  int start=0;
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
    System.out.println("Enter the no.");
    String n=bf.readLine();
    int t=n.length();
    
    int a[]=new int [t+5];
    for(int i=0;i<n.length();i++)
    {
        if(n.charAt(i)==' ' || i==t-1)
        {
            a[h]=n.substring(start,i);
           
        }
        h++;
    }
    
    for(int j=0;j<h;j++)
    {
        
    System.out.println();
    
    
}
}
        