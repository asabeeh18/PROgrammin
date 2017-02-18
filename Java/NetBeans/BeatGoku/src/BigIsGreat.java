import java.io.*;
import java.util.*;

public class BigIsGreat {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner r=new Scanner(System.in);
        int t=r.nextInt();
        r.nextLine();
        while(t-->0)
        {
            char s[]=r.nextLine().toCharArray();
            //System.out.println("-"+s);
            boolean big=false;
            int n=s.length-1;
            while(!big && n>=1)
            {
                //System.out.println((s.charAt(n)>s.charAt(n-1))+":"+s.charAt(n)+":"+s.charAt(n-1));
                for(int i=n-1;i>=0;i--)
                {    
                    if(s[n]>s[i])
                    {
                        big=true;
                        char p=s[n];
                        s[n]=s[i];
                        s[i]=p;
                        Arrays.sort(s,i+1,s.length);
                           
                        
                        break;
                    }
                    
                }
                n--;
            }
            if(!big)
                System.out.println("no answer");
            else
                System.out.println(new String(s));
        }
    }
}