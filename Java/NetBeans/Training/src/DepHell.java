
import java.io.*;
import java.util.*;

public class DepHell {

    static int a[][];
    static boolean inst[];
    static int c;
    static ArrayList s;
    static int mapper[];
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner r=new Scanner (System.in);
        int t=r.nextInt();
        while(t-->0)
        {
            int n=r.nextInt(),p=r.nextInt();
            int l;
            c=0;
            a=new int[n+1][];
            inst=new boolean[n+1];
            int b[]=new int[p];
            s=new ArrayList(n);
            mapper=new int[n+1];
            for(int i=1;i<=n;i++)
            {
                l=r.nextInt();
                a[i]=new int[l];
                for(int j=0;j<l;j++)
                {
                    a[i][j]=r.nextInt();
                }
            }
            for(int i=0;i<p;i++)
            {
                b[i]=r.nextInt();
            }
            
            Arrays.sort(b);
            //send to recursed
            for(int i=1;i<=n;i++)
            {
                Arrays.sort(a[i]);
            }
            for(int i=0;i<p;i++)
            {
                //changes-reset Cmin
                installer(b[i],-1);
            }
            
            System.out.println(c);
            s.stream().forEach((i) ->
            {
                System.out.print((int)i+" ");
            });
            
        }
                
    }

    private static int installer(int i,int cmin)
    {
        int cminN=-1,g;
        if(inst[i])
        {
            //changes find i ans set Cmin
            cmin=find(i);
            return cmin;
        }
        
        //sort row i here
        for(int j=0;j<a[i].length;j++)
        {
            g=installer(a[i][j],cmin);
            if(g>cminN)
                cminN=g;
        }
        inst[i]=true;
        //sorted insert in s
        int x=insertIt(i,cminN);
        c++;
        return x;
    }
    private static int insertIt(int m,int cmin)
    {
        int l=s.size();
        for(int i=cmin+1;i<l;i++)
        {
            if(m<(int)s.get(i))
            {
                s.add(i, m);
                mapper[m]=i;
                return i;
            }
        }
        s.add(l,m);
        mapper[m]=l;
        return l;
    }
    private static int find(int m)
    {
        int l=s.size(),i=mapper[m];
        while(i<l)
        {
            if((int)s.get(i)==m)
            {
                mapper[m]=i;
                return i;
            }
            i++;        
        }
        return 2/0;
    }
}