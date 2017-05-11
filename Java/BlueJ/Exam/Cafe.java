import java.io.*;
class Cafe
{
  BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  void main()throws Exception
  {
    System.out.println("Enter the no. of minutes used");
    int n=Integer.parseInt(bf.readLine());
    //String m[]=new String[n];
    int t=0;
    if(n>60)
    {
     int r=n-60;
      if(r>30)
     {
      rm=r-30;
       if(rm>15)
      {
        rn=rm-15;
        if(rn>0)
        {
         t=20+12+8+(2*rn);
        }
        else
        {
          t=20+12+8;
        }
     }
     else
     {
      t=20+12;
     }
    }
     else
     {
      t=20+12;
     }
    }
    else
    {
       t=20;
    }