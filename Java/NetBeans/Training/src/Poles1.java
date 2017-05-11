import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Poles1 {
    public static class Pole{
        long x,w,cost;
        public Pole(long x1,long w1)
        {
            x=x1;
            w=w1;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        
        LinkedList<Pole> ll=new LinkedList<>();
        for(int a0 = 0; a0 < n; a0++)
        {
            ll.add(new Pole(in.nextLong(),in.nextLong()));    
        }
        
        long co=0;
        for(int i=0;i<n-k;i++)
        {
            //ListIterator li=ll.listIterator(0);
            
            Long min=Long.MAX_VALUE;
            int mini=0;
            Pole m=null;
            for(int j=1;j<ll.size();j++)
            { 
                Pole c=ll.get(j);
                Pole p=ll.get(j-1);
                if(c.w*(c.x-p.x)<min)
                {
                    min=c.w*(c.x-p.x);
                    mini=j;
                    m=c;
                }
            }
            
            
            //update to reflect changes
            co+=min;
            //remove here
            //update dest
            if(mini>0)  //only if dest is not first
            {
                Pole p=ll.get(mini-1);
                ll.set(mini-1,new Pole(p.x,m.w+p.w));
            }
            ll.remove(mini);
        }
        
        
        System.out.println(co);
    }
}