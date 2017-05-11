
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Glyph
{
    /*
     * Complete the function below.
     */

    public static int appearanceCount(int m, int n, String p, String s)
    {
        HashMap<Character, Integer> a = new HashMap<>();
        HashMap<Character, Integer> b = new HashMap<>();
        for (char c : p.toCharArray())
        {
            if (a.containsKey(c))
            {
                int x = a.get(c);
                a.put(c, x + 1);
            } else
            {
                a.put(c, 1);
                b.put(c, 0);
            }
        }
        int w = 0;
        int co=0;
        char c[]=s.toCharArray();
        for (int i=0;i<n;i++)
        {
            if(a.containsKey(c[i]))
            {
                int x=a.get(c[i]);
                int y=b.get(c[i]);
                b.put(c[i],y+1);
                if(y<x)
                    w++;
                if(w==m)
                {
                    co++;
                }
            }
            if((i+1)>=m)
            {
                i++;
                if(b.containsKey(c[i-m]))
                {
                    int x=b.get(c[i-m]);
                    b.put(c[i-m], x-1);
                    if(x<=a.get(c[i-m]))
                        w--;
                }
                i--;
            }
        }
        return co;
    }

    public static void main(String[] args) throws IOException
    {
        Scanner in = new Scanner(System.in);
        int output = 0;
        int ip1 = Integer.parseInt(in.nextLine().trim());
        int ip2 = Integer.parseInt(in.nextLine().trim());
        String ip3 = in.nextLine().trim();
        String ip4 = in.nextLine().trim();
        output = appearanceCount(ip1, ip2, ip3, ip4);
        System.out.println(String.valueOf(output));
    }
}
