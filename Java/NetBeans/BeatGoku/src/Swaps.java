
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Swaps
{

    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for (int i = 0; i < n; i++)
        {
            a[i] = r.nextInt();
        }
        System.arraycopy(a, 0, b, 0, n);
        Arrays.sort(b);
        int j1 = 0;
        for (int i : a)
        {
            if (i == b[j1])
            {
                j1++;
            }
        }
        //System.arraycopy(a,0,b,0,n);
        int t;
        for (int i = 0; i < n / 2; i++)
        {
            t = b[n - i - 1];
            b[n - i - 1] = b[i];
            b[i] = t;
        }
        int j2 = 0;
        for (int i : a)
        {
            if (i == b[j2])
            {
                j2++;
            }
        }

        System.out.println(j1 > j2 ? n - j1 : n - j2);
    }
}
