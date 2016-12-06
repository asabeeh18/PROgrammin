//https://www.hackerrank.com/contests/101hack40/challenges/sherlock-and-dropping-ball
//Now with memoization
import java.io.*;
import java.util.*;

class LineFall {

    static int a[][];
    static int box[];
    static boolean[] boxRem;

    public static void main(String[] args)
    {
        Scanner r = new Scanner(System.in);
        int n = r.nextInt();
        int q = r.nextInt();
        a = new int[2 * n][2];
        box = new int[n];
        boxRem=new boolean[n];
        Arrays.fill(boxRem, false);
        
        int x1, y1, x2, y2;
        for (int i = 0; i < 2 * n; i += 2)
        {
            x1 = r.nextInt();
            y1 = r.nextInt();
            x2 = r.nextInt();
            y2 = r.nextInt();
            if (y2 < y1)
            {
                a[i][0] = x2;
                a[i][1] = y2;
                a[i + 1][0] = x1;
                a[i + 1][1] = y1;
            } else
            {
                a[i][0] = x1;
                a[i][1] = y1;
                a[i + 1][0] = x2;
                a[i + 1][1] = y2;
            }
        }
        for (int i = 0; i < q; i++)
        {
            int x = r.nextInt();
            int y = r.nextInt();
            System.out.println(fall(x, y));
        }
    }

    private static int fall(int x, int y)
    {
        
        ArrayList<Integer> sx = xRangeCheck(x); //indices of lines
        if (sx.size() == 0)
        {
            return x;
        }
        int sy = fallCheck(sx, x, y); //includes belowCheck, index of line
        if (sy < 0)
        {
            return x;
        }
        if(boxRem[sy/2])
            return box[sy/2];
        x = a[sy][0];
        y = a[sy][1];
        
        
        box[sy/2]=fall(x, y);
        boxRem[sy/2]=true;
        
        return box[sy/2];
    }

    private static ArrayList<Integer> xRangeCheck(int x)
    {
        //int lines[] = new int[a.length / 2];
        ArrayList<Integer> lines=new ArrayList<>();
        int max, min, top = 0;
        for (int i = 0; i < a.length; i += 2)
        {
            max = a[i][0];
            min = a[i + 1][0];
            if (max >= min)
            {
                if (x < max && x >= min)
                {
                    lines.add(i);
                }
            } else
            {
                if (x <= min && x > max)
                {
                    lines.add(i);
                }
            }
        }
        return lines;
    }

    private static int fallCheck(ArrayList<Integer> sx, int x, int y)
    {
        int topper = -1;
        double topsect = (double)Long.MIN_VALUE;

        for (int i = 0; i < sx.size(); i++)
        {
            int r = sx.get(i);
            double intersect = a[r + 1][1] + (x - a[r + 1][0]) * ((double) a[r][1] - a[r + 1][1]) / (a[r][0] - a[r + 1][0]);
            if (intersect <= y && intersect > topsect)
            {
                topper = r;
                topsect = intersect;
            }
        }
        return topper;
    }
}
 