import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class BetweenSets {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int[] b = new int[m];
        for(int b_i=0; b_i < m; b_i++)
        {
            b[b_i] = in.nextInt();
        }
        
        HashSet<Integer> h=new HashSet<>();
        
        //x is a factor of all elements in B.
        int p=b[0];
        for(int i=1;i<=p;i++)
        {
            if(p%i==0)
                h.add(i);
        }
        
        int[] k=new int[h.size()];
        int yo=0;
        for(int i:h)
        {
            k[yo]=i;
            yo++;
        }
        
        for(int i:k)
        {
            for(int j:b)
            {
                if(j%i!=0)
                {
                    h.remove(i);
                    break;
                }
            }
        }
        //All elements in A are factors of x.
        
        k=new int[h.size()];
        yo=0;
        for(int i:h)
        {
            k[yo]=i;
            yo++;
        }
        
        
        for(int i:k)
        {
            for(int j:a)
            {
                if(i%j!=0)
                {
                    h.remove(i);
                    break;
                }
            }
        }
        System.out.println(h.size());       
    }
    
}
