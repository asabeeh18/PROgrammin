import java.io.*;
class rev

{
  int m=0,m2=0,p=1;
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void min()throws Exception
  {
    System.out.println("Enter the string");
   String x=bf.readLine();
   int t=x.length();
   for(int i=0;i<t;i++)
   {
       char a=x.charAt(i);
       if(a==' '||i==t-1)
       {
           String s=x.substring(m,i+1);
           StringBuffer st=new StringBuffer(s);
           StringBuffer y=st.reverse();
           System.out.print(y+" ");
           m=i+1;
        }
    }
}
}