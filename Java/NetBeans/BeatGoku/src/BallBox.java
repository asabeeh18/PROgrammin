import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BallBox {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] a = new int[n][n];
            int[] ball=new int[n];
            int box[]=new int[n];
            for(int M_i=0; M_i < n; M_i++){
                for(int M_j=0; M_j < n; M_j++){
                    a[M_i][M_j] = in.nextInt();
                    box[M_i]+=a[M_i][M_j];
                    ball[M_j]+=a[M_i][M_j];
                }
            }
            boolean f=false;
            for(int i=0;i<n;i++)
            {
                int s=ball[i];
                f=false;
                for(int j=0;j<n;j++)
                {
                        if((box[j]-a[j][i])==(s-a[j][i]))
                        {
                            f=true;
                            break;    
                        }           
                }
                if(!f)
                    break;
            }
            if(f)
                System.out.println("Possible");
            else
                System.out.println("Impossible");
        }
    }
}
