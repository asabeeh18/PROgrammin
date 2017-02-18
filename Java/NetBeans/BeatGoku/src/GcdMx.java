import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GcdMx {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n];
        int[][] g=new int[n][n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++){
            b[b_i] = in.nextInt();
        }
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
            {
                g[i][j]=GCD(a[i],b[j]);
            }               
        
        for(int a0 = 0; a0 < q; a0++){
            Set<Integer> s=new HashSet<>();
            int r1 = in.nextInt();
            int c1 = in.nextInt();
            int r2 = in.nextInt();
            int c2 = in.nextInt();
            for(int i=r1;i<=r2;i++)
                for(int j=c1;j<=c2;j++)
                    s.add(g[i][j]);
            System.out.println(s.size());
        }
    }
    public static int GCD(int a, int b) {
   if (b==0) return a;
   return GCD(b,a%b);
}
}
