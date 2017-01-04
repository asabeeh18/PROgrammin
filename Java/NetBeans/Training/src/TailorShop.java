//https://www.hackerrank.com/contests/w27/challenges/tailor-shop/submissions/code/8222075
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class TailorShop {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        Arrays.sort(a);
        long but[]=new long[n];
        long sum=0;
        for(int i=0;i<n;i++)
        {
            but[i]=(long)Math.ceil(a[i]/(float)p);
            if(i>0 && but[i]<=but[i-1])
                but[i]=but[i-1]+1;
            sum+=but[i];
        }
        
        System.out.println(sum);
        // your code goes here
    }
}
