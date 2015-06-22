import java.io.*;
class Declarations 
{
 BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
  static int n=10;
 static int[] roll=new int[n];
 static int[] scimark=new int[n];
 static int[] compmark=new int[n];
 static int[] gr=new int[n];
 static double[] phone=new double[n];
 static String[] name=new String[n];
 //String[] addr=new String[n];
 //String[] fname=new String[n];
 //String[] mname=new String[n];
 void assign()
 {
     for(int i=0;i<n;i++)
     {
       roll[i]=(i+1);
       scimark[i]=(i+40);
       compmark[i]=(i+45);
       gr[i]=(960+i);
      // phone[i]=(9865432101+i);
       //System.out.println(roll[i]+" "+scimark[i]+" "+compmark[i]+" "+gr[i]);
    }
     name[0]="Aarashi";
     name[1]="Aman";
     name[2]="Banta";
     name[3]="Carl";
     name[4]="Dipali";
     name[5]="Enamel";
     name[6]="Ganga";
     name[7]="Hitesh";
     name[8]="Jack";
     name[9]="Santa";   
     

    }
    
    void report()throws IOException//No. of Child
    {
        Functions f=new Functions();
        for(int i=0;i<n;i++)
        {
          System.out.println("Name:"+name[i]+"\nRoll no.:"+roll[i]+"\nGr no.:"+gr[i]);
          System.out.println("Science Marks:"+scimark[i]+"\nComputer Marks:"+compmark[i]);
          System.out.println("Phone no.:"+phone[i]);
          System.out.println("\n_________________________________________________________");
        }
       System.out.println("Do you want to go back press y/Y or n/N");
       char y=(char)(bf.read());
       if(y=='y'||y=='Y')
       f.main();
       else
       {
           }
    }
}
