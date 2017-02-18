//https://www.hackerrank.com/challenges/acm-icpc-team

import java.util.*;

class Team
{

    public static void main(String args[])
    {
        Scanner src = new Scanner(System.in);
        int n = src.nextInt();
        int m = src.nextInt();
        src.nextLine();
        BitSet p[] = new BitSet[n];
        for(int i=0;i<n;i++)
            p[i]=new BitSet(m);
        for (int i = 0; i < n; i++)
        {
            
            String s=src.nextLine();
            for(int j=0;j<m;j++)
            {
                if(s.charAt(j)=='1')
                    p[i].set(j);
            }
        }
        
        long max = 0, co = 0;

        for (int i = 0; i < n; i++)
        {
            
            for (int j = i + 1; j < n; j++)
            {
                BitSet b=(BitSet)p[i].clone();
                b.or(p[j]);
                int c=b.cardinality();
                if (c > max)
                {
                    max =c;
                    co=0;
                }
                if(c==max)
                    co++;
            }
        }
        System.out.println(max + "\n" + co);
    }
}
