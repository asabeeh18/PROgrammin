
import java.util.Scanner;


//https://www.codechef.com/problems/COMM3
//Shameful Series: 6
class COMM3
{
    public static void main(String args[])
    {
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        in.nextLine();
        while(t-->0)
        {
            int r=in.nextInt();
            int x1=in.nextInt();
            int y1=in.nextInt();
            int x2=in.nextInt();
            int y2=in.nextInt();
            int x3=in.nextInt();
            int y3=in.nextInt();
            if(Math.sqrt((double)(x1-x2)*(x1-x2)+(y2-y1)*(y2-y1))<=r)
            {
                if(Math.sqrt((double)(x3-x2)*(x3-x2)+(y2-y3)*(y2-y3))<=r)
                    System.out.println("yes");
                else if(Math.sqrt((double)(x1-x3)*(x1-x3)+(y3-y1)*(y3-y1))<=r)
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
            else
            {
                if(Math.sqrt((double)(x1-x3)*(x1-x3)+(y3-y1)*(y3-y1))<=r)
                {
                    if(Math.sqrt((double)(x3-x2)*(x3-x2)+(y2-y3)*(y2-y3))<=r)
                        System.out.println("yes");
                    else 
                        System.out.println("no");
                }
                else
                    System.out.println("no");
            }
        }
    }
}