import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Poles {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        long x[]=new long[n];
        long[] w=new long[n],p=new long[n];
        int[] pre=new int[n],post=new int[n];
        for(int a0 = 0; a0 < n; a0++)
        {
            x[a0] = in.nextInt();
            w[a0] = in.nextInt();
            if(a0>0)
            {
                p[a0]=w[a0]*(x[a0]-x[a0-1]);
            }
            pre[a0]=a0-1;
            post[a0]=a0+1;
        }
        p[0]=Long.MAX_VALUE;
        long c=0;
        int last=n-1;
        for(int i=0;i<n-k;i++)
        {
            //select movmnt
            int min=0;
            for(int j=1;j<n;j++)
            {
                if(p[j]<p[min])
                    min=j;
            }
            
            //update to reflect changes
            c+=p[min];
            p[min]=Long.MAX_VALUE;
            //update dest
            if(pre[min]>0)  //only if dest is not first
            {
                w[pre[min]]+=w[min];
                p[pre[min]]=w[pre[min]]*(x[pre[min]]-x[pre[pre[min]]]);
                
            }
            //update side effects
            if(min<last)
                p[post[min]]=w[post[min]]*(x[post[min]]-x[pre[min]]);
            else if(min==last)
                last=pre[min];
            //updat pre post
            if(min<last)
                pre[post[min]]=pre[min];
            if(min<last)
                post[pre[min]]=post[min];
        }
        System.out.println(c);
    }
}
