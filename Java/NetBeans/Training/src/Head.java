
import java.util.Scanner;


//https://www.codechef.com/problems/COMM3
//Shameful Series: 7
class Head
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        
        while(t-->0)
        {
            boolean indian=false,non=false,notsure=false;
            int r=in.nextInt();
                    in.nextLine();

            String s=in.nextLine();
            for(int i=0;i<r;i++)
            {
                if(s.charAt(i)=='I')
                    indian=true;
                else if(s.charAt(i)=='Y')
                    non=true;
                else if(s.charAt(i)=='N');
                else
                    notsure=true;
            }
            if(indian && non)
                System.out.println("NOT SURE");
            else if(indian)
                System.out.println("INDIAN");
            else if(non)
                System.out.println("NOT INDIAN");
            else
                System.out.println("NOT SURE");
        }
        
        
    }
}