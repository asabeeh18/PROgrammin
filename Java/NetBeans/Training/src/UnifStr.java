import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class UnifStr {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int n = in.nextInt();
       
       
        int l=s.length();
        int k=0;
        int f[][]=new int[l][2];
        for(int i=0;i<l;)
        {
            char x=s.charAt(i);
            i++;
            int c=1;
            while(i<l && x==s.charAt(i))
            {
                i++;
                c++;
            }
            f[k][0]=(int)x-(int)'a'+1;
            f[k][1]=c;
            
            //System.out.println(f[k][0]+":"+f[k][1]);
            k++;
        }
        lo:for(int a0 = 0; a0 < n; a0++){
            int x = in.nextInt();
            
            for(int i=0;i<k;i++)
            {
                if(x%f[i][0]==0 && x/f[i][0]<=f[i][1])
                {
                    System.out.println("Yes");
                    continue lo;
                }    
            }
            System.out.println("No");
        }
    }
}
