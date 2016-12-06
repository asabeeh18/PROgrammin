import java.io.*;
import java.util.*;

public class Lock {

    public static void main(String[] args) {
        Scanner r=new Scanner(System.in);
        int a[]=new int[5];
        int sum=0,s;
        for(int i=0;i<5;i++)
            a[i]=r.nextInt();
        for(int i=0;i<5;i++)
        {
            int t=r.nextInt();
            
            if(t==a[i])
                continue;
            if(t>a[i])
            {
                s=9-t+1+a[i];
            }
            else
            {
                s=9+t+1-a[i];
            }
            if(Math.abs(t-a[i]) < ( s ))
            {
                sum+=Math.abs(t-a[i]);
            }
            else
                sum+=s;
            
        }
        System.out.println(sum);
        
    }
}