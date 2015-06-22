package Encapsulation;
import java.io.*;
class Student implements Astudent
{
  int adno,sc,sst,math;
  double avg;
  String name;
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  public void readinfo()//throws IOException
  {
      try
      {
      System.out.println("Enter the admission number");
      adno=Integer.parseInt(br.readLine());
      System.out.println("Enter the name");
      name=br.readLine();
      System.out.println("Enter the science marks");
      sc=Integer.parseInt(br.readLine());
      System.out.println("Enter the Maths marks");
      math=Integer.parseInt(br.readLine());
      System.out.println("Enter the S.St marks");
      sst=Integer.parseInt(br.readLine());
      avg=getavg(sst,sc,math);
      System.out.println("Enter the Class Average");
      cavg=Double.parseDouble(br.readLine());
    }
    catch(Exception e)
    {}
      compareavg(cavg);
    }
   public void displayinfo()
    {
        System.out.println(name+" with the admission no.: \n"+adno+" has got an average of: "+avg);
        System.out.println("IN\nMaths: "+math+"\n Science:"+sc+"\n S.St"+sst);
        System.out.println("The class Average is:"+cavg);
    }
   private int getavg(int s,int st,int m)
    {
        return (s+st+m)/3;
    }
    public void compareavg(double cvg)
    {
      if(avg>cvg)
      {
          System.out.println("His average is greater than class average");
        }
        else
        {
            System.out.println("He has A lower average than class average");
        }
    }
}
        
    