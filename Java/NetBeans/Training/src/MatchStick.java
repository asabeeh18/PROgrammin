import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MatchStick {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        int c = in.nextInt();
        long[][] b = new long[c][2];
        for(int crate_i=0; crate_i < c; crate_i++){
            for(int crate_j=0; crate_j < 2; crate_j++){
                b[crate_i][crate_j] = in.nextLong();
            }
        }
        Arrays.sort(b,new Comparator<long[]>() {
        
      public int compare(long[] o1, long[] o2) 
      {
       return Long.compare(o2[1], o1[1]);
      }
        });
        
        int i=0;
        long x=0;
        while(n>0)
        {
            if(b[i][0]>=n)
            {
                x+=n*b[i][1];
                n-=n;
            }
            else if(b[i][0]<n)
            {
                x+=b[i][0]*b[i][1];
                n-=b[i][0];
            }
            i++;
        }
        System.out.println(x);
    }
}
