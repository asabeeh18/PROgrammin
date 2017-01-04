import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Candies {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] c = new int[n];
        for(int c_i=0; c_i < n; c_i++){
            c[c_i] = in.nextInt();
        }
        int min1=0,min2=0,co=1;
        for(int i=1;i<n;i++)
        {
            if(c[min1]>c[i])
            {
        //        min2=min1;
                min1=i;
                co=1;
            }
            else if(c[min1]==c[i])
                co++;
        }
        c[min1]*=2;
        if(co>1)
            co=n;
        for(int i=0;i<n;i++)
        {
            if(c[min2]>c[i])
                min2=i;
        }
        System.out.println(c[min2]+" "+co);
    }
}
