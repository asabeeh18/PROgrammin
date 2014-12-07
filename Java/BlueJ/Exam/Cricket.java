import java.io.*;
class Cricket
{
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
    
    int p,c=0;
    String x;
    System.out.println("Enter the no. of players");
    int n=Integer.parseInt(bf.readLine());
    String m[]=new String[n];
    int l[]=new int[n];
    for(int i=0;i<n;i++)
    {
     System.out.println("Enter the name of player:"+i);
     m[i]=bf.readLine();
     System.out.println("Enter the no. of ODI matches played by him");
     l[i]=Integer.parseInt(bf.readLine());
     if(l[i]>200)
     {c++;}
         
    }
    for(int i=0;i<n-1;i++)
    {
      x=m[i];
      p=i;
      for(int j=0;j<n;j++)
      {
          if((m[j].compareTo(x))<1)
          {
              x=m[j];
              p=j;
            }
        }
        m[p]=m[i];
        l[p]=l[i];
        m[i]=x;
        
    }
    System.out.println("the number of players who have played more than 200 matches."+c);
    System.out.println("Sorted Array");
    for(int i=0;i<n;i++)
    {
     System.out.println(m[i]+" ");
    }
 }
}