import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Ladybug {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int Q = in.nextInt();
        for(int a0 = 0; a0 < Q; a0++)
        {
            int n = in.nextInt();
            String b = in.next();
            int c[]=new int[26];
            Arrays.fill(c,0);
            boolean space=false,dec=true;
            for(int i=0;i<n;i++)
            {
                if(b.charAt(i)=='_')
                    space=true;
                else
                    c[b.charAt(i)-'A']++;
            }
            if(!space)
            {
                char prev=b.charAt(0);
                for(int i=1;i<n-1;i++)
                {
                    if(!(b.charAt(i)==b.charAt(i-1) || b.charAt(i)==b.charAt(i+1)))
                     {
                        dec=false;
                        break;
                     }
                }
                if(dec && n>2)
                {
                    if(b.charAt(0)==b.charAt(1) && b.charAt(n-1)==b.charAt(n-2));
                    else
                        dec=false;
                }
            }
            if(dec)
            {
                for(int i=0;i<c.length;i++)
                if(c[i]==1)
                {
                    dec=false;
                    break;
                }
            }
            if(dec)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
