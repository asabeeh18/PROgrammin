import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AttackQueen {
    static HashSet<Integer> h;
    static int d;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rq = in.nextInt();
        int cq = in.nextInt();
        d=(int)Math.pow(10,Math.floor(Math.log(n)));
        long c=0;
        h=new HashSet<>();
        
        for(int a0 = 0; a0 < k; a0++){
            int rO = in.nextInt();
            int cO = in.nextInt();
            h.add(rO*d+cO);
        }
        
        c+=counter(rq,cq,-1,0,n);
        c+=counter(rq,cq,1,0,n);
        c+=counter(rq,cq,0,-1,n);
        c+=counter(rq,cq,0,1,n);
        
        c+=counter(rq,cq,-1,-1,n);
        c+=counter(rq,cq,1,1,n);
        c+=counter(rq,cq,1,-1,n);
        c+=counter(rq,cq,-1,1,n);
        System.out.println(c);
    }
    private static long counter(int x,int y,int a,int b,int n)
    {
        long c=0;
        x+=a;
        y+=b;
            
        while(x<=n && x>0 && y<=n && y>0 && !h.contains(x*d+y))
        {
            c++;
            x+=a;
            y+=b;
        }
        return c;
    }
}
