import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Sv {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long n = in.nextLong();
            if(rec(n))
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    private static boolean rec(long n)
    {
        if(n<0)
            return false;
        if(n==4 || n==7 || n==0)
            return true;
        if(rec(n-4) || rec(n-7))
            return true;
        return false;
    }
}