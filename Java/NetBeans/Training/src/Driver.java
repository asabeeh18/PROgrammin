import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Driver {

    public static void main(String ar[]) throws IOException
    {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(r.readLine());
        while (t-- > 0)
        {
            String s[] = r.readLine().split(" ");
            int n = Integer.parseInt(s[0]);
            long p = Long.parseLong(s[1]);
            long q = Long.parseLong(s[2]);
            s = r.readLine().split(" ");
            int a[] = new int[n];
            for (int i = 0; i < n; i++)
            {
                a[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(a);
            int count = 0;
            for (int i = 0; i < n; i++)
            {
                if (a[i] % 2 != 0)
                {
                    if (q - a[i] / 2 >= 0)
                    {
                        if (p >= 1)
                        {
                            q -= a[i] / 2;
                            p--;
                            count++;
                        } else
                        {
                            continue;
                        }
                    } 
                    else if (p - a[i] >= 0)
                    {
                        p -= a[i];
                        count++;
                    } else
                    {
                        continue;
                    }
                } else
                {
                    if (q - a[i] / 2 >= 0)
                    {
                        q -= a[i] / 2;
                        count++;
                    } else if (p - a[i] >= 0)
                    {
                        p -= a[i];
                        count++;
                    } else
                    {
                        continue;
                    }
                }

            }
            System.out.println(count);
        }
    }
}
