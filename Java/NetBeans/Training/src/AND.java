import java.util.*;

public class AND 
{
    static long[] a;
    static int n,k,c=0;
    static long maxand=0;
    static long solve(int l,int i,long and)
    {
        long ans;
        if(l<k)
        {
            for(int j=i;j<a.length;j++)
            {
               
               ans=solve(l+1,j+1,and&a[j]);
               //System.out.print("Set for: "+and+ "&"+a[j]+"="+ans);
               if(l==k-1 && ans>maxand)
               {
                   //System.out.print(",new,");
                   c=1;
                   maxand=ans;
               }
               else if(l==k-1 && ans==maxand)
               {
                   //System.out.print(",same,");
                   c++;
               }
               
            }
        }
        else return and;
        return maxand;
    }
    static void solve0()
    {
        long maxand=0,ans;
        for(int j=0;j<a.length;j++)
        {
            ans=solve(1,j+1,a[j]);
            //System.out.print("Set for: "+ans);
            
        }
        
    }
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        k = in.nextInt();
        a= new long[n];
        for(int a_i=0; a_i < n; a_i++)
        {
            a[a_i] = in.nextLong();
        }
        solve0();
        System.out.println(maxand+"\n"+c);
    }
}