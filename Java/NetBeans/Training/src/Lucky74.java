import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Lucky74 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            long n = in.nextLong();
            
            
            if(n<=0)
            {
                System.out.println("No");
                continue;
            }
            if((n%7==1 || n%7==5 || n%7==4 || n%4L==3L || n%7L==0L || n%4==0) && (n!=1 && n!=5 && n!=3))
                System.out.println("Yes");
            else
                System.out.println("No");
                
        }
        
    }
}
