import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

    public static void main(String ar[]) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String inputString[] = r.readLine().split(" ");
        int n = Integer.parseInt(inputString[0]);
        int m = Integer.parseInt(inputString[1]);

        int[][] maze = new int[n + 1][m + 1];	//fake last row is -infinite row
        long[] exitMax = new long[n + 1];
        boolean[] canEnter = new boolean[n + 2];    //ONLY READ. write at end of loop
        boolean[] entryHorizontal = new boolean[n + 2];
        boolean canEnterNext = true;    //Early Terminator
        //init
        Arrays.fill(canEnter, true);
        // seems a bit useless now 
        Arrays.fill(maze[n], Integer.MIN_VALUE);
        for (int i = 1; i <= n; i++)
        {
            inputString = r.readLine().split(" ");
            for (int j = 1; j <= m; j++)
            {
                maze[i][j] = Integer.parseInt(inputString[j - 1]);
            }
        }

        //start
        for (int i = 1; i <= m && canEnterNext; i++)
        {
            canEnterNext = false;
            long[] up = new long[n + 1], down = new long[n + 1];
            boolean[] entryVertical = new boolean[n + 2];
            //down
            boolean teleport = false;
            for (int j = 1; j <= n; j++)
            {
                if (maze[j][i] != -1 && (canEnter[j] | entryVertical[j]))
                {
                    down[j] = Math.max(down[j - 1] + maze[j][i], exitMax[j] + maze[j][i]);
                    entryVertical[j + 1] = true;
                    entryHorizontal[j] = true;
                    canEnterNext = true;
                } else
                {
                    entryHorizontal[j] = false | entryHorizontal[j];
                    entryVertical[j + 1] = false | canEnter[j + 1];
                    continue;
                }
                if (j == n && (canEnter[j] | entryVertical[j]) && maze[j][i] != -1)
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

                while (j <= n && maze[j][i] != -1)
                {
                    tele[j] = tele[j - 1] + maze[j][i];
                    entryHorizontal[j] = true;
                    j++;
                }
            }
            down = returnMax(down, tele);

            //up
            teleport = false;
            entryVertical = new boolean[n + 1];
            for (int j = n - 1; j >= 0; j--)
            {
                if (maze[j + 1][i] != -1 && (canEnter[j + 1] | entryVertical[j + 1]))
                {
                    up[j] = Math.max(up[j + 1] + maze[j + 1][i], exitMax[j + 1] + maze[j + 1][i]);
                    entryVertical[j] = true;
                    entryHorizontal[j + 1] = true;
                    canEnterNext = true;
                } else
                {
                    entryHorizontal[j + 1] = false | entryHorizontal[j + 1];
                    entryVertical[j] = false | canEnter[j];
                    continue;
                }
                if (j == 0 && (canEnter[j + 1] | entryVertical[j]) && maze[j + 1][i] != -1)
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

                while (j >= 0 && maze[j + 1][i] != -1)
                {
                    tele[j] = tele[j + 1] + maze[j][i];
                    entryHorizontal[j + 1] = true;
                    j--;
                }
            }
            //for the next iteration
            System.arraycopy(returnMax(up, tele), 0, up, 1, up.length - 1);
            System.arraycopy(entryHorizontal, 0, canEnter, 0, canEnter.length);
            Arrays.fill(entryHorizontal, false);
            exitMax = returnMax(up, down);
        }

        //find max exit val
        long max = -1;
        for (int i = 0; i < exitMax.length; i++)
        {
            if (exitMax[i] > max && canEnter[i])
            {
                max = exitMax[i];
            }
        }
        System.out.println(max);

    }

    //Go up AND down while adding points
    public static long[] returnMax(long a[], long b[])
    {
        for (int i = 0; i < a.length; i++)
        {
            if (b[i] > a[i])
            {
                a[i] = b[i];
            }

        }
        return a;
    }
}