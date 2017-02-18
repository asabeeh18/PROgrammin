import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BoxOp
{

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        for (int box_i = 0; box_i < n; box_i++)
        {
            a[box_i] = in.nextInt();
        }
        while (q-- > 0)
        {
            int ch = in.nextInt();
            int l=in.nextInt();
            int r=in.nextInt();
            int c;
            switch (ch)
            {
                case 1:
                        c=in.nextInt();
                        System.out.println(add(l,r,c));
                        break;
                case 2:
                        c=in.nextInt();
                        div(l,r,c);
                        break;
                case 3:
                        min(l,r);
                        break;
                case 4:
                        print(l,r);
                        break;
            }
        }
        // your code goes here
    }
}
