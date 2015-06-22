import java.io.*;
class Declarations 
{
 static BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
 static int n=10;
 static int[] roll=new int[n];
 static int[] scimark=new int[n];
 static int[] compmark=new int[n];
 static int[] gr=new int[n];
 static long[] phone=new long[n];
 static String[] name=new String[n];
 static String[] addr=new String[n];
 static String[] fname=new String[n];
 static String[] mname=new String[n];
 static String[] fees=new String[n];
 static void assign()
 {
     for(int i=0;i<n;i++)
     {
       roll[i]=(i+1);
       scimark[i]=(i+40);
       compmark[i]=(i+45);
       gr[i]=(960+i);
       phone[i]=(27458200+i);
       addr[i]="Sri Aastha housing Society Flat no."+i;
    }
     name[0]="Aarashi";
     name[1]="Aman";
     name[2]="Banta";
     name[3]="Carl";
     name[4]="Dipali";
     name[5]="Enamel";
     name[6]="Ganga";
     name[7]="Hitesh";
     name[8]="Jeet";
     name[9]="Santa";
 //__________________--Fathers names-_______________________    
     fname[0]="Ravi";
     fname[1]="Siddhu";
     fname[2]="Rajesh";
     fname[3]="Raju";
     fname[4]="Arjun";
     fname[5]="Akshay";
     fname[6]="Amir";
     fname[7]="Ritesh";
     fname[8]="Rohan";
     fname[9]="Dhanda";
//_______________________--Mothers names--____________________     
     mname[0]="Sumita";
     mname[1]="Latika";
     mname[2]="Aishwarya";
     mname[3]="Savitri";
     mname[4]="Seeta";
     mname[5]="Geeta";
     mname[6]="Meera";
     mname[7]="Raima";
     mname[8]="Zaina";
     mname[9]="Sam";    
//________________-----Fee Status--________________________
    fees[0]="Paid"; 
    fees[1]="Not Paid";
    fees[2]="Paid";
    fees[3]="Not Paid";
    fees[4]="Paid";
    fees[5]="Paid";
    fees[6]="Not Paid";
    fees[7]="Paid";
    fees[8]="Paid";
    fees[9]="Paid";
    }    
    static void report()throws IOException//No. of Child
    {
        Functions f=new Functions();
        for(int i=0;i<n;i++)
        {
          System.out.println("Name:"+name[i]+"\nRoll no.:"+roll[i]+"\nGr no.:"+gr[i]);
          System.out.println("Fathers name:"+fname[i]+"\nMothers name:"+mname[i]);
          System.out.println("Science Marks:"+scimark[i]+"\nComputer Marks:"+compmark[i]);
          System.out.println("Phone no.:"+phone[i]);
          System.out.println("Fee Status:"+fees[i]);
          System.out.println("Address:"+addr[i]);
          System.out.println("_________________________________________________________");
        }
       System.out.println("Do you want to go back press y/Y");
       char y=(char)(bf.read());
       if(y=='y'||y=='Y')
       f.func();
    }
}
