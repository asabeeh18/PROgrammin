import java.util.*;

class CatsDogs
{
    public static void main(String arp[])
    {
        Scanner r=new Scanner(System.in);
        int t=r.nextInt();
        while(t-->0)
        {
            int c=r.nextInt();
            int d=r.nextInt();
            int n=r.nextInt();
            boolean flag=true;
            
            if(n%4!=0)
                flag=false;
            //36 24 24
            if((c*4+d*4-n)>2*d*4)
                flag=false;
            if((c*4+d*4-n)%4!=0)
                flag=false;
            if(n>c*4+d*4)
                flag=false;
            if(flag)
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}