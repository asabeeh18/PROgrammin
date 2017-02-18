
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ECEWorld
{

    static int[] a, max;

    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        int m = r.nextInt();
        int[] robo = new int[n + 1];
        a = new int[n + 1];
        max = new int[n + 1];
        for (int i = 1; i <= n; i++)
        {
            robo[i] = r.nextInt();
            max[i] = robo[i];
            a[i] = i;
        }
        int a, b;
        for (int i = 0; i < m; i++)
        {
            a = r.nextInt();
            b = r.nextInt();
            merge(a, b);
        }
        long sum = 0;
        for (int i = 1; i <= n; i++)
        {
            System.out.println(max[i] + ",");
            sum += max[i];
        }
        System.out.println(sum);
    }

    public static int find(int x)
    {
        if (a[x] != x)
        {
            a[x] = find(a[x]);
        }
        return a[x];
    }

    public static void merge(int x, int y)
    {
        int xx = find(x), yy = find(y);

        //System.out.println(yy+":"+xx);
        if (xx > yy)
        {
            a[xx] = yy;
            if (max[xx] > max[yy])
            {
                max[yy] = max[xx];
                max[xx] = 0;
            } else
            {
                max[xx] = 0;
            }
        } else if (yy > xx)
        {
            a[yy] = xx;
            if (max[yy] > max[xx])
            {
                max[xx] = max[yy];
                max[yy] = 0;
            } else
            {
                max[yy] = 0;
            }
        }
        //System.out.println(yy+":"+a[xx]);
    }
}
