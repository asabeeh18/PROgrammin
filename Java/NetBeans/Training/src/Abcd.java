import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Abcd {

    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // Return the number of non-empty perfect subsequences mod 1000000007
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++)
        {
            long[] a=new long[4];
            String s = in.next();
            for(char c:s.toCharArray())
            {
                a[c-'a']=a[c-'a']+1;
            }
            
            System.out.println(((a[0]*a[1]+1)*(a[2]*a[3]+1)-1)%1000000007);
        }
    }
}
