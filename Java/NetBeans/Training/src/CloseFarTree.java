/*
 assuming big index nodes come after smaller ones
 LCA
 sequential processing
 i,j interval store max and min diff

 TODO later : RMQ "Must"
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

class CloseFarTree {

    public static void main(String ar[]) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(r.readLine());

        int[] a = new int[n+1];
        int parent[] = new int[n+1];
        String[] s = r.readLine().split(" ");

        for (int i = 1; i <= n; i++)
        {
            a[i] = Integer.parseInt(s[i-1]);
        }

        for (int i = 0; i < n - 1; i++)
        {
            s = r.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);
            if (x < y)
            {
                parent[y] = x;
            } else
            {
                parent[x] = y;
            }
        }
        int q = Integer.parseInt((r.readLine().split(" "))[0]);
        while (q-- > 0)
        {
            s = r.readLine().split(" ");

            int x = Integer.parseInt(s[1]);
            int y = Integer.parseInt(s[2]);
            int valX[] = new int[n+2];
            int valY[] = new int[n+2];
            int val[] = new int[n+2];
            HashSet<Integer> s1 = new HashSet<>();

            valX[0] = a[x];
            valY[0] = a[y];
            s1.add(a[x]);
            s1.add(a[y]);
            int ix=1,iy=1;

            int xbroke=-1,ybroke=-1;
            while (x!=1 && y!=1)
            {
                if(!s1.add(parent[x]))
                {
                    xbroke=parent[x];
                    break;
                }
                valX[ix] = a[parent[x]];
                ix++;
                
                if(!s1.add(parent[y]))
                {
                    ybroke=parent[y];
                    break;
                }
                valY[iy] = a[parent[y]];
                iy++;
                
                x = parent[x];
                y = parent[y];
            }
            //If one reached root while other is still below
            if(x==1)
            {
                while(s1.add(parent[y]))
                {
                    valY[iy] = a[parent[y]];
                    y=parent[y];
                    iy++;
                }   
            }
            else if(y==1)
            {
                while(s1.add(parent[x]))
                {
                    valX[ix] = a[parent[x]];
                    x=parent[x];
                    ix++;
                }   
            }
            
            //Extra eliminator
            if(xbroke>=0)
            {
                //reduce Y
                System.arraycopy(valX, 0, val, 0, ix);
                int d=a[parent[xbroke]];
                
                for(int i=0;valY[i]!=d && i<iy;i++,ix++)
                {
                    val[ix]=valY[i];
                }
            }
            else if(ybroke>=0)
            {
                //reduce Y
                System.arraycopy(valY, 0, val, 0, iy);
                int d=a[parent[ybroke]];
                
                for(int i=0;valX[i]!=d && i<ix;i++,iy++)
                {
                    val[iy]=valX[i];
                }
                ix=iy;
            }
            else
            {
                System.arraycopy(valX, 0, val, 0, ix);
                System.arraycopy(valY, 0, val, ix, iy);
                ix+=iy;
            }
            
            //close and far
            if (s[0].charAt(0) == 'C')
            {
                Arrays.sort(val, 0, ix);
                int diff = Integer.MAX_VALUE;
                for (int j = 0; j < ix-1; j++)
                {
                    if (diff > Math.abs(val[j] - val[j + 1]))
                    {
                        diff = Math.abs(val[j] - val[j + 1]);
                    }
                }
                System.out.println(diff+"");

            } else
            {
                int max=Integer.MIN_VALUE;
                int min=Integer.MAX_VALUE;
                for(int j=0;j<ix;j++)
                {
                    if(min>val[j])
                        min=val[j];
                    if(max<val[j])
                        max=val[j];
                }
                System.out.println(max-min+"");
            }
        }

    }
}
