
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Snake2 {

    static int[][] a;
    //static long[][] box;
    static long exitMax[];
	//box array can be reduced to 3 1d arrays
    // doing with 1 1d array and 1 2d array ;
    static boolean[] entry, entryOld;

    public static void main(String ar[]) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String s[] = r.readLine().split(" ");
        int n = Integer.parseInt(s[0]);
        int m = Integer.parseInt(s[1]);
        a = new int[n+1][m+1];	//fake last row is -infinite row
      //  box = new int[m+1][n+1];
        exitMax = new long[n+1];
        entry = new boolean[n+2];
        
        boolean[] entryNext=new boolean[n+2];
        //init
        Arrays.fill(entry, true);
        // v seems a bit useless now 
        Arrays.fill(a[n], Integer.MIN_VALUE);
        for (int i = 1; i <= n; i++)
        {
            s = r.readLine().split(" ");
            for (int j = 1; j <= m; j++)
            {
                a[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        //start
        for (int i = 1; i <= m; i++)
        {
            long[] up = new long[n + 1], down = new long[n + 1];
            boolean entryNew[] = new boolean[n + 2];
            //down
            boolean teleport=false;
            for (int j = 1; j <= n; j++)
            {
                if (a[j][i] != -1 && (entry[j] | entryNew[j]))
                {
                    down[j] = Math.max(down[j - 1] + a[j][i], exitMax[j] + a[j][i]);
                    entryNew[j + 1] = true;
                    entryNext[j] = true;
                } else
                {
                    entryNext[j] = false|entryNext[j];
                    entryNew[j + 1] = false | entry[j + 1];
                    continue;
                }
                if (j == n && (entry[j] | entryNew[j]) && a[j][i] != -1)
                {
                    teleport = true;
                    break;
                }
            }
            //teleseq
            long[] tele = new long[n + 1];
            if (teleport)
            {
                int j = 1;
                
                while (j <= n && a[j][i] != -1 )
                {
                    tele[j] = tele[j - 1] + a[j][i];
                    entryNext[j] = true;
                    j++;
                }
            }
            down = returnMax(down, tele);

            //up
            teleport = false;
            entryNew = new boolean[n + 1];
            for (int j = n - 1; j >= 0; j--)
            {
                if (a[j+1][i] != -1 && (entry[j+1] | entryNew[j+1]))
                {
                    up[j] = Math.max(up[j + 1] + a[j+1][i], exitMax[j + 1] + a[j+1][i]);
                    entryNew[j] = true;
                    entryNext[j+1] = true;
                } else
                {
                    entryNext[j+1] = false|entryNext[j+1];
                    entryNew[j] = false | entry[j];
                    continue;
                }
                if (j == 0 && (entry[j + 1] | entryNew[j]) && a[j+1][i] != -1)
                {
                    teleport = true;
                    break;
                }
            }
            //teleseq
            tele = new long[n + 1];
            if (teleport)
            {
                int j = n - 1;
                
                while ( j >= 0 && a[j+1][i] != -1 )
                {
                    tele[j] = tele[j + 1] + a[j][i];
                    entryNext[j+1] = true;
                    j--;
                }
            }
            System.arraycopy(returnMax(up, tele), 0, up, 1, up.length - 1);
            System.arraycopy(entryNext,0,entry,0,entry.length);
            Arrays.fill(entryNext, false);
            exitMax = returnMax(up, down);
        }

        //find max exit val
        long max = -1;
        for (int i = 0; i < exitMax.length; i++)
        {
            if (exitMax[i] > max && entry[i])
            {
                max = exitMax[i];
            }
        }
        System.out.println(max);
    }

    //Go up AND down while adding points
    public static long[] returnMax(long a[],long b[])
    {
        if(a.length!=b.length)
            throw new NegativeArraySizeException("Size Mismatch");
        //int c[]=new int[a.length];
        for(int i=0;i<a.length;i++)
        {
            if(b[i]>a[i])
                a[i]=b[i];
            
        }
        return a;
    }
}
