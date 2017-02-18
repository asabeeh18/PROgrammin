
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ValidString
{

    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner r = new Scanner(System.in);
        int a[] = new int[26];
        Arrays.fill(a, 0);
        char[] s = r.nextLine().toCharArray();
        for (char i : s)
        {
            a[i - 'a']++;
        }
        int n = -1;
        boolean issue = false, set = false;
        for (int i : a)
        {
            if (i == 0)
            {
                continue;
            } else
            {
                if (n == -1)
                {
                    n = i;
                    continue;
                } else if (Math.abs(n - i) == 1)
                {
                    if (set)
                    {
                        issue = true;
                        break;
                    }
                    set = true;
                    continue;
                } else if (set || Math.abs(n - i) > 1)
                {
                    issue = true;
                    break;
                }

            }
        }
        System.out.println(issue ? "NO" : "YES");
    }
}
